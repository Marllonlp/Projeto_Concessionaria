package view;

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
    private JButton botaoCadastrar;

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

    private void configPainelCadastrar(
    ) {
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

        this.setBotaoCadastrar(new JButton("Cadastrar"));
        gbc.gridy = 13;
        gbc.gridwidth = 1;
        estilizarBotao(getBotaoCadastrar());
        gbc.gridx = 1;
        this.add(botaoCadastrar, gbc);

        jButtonEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaPrincipal.mostrarLogin();
            }
        });
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


    public JTextField getCampoNome() {
        return campoNome;
    }

    public void setCampoNome(JTextField campoNome) {
        this.campoNome = campoNome;
    }

    public JTextField getCampoCPF() {
        return campoCPF;
    }

    public void setCampoCPF(JTextField campoCPF) {
        this.campoCPF = campoCPF;
    }

    public JTextField getCampoEmail() {
        return campoEmail;
    }

    public void setCampoEmail(JTextField campoEmail) {
        this.campoEmail = campoEmail;
    }

    public JTextField getCampoEnder() {
        return campoEnder;
    }

    public void setCampoEnder(JTextField campoEnder) {
        this.campoEnder = campoEnder;
    }

    public JTextField getCampoTel() {
        return campoTel;
    }

    public void setCampoTel(JTextField campoTel) {
        this.campoTel = campoTel;
    }

    public JPasswordField getCampoSenha() {
        return campoSenha;
    }

    public void setCampoSenha(JPasswordField campoSenha) {
        this.campoSenha = campoSenha;
    }

    public JanelaLoginCadastro getJanelaPrincipal() {
        return janelaPrincipal;
    }

    public void setJanelaPrincipal(JanelaLoginCadastro janelaPrincipal) {
        this.janelaPrincipal = janelaPrincipal;

    }

    public JButton getBotaoCadastrar() {
        return botaoCadastrar;
    }

    public void setBotaoCadastrar(JButton botao) {
        this.botaoCadastrar = botao;
    }


}
