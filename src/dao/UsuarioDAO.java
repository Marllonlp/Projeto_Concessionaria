package dao;

import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;

import javax.swing.JOptionPane;

import model.Usuario;

public class UsuarioDAO {
    Connection conn;

    public ResultSet autenticaUsuario(Usuario objUsusario) throws Exception {
        conn = new ConnectionFactory().createConnectionToMySQL();
        try {
            String sql = "select * from usuario where cpf = ? and senha = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objUsusario.getCpf());
            pstm.setString(2, objUsusario.getSenha());

            ResultSet rs = pstm.executeQuery();
            return rs;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Usuario" + erro);
            return null;
        }
    }


    public void save(Usuario usuario) {
        String sql = "INSERT INTO usuario(nome, cpf, email, tel, end, senha) VALUES(?,?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getCpf());
            pstm.setString(3, usuario.getEmail());
            pstm.setString(4, usuario.getTel());
            pstm.setString(5, usuario.getEnd());
            pstm.setString(6, usuario.getSenha());

            pstm.execute();
            if (pstm.getUpdateCount() > 0)
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            else
                JOptionPane.showMessageDialog(null, "Não foi possível inserir!!");
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

    public void removeById(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);

            pstm.execute();
            if (pstm.getUpdateCount() > 0)
                JOptionPane.showMessageDialog(null, "Removido com sucesso!");
            else
                JOptionPane.showMessageDialog(null, "Não foi possível remover!!");
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

    public void update(Usuario usuario) {
        String sql = "UPDATE usuarios SET nome = ?, cpf = ?, email = ?, tel = ?, end = ?, senha = ? WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getCpf());
            pstm.setString(3, usuario.getEmail());
            pstm.setString(4, usuario.getTel());
            pstm.setString(5, usuario.getEnd());
            pstm.setString(6, usuario.getSenha());
            pstm.setInt(7, usuario.getId());

            pstm.execute();
            if (pstm.getUpdateCount() > 0)
                JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            else
                JOptionPane.showMessageDialog(null, "Não foi possível atualizar!!");
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

    public List<Usuario> getContatos() {
        String sql = "SELECT * FROM usuarios ORDER BY id";

        List<Usuario> usuarios = new ArrayList<Usuario>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rset.getInt("id"));
                usuario.setNome(rset.getString("nome"));
                usuario.setCpf(rset.getString("cpf"));
                usuario.setEmail(rset.getString("email"));
                usuario.setTel(rset.getString("tel"));
                usuario.setEnd(rset.getString("end"));
                usuario.setSenha(rset.getString("senha"));

                usuarios.add(usuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) rset.close();
                if (pstm != null) pstm.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return usuarios;
    }
}
