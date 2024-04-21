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

    public void createRoupa(Roupa roupa) {

        try {

            String SQL = "INSERT INTO ROUPA (NAME) VALUES (?)";

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, roupa.getName());

            preparedStatement.execute();

            System.out.println("Sucesso ao gravar a roupa no DB");

            connection.close();

        } catch (Exception e) {

            System.out.println("Erro ao gravar a roupa no DB: " + e.getMessage());

        }

    }

    public List<Roupa> findAllRoupas() {

        try {

            String SQL = "SELECT * FROM ROUPA";

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Roupa> roupas = new ArrayList<>();

            while (resultSet.next()) {

                String roupaId = resultSet.getString("id");
                String name = resultSet.getString("name");

                Roupa roupa = new Roupa(roupaId, name);

                roupas.add(roupa);

            }

            System.out.println("Sucesso ao consultar as roupas no DB!");

            return roupas;

        } catch (Exception e) {

            System.out.println("Erro ao consultar as roupas no DB!");

        }

        return Collections.emptyList();

    }

    public void deleteRoupaById(String id) {

        try {

            String SQL = "DELETE ROUPA WHERE ID = ?";

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, id);

            preparedStatement.execute();

            System.out.println("Sucesso ao deletar a roupa no DB!");

            connection.close();

        } catch (Exception e) {

            System.out.println("Falaha ao deletar a roupa no DB!");

        }

    }

}
