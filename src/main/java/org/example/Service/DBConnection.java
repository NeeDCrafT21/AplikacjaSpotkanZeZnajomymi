package org.example.Service;

import com.google.common.io.ByteSource;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import lombok.SneakyThrows;
import org.apache.commons.compress.utils.IOUtils;
import org.example.Models.*;
import org.openstreetmap.gui.jmapviewer.Coordinate;

public class DBConnection {
    private final Connection connection;

    @SneakyThrows
    public DBConnection() {
        String URL = "jdbc:mysql://localhost:3306/edp";
        String USERNAME = "root";
        String PASSWORD = "root";
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
            Friend friend = new Friend(resultSet.getString("nickname"), resultSet.getString("name"));
            friend.setDescription(resultSet.getString("description"));
        }

        return friends;
    }

    @SneakyThrows
    public void addFriend(Friend friend) {
        String query = "INSERT INTO friends (nickname, name, description, image, imagetype) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, friend.getNickname());
        preparedStatement.setString(2, friend.getName());
        preparedStatement.setString(3, friend.getDescription());
        preparedStatement.setBinaryStream(4, null);
        preparedStatement.setString(5, null);

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
                    (ExpMapMarker) deSerializeObject(resultSet.getBinaryStream("location")),

                    resultSet.getDate("date"),
                    resultSet.getTime("time").toLocalTime());
            meeting.setIsFinished(resultSet.getBoolean("finished"));
            meetings.add(meeting);
        }

        return meetings;
    }

    @SneakyThrows
    public void addMeeting(Meeting meeting) {
        String query = "INSERT INTO meetings (idmeetings, attendingfriends, location, date, time, finished) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        int lastID = 1;
        ResultSet rs = preparedStatement.getGeneratedKeys();
        if(rs.next()) {
            lastID = rs.getInt(1);
        }

        //int lastID = preparedStatement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setInt(1, lastID + 1);
        preparedStatement.setBinaryStream(2, serializeObject(meeting.getAttendingFriends()));
        preparedStatement.setBinaryStream(3, serializeObject(meeting.getMeetingLocation()));
        preparedStatement.setDate(4, new java.sql.Date(meeting.getMeetingDate().getTime()));
        preparedStatement.setTime(5, Time.valueOf(meeting.getMeetingTime()));
        preparedStatement.setBoolean(6, meeting.getIsFinished());

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }


}
