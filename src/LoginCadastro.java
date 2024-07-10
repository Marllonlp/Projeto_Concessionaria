import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Declaração da classe LoginCadastro, que herda da classe JFrame (para criar uma janela).
public class LoginCadastro extends JFrame implements ActionListener {
    private JPanel painelLogin;
    private JTextField campoInserirNome;
    private JTextField campoInserirEmail;
    private JPasswordField campoInserirSenha;
    private JPanel painelCadastro;

    public LoginCadastro() {
        inicializarJanela();
    }

    // Método para configurar os elementos de entrada de dados.
    private void configEntraDados() {
        campoInserirNome = new JTextField(); //Cria um novo campo de texto chamado jlbNome.
        campoInserirEmail = new JTextField();
        campoInserirSenha = new JPasswordField();
    }

    // Método para configurar o painel jpnDados.
    private void configPaineLogin() {
        setTitle("Login");
        painelLogin = new JPanel();
        painelLogin.setLayout(new GridLayout(7, 1, 10, 10));
        painelLogin.setPreferredSize(new Dimension(300, 400));
        //jpnDados.setBackground(Color.cyan);
        configEntraDados(); //Chama o método para configurar os elementos de entrada de dados.

        JLabel title = new JLabel("Login");
        title.setFont(new Font("Arial", Font.BOLD, 40));
        painelLogin.add(title);

        JLabel jlbNome = new JLabel("NOME");
        jlbNome.setFont(new Font("Arial", Font.ITALIC, 18));
        painelLogin.add(jlbNome);
        painelLogin.add(campoInserirNome); // Adiciona o campo de texto jlbNome ao painel.

        JLabel jlaSenha = new JLabel("SENHA");
        jlaSenha.setFont(new Font("Arial", Font.ITALIC, 18));
        painelLogin.add(jlaSenha);
        painelLogin.add(campoInserirSenha);

// Criação dos botões "Entrar" e "Cadastrar"
        JButton jButtonEntrar = new JButton("Entrar");
        JButton jButtonCadastrar = new JButton("Cadastrar");

// Adiciona um evento ao botão "Cadastrar"
        jButtonCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Quando o botão "Cadastrar" for clicado, o painel de cadastro é exibido
                // e o painel de login é ocultado
                painelCadastro.setVisible(true);
                painelLogin.setVisible(false);
            }
        });

// Criação de um painel para os botões
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout());
        painelBotoes.add(jButtonEntrar); // Adiciona o botão "Entrar" ao painel
        painelBotoes.add(jButtonCadastrar); // Adiciona o botão "Cadastrar" ao painel
        painelLogin.add(painelBotoes); // Adiciona o painel de botões ao painel de login
    }

    private void configPainelCadastrar() {
        setTitle("Cadastrar");
        painelCadastro = new JPanel();
        painelCadastro.setLayout(new GridLayout(9, 1, 10, 10));
        painelCadastro.setPreferredSize(new Dimension(300, 420));
        configEntraDados(); // Chama o método para configurar os elementos de entrada de dados.

        JLabel title = new JLabel("Cadastrar");
        title.setFont(new Font("Arial",Font.BOLD, 40));
        painelCadastro.add(title);

        JLabel jlbNome = new JLabel("NOME");
        jlbNome.setFont(new Font("Arial",Font.ITALIC, 18));
        painelCadastro.add(jlbNome);
        painelCadastro.add(campoInserirNome);


        JLabel jlbEmail = new JLabel("EMAIL");
        jlbEmail.setFont(new Font("Arial",Font.ITALIC, 18));
        painelCadastro.add(jlbEmail);
        painelCadastro.add(campoInserirEmail);// Adiciona o campo de texto jlbNome ao painel.

        JLabel jlaSenha = new JLabel("SENHA");
        jlaSenha.setFont(new Font("Arial",Font.ITALIC, 18));
        painelCadastro.add(jlaSenha);
        painelCadastro.add(campoInserirSenha);



        JButton jButtonEntrar = new JButton("Entrar");

        JButton jButtonCadastrar = new JButton("Cadastrar");

        jButtonEntrar.addActionListener(new ActionListener() { //adicinar evento ao botão
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
        this.setLayout(new FlowLayout()); // Define o layout da janela como FlowLayout.
        this.setSize(new Dimension(350, 500)); // Define o tamanho da janela.
        this.setResizable(false); // Impede que a janela seja redimensionada.
        this.setLocationRelativeTo(null); // Centraliza a janela na tela.

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true); // Torna a janela visível

        configPaineLogin(); // Chama o método para configurar o painel jpnDados.
        this.add(painelLogin); // Adiciona o painel à janela.

        configPainelCadastrar();
        this.add(painelCadastro);
        painelCadastro.setVisible(false);


        revalidate(); // Revalida a interface gráfica.

    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
