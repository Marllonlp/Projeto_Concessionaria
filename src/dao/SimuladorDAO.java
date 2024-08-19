package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import factory.ConnectionFactory;
import model.SimuladorModel;

public class SimuladorDAO {
    public boolean save(SimuladorModel simulador) {
        String sql = "INSERT INTO simulador (id, titulo, valor) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionFactory.createConnectionToMySQL();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setInt(1, simulador.getId());
            pstm.setString(2, simulador.getTitulo());
            pstm.setString(3, simulador.getValor());

            int affectedRows = pstm.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public List<SimuladorModel> getSimuladores() {
        String sql = "SELECT * FROM simulador ORDER BY id";
        List<SimuladorModel> simuladores = new ArrayList<>();

        try (Connection conn = ConnectionFactory.createConnectionToMySQL();
             PreparedStatement pstm = conn.prepareStatement(sql);
             ResultSet rset = pstm.executeQuery()) {

            while (rset.next()) {
                int id = rset.getInt("id");
                String titulo = rset.getString("titulo");
                String valor = rset.getString("valor");

                SimuladorModel simulador = new SimuladorModel(id, titulo, valor);

                simuladores.add(simulador);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return simuladores;
    }

    public void removeById(int id) {
        String sql = "DELETE FROM simulador WHERE id = ?";

        try (Connection conn = ConnectionFactory.createConnectionToMySQL();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setInt(1, id);
            int affectedRows = pstm.executeUpdate();
            if (affectedRows > 0)
                JOptionPane.showMessageDialog(null, "Simulador removido com sucesso!");
            else
                JOptionPane.showMessageDialog(null, "Não foi possível remover o simulador!");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void update(SimuladorModel simulador) {
        String sql = "UPDATE simulador SET titulo = ?, valor = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.createConnectionToMySQL();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, simulador.getTitulo());
            pstm.setString(2, simulador.getValor());
            pstm.setInt(3, simulador.getId());

            int affectedRows = pstm.executeUpdate();
            if (affectedRows > 0)
                JOptionPane.showMessageDialog(null, "Simulador atualizado com sucesso!");
            else
                JOptionPane.showMessageDialog(null, "Não foi possível atualizar o simulador!");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
