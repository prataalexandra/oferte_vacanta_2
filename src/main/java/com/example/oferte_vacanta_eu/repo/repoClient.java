package com.example.oferte_vacanta_eu.repo;
import com.example.oferte_vacanta_eu.domain.client;
import com.example.oferte_vacanta_eu.domain.hobbies;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class repoClient implements repo<client> {
    private String url;
    private String username;
    private String passwd;

    public repoClient(String url, String username, String passwd) {
        this.url = url;
        this.username = username;
        this.passwd = passwd;
    }

    @Override
    public List<client> getAll() {
        List<client> all = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, passwd);
             PreparedStatement statement = connection.prepareStatement("SELECT * from \"client\"");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                Integer fidelitygrade = resultSet.getInt("fidelitygrade");
                Integer varsta = resultSet.getInt("varsta");
                hobbies hobby = hobbies.valueOf(resultSet.getString("hobby"));

                client client=new client(id,name,fidelitygrade,varsta,hobby);
                all.add(client);
            }
            return all;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }
    }


