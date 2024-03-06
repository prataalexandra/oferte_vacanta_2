package com.example.oferte_vacanta_eu.repo;
import com.example.oferte_vacanta_eu.domain.offers;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class repoOff implements repo<offers> {
    private String url;
    private String username;
    private String passwd;

    public repoOff(String url, String username, String passwd) {
        this.url = url;
        this.username = username;
        this.passwd = passwd;
    }

    @Override
    public List<offers> getAll() {
        List<offers> all = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, passwd);
             PreparedStatement statement = connection.prepareStatement("SELECT * from \"offers\"");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Double id = resultSet.getDouble("id");
                Double hotel = resultSet.getDouble("hotel");
                LocalDate start = resultSet.getDate("start").toLocalDate();
                LocalDate end = resultSet.getDate("end").toLocalDate();
                Integer percent = resultSet.getInt("percent");

                offers offer=new offers(id,hotel,start,end,percent);
                all.add(offer);
            }
            return all;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }
}
