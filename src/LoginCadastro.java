import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginCadastro extends JFrame implements ActionListener {
    private JPanel painelLogin;
    private JTextField campoInserirNome;
    private JTextField campoInserirEmail;
    private JPasswordField campoInserirSenha;

    private JPanel painelCadastro;

    public LoginCadastro() {
        inicializarJanela();
    }

    private void configEntraDados() {
        campoInserirNome = new JTextField();
        campoInserirEmail = new JTextField();
        campoInserirSenha = new JPasswordField();
    }

    private void configPaineLogin() {
        setTitle("Login");
        painelLogin = new JPanel();
        painelLogin.setBackground(Color.gray);
        painelLogin.setLayout(new GridLayout(7, 1, 40, 20));
        painelLogin.setPreferredSize(new Dimension(300, 350));

        configEntraDados();
        JLabel title = new JLabel("Login",SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 40));
        painelLogin.add(title);

        JLabel jlbNome = new JLabel("CPF");
        jlbNome.setFont(new Font("Arial", Font.BOLD, 18));
        painelLogin.add(jlbNome);
        painelLogin.add(campoInserirNome);

        JLabel jlaSenha = new JLabel("SENHA");
        jlaSenha.setFont(new Font("Arial", Font.BOLD, 18));
        painelLogin.add(jlaSenha);
        painelLogin.add(campoInserirSenha);

        JButton jButtonEntrar = new JButton("Entrar");
        jButtonEntrar.setBackground(Color.white);
        jButtonEntrar.setFont(new Font("Arial", Font.BOLD, 18));
        JButton jButtonCadastrar = new JButton("Cadastrar");
        jButtonCadastrar.setBackground(Color.white);

        jButtonCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Quando o botão "Cadastrar" for clicado, o painel de cadastro é exibido
                // e o painel de login é ocultado
                painelCadastro.setVisible(true);
                painelLogin.setVisible(false);
            }
        });

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout());
        painelBotoes.add(jButtonEntrar);
        painelBotoes.add(jButtonCadastrar);
        painelLogin.add(painelBotoes);
    }

    private void configPainelCadastrar() {
        setTitle("Cadastrar");
        painelCadastro = new JPanel();
        painelCadastro.setLayout(new GridLayout(9, 1, 10, 10));
        painelCadastro.setPreferredSize(new Dimension(300, 420));
        configEntraDados();

        JLabel title = new JLabel("Cadastrar",SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 40));
        painelCadastro.add(title);

        JLabel jlbNome = new JLabel("NOME");
        jlbNome.setFont(new Font("Arial", Font.ITALIC, 18));
        painelCadastro.add(jlbNome);
        painelCadastro.add(campoInserirNome);


        JLabel jlbEmail = new JLabel("EMAIL");
        jlbEmail.setFont(new Font("Arial", Font.ITALIC, 18));
        painelCadastro.add(jlbEmail);
        painelCadastro.add(campoInserirEmail);

        JLabel jlaSenha = new JLabel("SENHA");
        jlaSenha.setFont(new Font("Arial", Font.ITALIC, 18));
        painelCadastro.add(jlaSenha);
        painelCadastro.add(campoInserirSenha);


        JButton jButtonEntrar = new JButton("Entrar");

        JButton jButtonCadastrar = new JButton("Cadastrar");

        jButtonEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                painelCadastro.setVisible(false);
                painelLogin.setVisible(true);
            }
        });


        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout());
        painelBotoes.add(jButtonEntrar);
        painelBotoes.add(jButtonCadastrar);
        painelCadastro.add(painelBotoes);
    }

    private void inicializarJanela() {
        this.setLayout(new FlowLayout());
        this.setSize(new Dimension(350, 500));
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true); // Torna a janela visível

        configPaineLogin();
        this.add(painelLogin);

        configPainelCadastrar();
        this.add(painelCadastro);
        painelCadastro.setVisible(false);
        revalidate(); // Revalida a interface gráfica.
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
