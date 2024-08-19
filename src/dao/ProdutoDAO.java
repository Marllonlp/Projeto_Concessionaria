package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import factory.ConnectionFactory;
import javax.swing.JOptionPane;
import model.Produto;

public class ProdutoDAO {
    Connection conn;

    public boolean save(Produto produto) {
        String sql = "INSERT INTO produto(id, titulo, descricao, preco, caminhoImagem) VALUES(?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;
        boolean success = false;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, produto.getId());
            pstm.setString(2, produto.getTitulo());
            pstm.setString(3, produto.getDescricao());
            pstm.setDouble(4, produto.getPreco());
            pstm.setString(5, produto.getCaminhoImagem());

            int affectedRows = pstm.executeUpdate();
            success = (affectedRows > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (pstm != null) pstm.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return success;
    }

    public List<Produto> getProdutos() {
        String sql = "SELECT * FROM produto ORDER BY id"; // Assegure-se de que a consulta está correta
        List<Produto> produtos = new ArrayList<>();
        try (Connection conn = ConnectionFactory.createConnectionToMySQL();
             PreparedStatement pstm = conn.prepareStatement(sql);
             ResultSet rset = pstm.executeQuery()) {

            while (rset.next()) {
                Produto produto = new Produto();
                produto.setId(rset.getInt("id")); // Certifique-se de que a coluna 'id' está presente
                produto.setTitulo(rset.getString("titulo"));
                produto.setDescricao(rset.getString("descricao"));
                produto.setPreco(rset.getDouble("preco")); // Inclua o preço se estiver presente
                produto.setCaminhoImagem(rset.getString("caminhoImagem"));

                produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return produtos;
    }

    public void removeById(int id) {
        String sql = "DELETE FROM produto WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);

            pstm.execute();
            if (pstm.getUpdateCount() > 0)
                JOptionPane.showMessageDialog(null, "Produto removido com sucesso!");
            else
                JOptionPane.showMessageDialog(null, "Não foi possível remover o produto!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) pstm.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void update(Produto produto) {
        String sql = "UPDATE produto SET titulo = ?, descricao = ?, caminhoImagem = ? WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, produto.getTitulo());
            pstm.setString(2, produto.getDescricao());
            pstm.setString(3, produto.getCaminhoImagem());

            pstm.execute();
            if (pstm.getUpdateCount() > 0)
                JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso!");
            else
                JOptionPane.showMessageDialog(null, "Não foi possível atualizar o produto!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) pstm.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}