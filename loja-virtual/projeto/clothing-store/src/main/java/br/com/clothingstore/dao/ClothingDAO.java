package br.com.clothingstore.dao;

import br.com.clothingstore.model.Clothing;
import br.com.clothingstore.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class ClothingDAO {

    public void createClothing(Clothing clothing) {
        String SQL = "INSERT INTO CLOTHING (NAME, IMAGE) VALUES (?, ?)";

        try {
            Connection connection = getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Success: Database connection established");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, clothing.getName());
            preparedStatement.setString(2, clothing.getImage());
            preparedStatement.execute();

            System.out.println("Success: Clothing inserted into database");

            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: Failed to establish database connection or insert clothing");
            e.printStackTrace();
        }
    }

    public List<Clothing> findAllClothings() {

        try {
            String SQL = "SELECT * FROM CLOTHING";
            Connection connection = getConnection("jdbc:h2:~/test", "sa", "sa");
             PreparedStatement preparedStatement = connection.prepareStatement(SQL);
             ResultSet resultSet = preparedStatement.executeQuery();
            List<Clothing> clothingList = new ArrayList<>();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String image = resultSet.getString("image");

                Clothing roupas = new Clothing(id, name, image);
                clothingList.add(roupas);
            }
            System.out.println("Success: Retrieved all clothing from the database");

            return clothingList;

        } catch (SQLException e) {
            System.out.println("Error: Failed to retrieve clothing from the database");
        }
        return Collections.emptyList();
    }


    public void deleteClothingById(String clothingId) {

        String SQL = "DELETE CLOTHING WHERE ID = ?";

        try {

            Connection connection = getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, clothingId);
            preparedStatement.execute();

            System.out.println("success on delete clothing with id: " + clothingId);

            connection.close();

        } catch (Exception e) {

            System.out.println("fail in database connection");

        }

    }

    public void updateClothing(Clothing updatedClothing) {

        String sql = "UPDATE CLOTHING SET NAME = ?, IMAGE = ? WHERE ID = ?";

        try {

            Connection connection = getConnection("jdbc:h2:~/test", "sa","sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, updatedClothing.getName());
            preparedStatement.setString(2, updatedClothing.getImage());
            preparedStatement.setString(3, updatedClothing.getId());
            preparedStatement.execute();

            System.out.println("success in update clothing");

            connection.close();

        } catch (Exception e) {

            System.out.println("fail in database connection");
            System.out.println("Error: " + e.getMessage());

        }
    }

}