package org.example.Service;

import com.google.common.io.ByteSource;
import java.io.*;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.imageio.ImageIO;
import lombok.Getter;
import lombok.SneakyThrows;
import org.apache.commons.compress.utils.IOUtils;
import org.example.Models.*;
import org.openstreetmap.gui.jmapviewer.Coordinate;

@Getter
public class DBConnection {
    private final Connection connection;

    @SneakyThrows
    public DBConnection() {
        Properties properties = new Properties();
        properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        String URL = properties.getProperty("DATABASE_URL");
        String USERNAME = properties.getProperty("USERNAME");
        String PASSWORD = properties.getProperty("PASSWORD");
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    @SneakyThrows
    private InputStream serializeObject(Object object) {
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bao);
        out.writeObject(object);
        out.close();

        byte[] byteObject = bao.toByteArray();

        return ByteSource.wrap(byteObject).openStream();
    }

    @SneakyThrows
    private Object deSerializeObject(InputStream inputStream) {
        byte[] byteObject = IOUtils.toByteArray(inputStream);
        ByteArrayInputStream bai = new ByteArrayInputStream(byteObject);
        ObjectInputStream is = new ObjectInputStream(bai);

        return is.readObject();
    }

    @SneakyThrows
    public void getMarkers(OSMMap map) {
        String query = "SELECT * FROM markers";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            ExpMapMarker marker = new ExpMapMarker(
                    resultSet.getString("name"),
                    new Coordinate(resultSet.getDouble("lat"), resultSet.getDouble("lon")));
            marker.setCreated(true);
            marker.setDescription(resultSet.getString("description"));
            marker.setLocation((LocationReverse) deSerializeObject(resultSet.getBinaryStream("location")));

            map.addMapMarker(marker);
        }
    }

    @SneakyThrows
    public void addMarker(ExpMapMarker marker) {
        double lat = marker.getLat();
        double lon = marker.getLon();
        String name = marker.getName();
        String description = marker.getDescription();
        LocationReverse location = marker.getLocation();

        String query = "INSERT INTO markers (lat, lon, name, description, location) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setDouble(1, lat);
        preparedStatement.setDouble(2, lon);
        preparedStatement.setString(3, name);
        preparedStatement.setString(4, description);
        preparedStatement.setBinaryStream(5, serializeObject(location));

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @SneakyThrows
    public void deleteMarker(ExpMapMarker marker) {
        String query = "DELETE FROM markers WHERE lat = ? AND lon = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setDouble(1, marker.getLat());
        preparedStatement.setDouble(2, marker.getLon());

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @SneakyThrows
    public List<Friend> getFriends() {
        List<Friend> friends = new ArrayList<>();
        String query = "SELECT * FROM friends";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Friend friend;
            String pictureURL = resultSet.getString("imagepath");
            if (pictureURL != null) {
                friend = new Friend(resultSet.getString("nickname"), resultSet.getString("name"), pictureURL);
                if (friend.getProfilePicture() == null) {
                    friend = new Friend(resultSet.getString("nickname"), resultSet.getString("name"));
                } else {
                    friend.setImageURLPath(pictureURL);
                }
            } else {
                friend = new Friend(resultSet.getString("nickname"), resultSet.getString("name"));
            }
            friend.setDescription(resultSet.getString("description"));
            friends.add(friend);
        }

        return friends;
    }

    @SneakyThrows
    public void addFriend(Friend friend) {
        String query = "INSERT INTO friends (nickname, name, description, imagepath) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, friend.getNickname());
        preparedStatement.setString(2, friend.getName());
        preparedStatement.setString(3, friend.getDescription());
        preparedStatement.setString(4, friend.getImageURLPath());

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @SneakyThrows
    public void deleteFriend(Friend friend) {
        String query = "DELETE FROM friends WHERE nickname = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, friend.getNickname());

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @SneakyThrows
    public List<Meeting> getMeetings() {
        List<Meeting> meetings = new ArrayList<>();
        String query = "SELECT * FROM meetings";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Meeting meeting = new Meeting(
                    (List<Friend>) deSerializeObject(resultSet.getBinaryStream("attendingfriends")),
                    (MeetingExpMapMarker) deSerializeObject(resultSet.getBinaryStream("location")),
                    resultSet.getDate("date").toLocalDate(),
                    resultSet.getTime("time").toLocalTime());
            meeting.setIsFinished(resultSet.getBoolean("finished"));
            for (Friend friend : meeting.getAttendingFriends()) {
                if (friend.getImageURLPath() != null) {
                    friend.setProfilePicture(ImageIO.read(new URL(friend.getImageURLPath())));
                } else {
                    friend.setProfilePicture(ImageIO.read(new File(friend.getDefaultImagePath())));
                }
            }
            if (meeting.getMeetingDate().isBefore(LocalDate.now())) {
                meeting.setIsFinished(true);
            }
            meetings.add(meeting);
        }

        return meetings;
    }

    @SneakyThrows
    public void addMeeting(Meeting meeting) {
        Statement statement = connection.createStatement();
        String getMaxIdQuery = "SELECT MAX(idmeetings) FROM meetings";
        ResultSet resultSet = statement.executeQuery(getMaxIdQuery);

        int lastRowId = 0;
        if (resultSet.next()) {
            lastRowId = resultSet.getInt(1);
        }
        resultSet.close();

        int newID = lastRowId + 1;

        String query =
                "INSERT INTO meetings (idmeetings, attendingfriends, location, date, time, finished) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        Date date = Date.from(
                meeting.getMeetingDate().atStartOfDay(ZoneId.systemDefault()).toInstant());

        System.out.println("Friends in DB: " + meeting.getAttendingFriends());

        preparedStatement.setInt(1, newID);
        preparedStatement.setBinaryStream(2, serializeObject(meeting.getAttendingFriends()));
        preparedStatement.setBinaryStream(3, serializeObject(meeting.getMeetingLocation()));
        preparedStatement.setDate(4, new java.sql.Date(date.getTime()));
        preparedStatement.setTime(5, Time.valueOf(meeting.getMeetingTime()));
        preparedStatement.setBoolean(6, meeting.getIsFinished());

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @SneakyThrows
    public void closeConnection() {
        connection.close();
    }
}
