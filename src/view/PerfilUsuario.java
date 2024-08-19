package view;

import javax.swing.*;
import java.awt.*;

public class PerfilUsuario extends JFrame {
    private JPanel perfil;
    private JLabel nomeLabel, telefoneLabel, emailLabel;

    public PerfilUsuario() {
        inicializarJanelaP();
        janelaPerfil();
    }

    private void inicializarJanelaP() {
        setSize(700, 400);
        setLocationRelativeTo(null);
        setTitle("Perfil de Usuário");
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void janelaPerfil() {
        perfil = new JPanel();
        perfil.setBackground(Color.white);
        perfil.setLayout(new BoxLayout(perfil, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Perfil");
        title.setFont(new Font("Arial", Font.BOLD, 40));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        perfil.add(Box.createVerticalStrut(20));
        perfil.add(title);
        perfil.add(Box.createVerticalStrut(40));

        nomeLabel = new JLabel();
        telefoneLabel = new JLabel();
        emailLabel = new JLabel();

        config(nomeLabel);
        config(telefoneLabel);
        config(emailLabel);

        add(perfil, BorderLayout.CENTER);
    }

    public void exibirDadosUsuario(String nome, String telefone, String email) {
        nomeLabel.setText("Nome: " + nome);
        telefoneLabel.setText("Telefone: " + telefone);
        emailLabel.setText("Email: " + email);
    }

    public void exibirMensagemErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    private void config(JLabel label) {
        label.setFont(new Font("Sans-serif", Font.BOLD, 13));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        perfil.add(label);
        perfil.add(Box.createVerticalStrut(10));
    }
}