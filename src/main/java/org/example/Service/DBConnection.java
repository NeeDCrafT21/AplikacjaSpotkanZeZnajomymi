package org.example.Service;

import com.google.common.io.ByteSource;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        List<ExpMapMarker> markers = new ArrayList<>();
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
            markers.add(marker);
            map.addMapMarker(marker);
            System.out.println(marker.getLocation());
        }
        System.out.println("My markers: " + markers);
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

    public List<Friend> getFriends() {
        List<Friend> friends = new ArrayList<>();

        return friends;
    }

    public List<Meeting> getMeetings() {
        List<Meeting> meetings = new ArrayList<>();

        return meetings;
    }
}
