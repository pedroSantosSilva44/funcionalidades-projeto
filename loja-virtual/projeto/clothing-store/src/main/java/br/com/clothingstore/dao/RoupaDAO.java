package br.com.carstore.dao;

import br.com.carstore.model.Roupa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoupaDAO {

    public void createCar(Roupa car) {

        try {

            String SQL = "INSERT INTO CAR (NAME) VALUES (?)";

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, car.getName());

            preparedStatement.execute();

            System.out.println("Sucesso ao gravar o carro no DB");

            connection.close();

        } catch (Exception e) {

            System.out.println("Erro ao gravar o carro no DB: " + e.getMessage());

        }

    }

    public List<Roupa> findAllCars() {

        try {

            String SQL = "SELECT * FROM CAR";

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Roupa> cars = new ArrayList<>();

            while (resultSet.next()) {

                String carId = resultSet.getString("id");
                String name = resultSet.getString("name");

                Roupa car = new Roupa(carId, name);

                cars.add(car);

            }

            System.out.println("Sucesso ao consultar os carros no DB!");

            return cars;

        } catch (Exception e) {

            System.out.println("Erro ao consultar os carros no DB!");

        }

        return Collections.emptyList();

    }

    public void deleteCarById(String id) {

        try {

            String SQL = "DELETE CAR WHERE ID = ?";

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, id);

            preparedStatement.execute();

            System.out.println("Sucesso ao deletar o carro no DB!");

            connection.close();

        } catch (Exception e) {

            System.out.println("Falaha ao deletar o carro no DB!");

        }

    }

}
