package dao;

import factory.ConnectionFactory;
import model.CarrinhoModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDAO {
    public List<CarrinhoModel> getReservasPorCpf(String cpf) {
        List<CarrinhoModel> reservas = new ArrayList<>();

        try (Connection connection = ConnectionFactory.createConnectionToMySQL();
             PreparedStatement stmt = connection.prepareStatement("SELECT titulo FROM reservas WHERE cpf = ?")) {

            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String titulo = rs.getString("titulo");


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return reservas;
    }
}
