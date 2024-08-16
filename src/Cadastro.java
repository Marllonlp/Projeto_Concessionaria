import dao.UsuarioDAO;
import model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Cadastro extends JPanel {
    private JTextField campoNome;
    private JTextField campoCPF;
    private JTextField campoEmail;
    private JTextField campoEnder;
    private JTextField campoTel;
    private JPasswordField campoSenha;
    private JanelaLoginCadastro janelaPrincipal;

    public Cadastro(JanelaLoginCadastro janela) {
        this.janelaPrincipal = janela;
        configPainelCadastrar();
    }

    private void configEntraDados() {
        campoNome = new JTextField();
        campoCPF = new JTextField();
        campoEmail = new JTextField();
        campoTel = new JTextField();
        campoEnder = new JTextField();
        campoSenha = new JPasswordField();
    }

    private void configPainelCadastrar() {
        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(240, 240, 240));
        configEntraDados();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel title = new JLabel("CADASTRO", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        this.add(title, gbc);

        adicionarCampo("NOME", campoNome, gbc, 1);
        adicionarCampo("CPF", campoCPF, gbc, 3);
        adicionarCampo("E-MAIL", campoEmail, gbc, 5);
        adicionarCampo("TELEFONE", campoTel, gbc, 7);
        adicionarCampo("ENDEREÇO", campoEnder, gbc, 9);
        adicionarCampo("SENHA", campoSenha, gbc, 11);

        JButton jButtonEntrar = new JButton("Entrar");
        estilizarBotao(jButtonEntrar);
        gbc.gridy = 13;
        gbc.gridwidth = 1;
        this.add(jButtonEntrar, gbc);

        JButton jButtonCadastrar = new JButton("Cadastrar");
        estilizarBotao(jButtonCadastrar);

        jButtonCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                String name = campoNome.getText();
//                String cpf = campoCPF.getText();
//                String email = campoEmail.getText();
//                String tel = campoTel.getText();
//                String end = campoEnder.getText();
//                String senha = campoSenha.getText();
                Usuario user =  new Usuario();
                user.setNome(campoNome.getText());
                user.setCpf(campoCPF.getText());
                user.setEmail(campoEmail.getText());
                user.setTel(campoTel.getText());
                user.setEnd(campoEnder.getText());
                user.setSenha(campoSenha.getText());

                UsuarioDAO userCadastro = new UsuarioDAO();
                 userCadastro.save(user);
                 limparCapus();
            }
        });

        gbc.gridx = 1;
        this.add(jButtonCadastrar, gbc);

        jButtonEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaPrincipal.mostrarLogin();
            }
        });
    }

    public void limparCapus(){
        campoNome.setText(" ");
        campoCPF.setText(" ");
        campoEmail.setText(" ");
        campoTel.setText(" ");
        campoEnder.setText(" ");
        campoSenha.setText(" ");
    }

    private void adicionarCampo(String label, JTextField campo, GridBagConstraints gbc, int gridy) {
        JLabel jLabel = new JLabel(label);
        jLabel.setFont(new Font("Arial", Font.BOLD, 15));
        gbc.gridy = gridy;
        gbc.gridwidth = 2;
        this.add(jLabel, gbc);

        campo.setPreferredSize(new Dimension(290, 30));
        campo.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        gbc.gridy = gridy + 1;
        this.add(campo, gbc);
    }

    private void estilizarBotao(JButton botao) {
        botao.setFont(new Font("Arial", Font.BOLD, 15));
        botao.setBackground(new Color(100, 100, 100));
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
        botao.setBorderPainted(false);
        botao.setOpaque(true);
    }

}