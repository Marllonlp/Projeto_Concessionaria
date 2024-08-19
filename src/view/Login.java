package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JPanel {
    private JTextField campoInserirCPF;
    private JPasswordField campoInserirSenha;
    private JComboBox<String> opcAdmUser;
    private JanelaLoginCadastro janelaPrincipal;
    private JButton botaoLogin;

    public Login(JanelaLoginCadastro janela) {
        this.janelaPrincipal = janela;
        configPaineLogin();
    }

    private void configEntraDados() {
        campoInserirCPF = new JTextField();
        campoInserirSenha = new JPasswordField();
        opcAdmUser = new JComboBox<String>(new String[]{"Admin", "User"});
    }

    private void configPaineLogin() {
        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(240, 240, 240));
        configEntraDados();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel title = new JLabel("LOGIN", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 40));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        this.add(title, gbc);

        JLabel jlbOpcAdmUser = new JLabel("Entrar como");
        jlbOpcAdmUser.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        this.add(jlbOpcAdmUser, gbc);

        opcAdmUser.setFont(new Font("Arial", Font.PLAIN, 18));
        gbc.gridy = 2;
        this.add(opcAdmUser, gbc);

        JLabel jlbCPF = new JLabel("CPF");
        jlbCPF.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridy = 3;
        this.add(jlbCPF, gbc);

        campoInserirCPF.setPreferredSize(new Dimension(290, 30));
        campoInserirCPF.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                BorderFactory.createEmptyBorder(5, 5, 5, 2)));
        gbc.gridy = 4;
        this.add(campoInserirCPF, gbc);

        JLabel jlaSenha = new JLabel("SENHA");
        jlaSenha.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridy = 5;
        this.add(jlaSenha, gbc);

        campoInserirSenha.setPreferredSize(new Dimension(290, 30));
        campoInserirSenha.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        gbc.gridy = 6;
        this.add(campoInserirSenha, gbc);

        setBotaoLogin(new JButton("Login"));
        estilizarBotao(getBotaoLogin());
        gbc.gridy = 7;
        this.add(botaoLogin, gbc);

        JButton jButtonCadastrar = new JButton("Cadastrar");
        estilizarBotao(jButtonCadastrar);
        gbc.gridy = 8;
        this.add(jButtonCadastrar, gbc);

        jButtonCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaPrincipal.mostrarCadastro();
            }
        });
    }

    private void estilizarBotao(JButton botao) {
        botao.setFont(new Font("Arial", Font.BOLD, 18));
        botao.setBackground(new Color(100, 100, 100));
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
        botao.setBorderPainted(false);
        botao.setOpaque(true);
    }


    public JTextField getCampoInserirCPF() {
        return campoInserirCPF;
    }

    public void setCampoInserirCPF(JTextField campoInserirCPF) {
        this.campoInserirCPF = campoInserirCPF;
    }

    public JPasswordField getCampoInserirSenha() {
        return campoInserirSenha;
    }

    public void setCampoInserirSenha(JPasswordField campoInserirSenha) {
        this.campoInserirSenha = campoInserirSenha;
    }

    public JComboBox<String> getOpcAdmUser() {
        return opcAdmUser;
    }

    public void setOpcAdmUser(JComboBox<String> opcAdmUser) {
        this.opcAdmUser = opcAdmUser;
    }

    public JanelaLoginCadastro getJanelaPrincipal() {
        return janelaPrincipal;
    }

    public void setJanelaPrincipal(JanelaLoginCadastro janelaPrincipal) {
        this.janelaPrincipal = janelaPrincipal;
    }

    public JButton getBotaoLogin() {
        return botaoLogin;
    }

    public void setBotaoLogin(JButton botaoLogin) {
        this.botaoLogin = botaoLogin;
    }
}