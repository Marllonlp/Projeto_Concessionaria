package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import javax.swing.JOptionPane;

public class UsuarioDAO {

    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */

    /*nome	cpf	emal	tel	endereco	senha*/


    public void save(Contato contato) {

        /*
         * Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar
         * na base de dados
         */

        String sql = "INSERT INTO contatos(nome,idade,dataCadastro)" +
                " VALUES(?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Cria uma conexão com o banco
            conn = ConnectionFactory.createConnectionToMySQL();

            //Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql);

            //Adiciona o valor do primeiro parâmetro da sql
            pstm.setString(1, contato.getNome());
            //Adicionar o valor do segundo parâmetro da sql
            pstm.setInt(2, contato.getIdade());
            //Adiciona o valor do terceiro parâmetro da sql
            pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));

            //Executa a sql para inserção dos dados
            pstm.execute();
            if (pstm.getUpdateCount() > 0)
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            else
                JOptionPane.showMessageDialog(null, "N㯠foi poss�l inserir!!");
        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            //Fecha as conexões

            try {
                if (pstm != null) {

                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }

    public void removeById(int id) {

        String sql = "DELETE FROM contatos WHERE id = ?";

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
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

            try {
                if (pstm != null) {

                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }

    public void update(Contato contato) {

        String sql = "UPDATE contatos SET nome = ?, idade = ?, dataCadastro = ?" +
                " WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Cria uma conexão com o banco
            conn = ConnectionFactory.createConnectionToMySQL();

            //Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql);

            //Adiciona o valor do primeiro parâmetro da sql
            pstm.setString(1, contato.getNome());
            //Adicionar o valor do segundo parâmetro da sql
            pstm.setInt(2, contato.getIdade());
            //Adiciona o valor do terceiro parâmetro da sql
            pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));

            pstm.setInt(4, contato.getId());

            //Executa a sql para inserção dos dados
            pstm.execute();

            if (pstm.getUpdateCount() > 0)
                JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            else
                JOptionPane.showMessageDialog(null, "Não foi possível atualizar!!");
        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            //Fecha as conexões

            try {
                if (pstm != null) {

                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }

    public List<Contato> getContatos() {

        String sql = "SELECT * FROM contatos order by id";


        List<Contato> contatos = new ArrayList<Contato>();

        Connection conn = null;
        PreparedStatement pstm = null;

        //Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            //Enquanto existir dados no banco de dados, faça
            while (rset.next()) {

                Contato contato = new Contato();

                //Recupera o id do banco e atribui ele ao objeto
                contato.setId(rset.getInt("id"));

                //Recupera o nome do banco e atribui ele ao objeto
                contato.setNome(rset.getString("nome"));

                //Recupera a idade do banco e atribui ele ao objeto
                contato.setIdade(rset.getInt("idade"));

                //Recupera a data do banco e atribui ela ao objeto
                contato.setDataCadastro(rset.getDate("dataCadastro"));

                //Adiciono o contato recuperado, a lista de contatos
                contatos.add(contato);
            }
        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            try {

                if (rset != null) {

                    rset.close();
                }

                if (pstm != null) {

                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {

                e.printStackTrace();
            }
        }

        return contatos;
    }
}

