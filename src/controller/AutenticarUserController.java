package controller;

import dao.UsuarioDAO;
import model.Usuario;
import view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AutenticarUserController {
    private Cadastro cadastroView;
    private Login loginView;
    private JanelaLoginCadastro janelaPrincipal;

    public AutenticarUserController(Cadastro cadastroView, Login loginView, JanelaLoginCadastro janelaPrincipal) {
        this.cadastroView = cadastroView;
        this.loginView = loginView;
        this.janelaPrincipal = janelaPrincipal;
        initController();
    }

    private void initController() {
        this.cadastroView.getBotaoCadastrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarUsuario();
            }
        });

        this.loginView.getBotaoLogin().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logarUsuario();
            }
        });
    }


    private void cadastrarUsuario() {
        if (!validarCamposCadastro()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
            return;
        }
        String cpf = cadastroView.getCampoCPF().getText();
        UsuarioDAO verificarCadastro = new UsuarioDAO();

        if (verificarCadastro.cpfExists(cpf)) {
            JOptionPane.showMessageDialog(null, "CPF já cadastrado. Por favor, use outro CPF.");
            return;
        }

        Usuario user = new Usuario();
        user.setNome(cadastroView.getCampoNome().getText());
        user.setCpf(cadastroView.getCampoCPF().getText());
        user.setEmail(cadastroView.getCampoEmail().getText());
        user.setTel(cadastroView.getCampoTel().getText());
        user.setEnd(cadastroView.getCampoEnder().getText());
        user.setSenha(new String(cadastroView.getCampoSenha().getPassword()));
        janelaPrincipal.setVisible(true);

        UsuarioDAO userCadastro = new UsuarioDAO();
        userCadastro.save(user);
        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
        limparCampos();
    }


    private void logarUsuario() {
        if (!validarCamposLogin()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
            return;
        }
        try {
            Usuario user = new Usuario();
            user.setCpf(loginView.getCampoInserirCPF().getText());
            user.setSenha(loginView.getCampoInserirSenha().getText());

            UsuarioDAO objUsusarioDAO = new UsuarioDAO();
            ResultSet rsUsusarioDAO = objUsusarioDAO.autenticaUsuario(user);
            user = objUsusarioDAO.buscarPerfilPorCpf(user.getCpf());

            if (rsUsusarioDAO.next()) {
                // Chamar tela de início
                MenuPrincipal objTelaPrincipal = new MenuPrincipal(user, objUsusarioDAO);
                objTelaPrincipal.setVisible(true);
                janelaPrincipal.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos.");
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
        }

    }


    private boolean validarCamposCadastro() {
        return !cadastroView.getCampoNome().getText().isEmpty() &&
                !cadastroView.getCampoCPF().getText().isEmpty() &&
                !cadastroView.getCampoEmail().getText().isEmpty() &&
                !cadastroView.getCampoTel().getText().isEmpty() &&
                !cadastroView.getCampoEnder().getText().isEmpty() &&
                !new String(cadastroView.getCampoSenha().getPassword()).isEmpty();
    }

    private boolean validarCamposLogin() {
        return !loginView.getCampoInserirCPF().getText().isEmpty() &&
                !loginView.getCampoInserirSenha().getText().isEmpty();
    }

    public void limparCampos() {
        cadastroView.getCampoNome().setText("");
        cadastroView.getCampoCPF().setText("");
        cadastroView.getCampoEmail().setText("");
        cadastroView.getCampoTel().setText("");
        cadastroView.getCampoEnder().setText("");
        cadastroView.getCampoSenha().setText("");
    }

}
