package br.com.clothingstore.dao;

import br.com.clothingstore.model.Clothing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClothingDAO {

    public void createClothing(Clothing clothing) {
        String SQL = "INSERT INTO CLOTHING (NAME) VALUES (?)";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Success: Database connection established");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, clothing.getName());
            preparedStatement.execute();

            System.out.println("Success: Clothing inserted into database");

            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: Failed to establish database connection or insert clothing");
            e.printStackTrace();
        }
    }

    public List<Clothing> findAllClothings() {
        String SQL = "SELECT * FROM CLOTHING";

        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
             PreparedStatement preparedStatement = connection.prepareStatement(SQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            List<Clothing> clothingList = new ArrayList<>();


            while (resultSet.next()) {

                String clothingId = resultSet.getString("id");

                String clothingName = resultSet.getString("name");

                Clothing clothing = new Clothing(clothingId, clothingName);

                clothingList.add(clothing);
            }

            System.out.println("Success: Retrieved all clothing from the database");

            return clothingList;
        } catch (SQLException e) {
            System.out.println("Error: Failed to retrieve clothing from the database");
            e.printStackTrace();
            return Collections.emptyList();
        }


    }


    public void deleteClothingById(String clothingId) {

        String SQL = "DELETE CLOTHING WHERE ID = ?";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, clothingId);
            preparedStatement.execute();

            System.out.println("success on delete car with id: " + clothingId);

            connection.close();

        } catch (Exception e) {

            System.out.println("fail in database connection");

        }

    }
}

