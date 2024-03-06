package com.example.oferte_vacanta_eu.repo;
import com.example.oferte_vacanta_eu.domain.location;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class repoLocation implements repo<location>{

    private String url;
    private String username;
    private String passwd;

    public repoLocation(String url, String username, String passwd) {
        this.url = url;
        this.username = username;
        this.passwd = passwd;
    }

    @Override
    public List<location> getAll() {
        List<location> all = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, passwd);
             PreparedStatement statement = connection.prepareStatement("SELECT * from \"location\"");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Double id = resultSet.getDouble("id");
                String nume = resultSet.getString("name");

                location location=new location(id,nume);
                all.add(location);
            }
            return all;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }
}

