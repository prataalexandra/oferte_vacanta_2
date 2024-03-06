package com.example.oferte_vacanta_eu.repo;
import com.example.oferte_vacanta_eu.domain.hotel;
import com.example.oferte_vacanta_eu.domain.hoteltype;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class repoHotel implements repo<hotel>{
    private String url;
    private String username;
    private String passwd;

    public repoHotel(String url, String username, String passwd) {
        this.url = url;
        this.username = username;
        this.passwd = passwd;
    }

    @Override
    public List<hotel> getAll() {
        List<hotel> all = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, passwd);
             PreparedStatement statement = connection.prepareStatement("SELECT * from \"hotel\"");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Double id = resultSet.getDouble("id");
                Double idl = resultSet.getDouble("idl");
                String hnume = resultSet.getString("hname");
                Integer rooms = resultSet.getInt("rooms");
                Integer price = resultSet.getInt("price");
//!!!!!!                HotelType htype = Hotel.stringToType(resultSet.getString("htype"));
                hoteltype htype = hoteltype.valueOf(resultSet.getString("htype"));

                //HotelType htype2 = HotelType.FAMILY;
                hotel hotel=new hotel(id,idl,hnume,rooms,price,htype);
                all.add(hotel);
            }
            return all;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }
}
