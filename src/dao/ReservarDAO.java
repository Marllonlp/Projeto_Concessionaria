package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import factory.ConnectionFactory;
import model.Reservar;

import javax.swing.*;

public class ReservarDAO {

    public boolean existeReserva(String cpf, String titulo) {
        String query = "SELECT COUNT(*) FROM reservas WHERE cpf = ? AND titulo = ?";
        try (Connection conn = ConnectionFactory.createConnectionToMySQL();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, cpf);
            stmt.setString(2, titulo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public void save(Reservar reserva) {
        if (reserva.getNome() == null || reserva.getCpf() == null || reserva.getTitulo() == null) {
            JOptionPane.showMessageDialog(null, "Nome, CPF e Título não podem ser nulos.");
            return;
        }

        String sql = "INSERT INTO reservas (nome, cpf, titulo) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionFactory.createConnectionToMySQL();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, reserva.getNome());
            pstmt.setString(2, reserva.getCpf());
            pstmt.setString(3, reserva.getTitulo());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Reserva realizada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível realizar a reserva.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao realizar a reserva: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
