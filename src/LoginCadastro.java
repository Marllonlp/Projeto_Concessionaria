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
        campoInserirNome.setPreferredSize(new Dimension(300, 30)); //Define a largura e altura do campo de texto.
        campoInserirSenha = new JPasswordField();
        campoInserirSenha.setPreferredSize(new Dimension(300, 30));
    }

    // Método para configurar o painel jpnDados.
    private void configPaineLogin() {
        setTitle("Login");
        painelLogin = new JPanel();
        painelLogin.setLayout(new FlowLayout());
        painelLogin.setPreferredSize(new Dimension(300, 400));//jpnDados.setBackground(Color.cyan);
        configEntraDados(); // Chama o método para configurar os elementos de entrada de dados.

        JLabel title = new JLabel("Login");
        title.setFont(new Font("Arial",Font.BOLD, 100));
        painelLogin.add(title);

        JLabel jlbNome = new JLabel("NOME");
        jlbNome.setFont(new Font("Arial",Font.ITALIC, 20));
        painelLogin.add(jlbNome);
        painelLogin.add(campoInserirNome); // Adiciona o campo de texto jlbNome ao painel.

        JLabel jlaSenha = new JLabel("SENHA");
        jlaSenha.setFont(new Font("Arial",Font.ITALIC, 20));
        painelLogin.add(jlaSenha);
        painelLogin.add(campoInserirSenha);

        JButton jButtonEntrar = new JButton("Entrar");
        painelLogin.add(jButtonEntrar);

        JButton jButtonCadastrar = new JButton("Cadastrar");
        painelLogin.add(jButtonCadastrar);
        jButtonCadastrar.addActionListener(new ActionListener() { //adicinar evento ao botão
            @Override
            public void actionPerformed(ActionEvent e) {
                painelCadastro.setVisible(true);
                painelLogin.setVisible(false);
            }
        });
    }

    private void configPainelCadastrar() {
        setTitle("Cadastrar");
        painelCadastro = new JPanel();
        painelCadastro.setLayout(new FlowLayout());
        painelCadastro.setPreferredSize(new Dimension(300, 400));
        configEntraDados(); // Chama o método para configurar os elementos de entrada de dados.

        JLabel title = new JLabel("Cadastrar");
        title.setFont(new Font("Arial",Font.BOLD, 50));
        painelCadastro.add(title);

        JLabel jlbNome = new JLabel("NOME");
        jlbNome.setFont(new Font("Arial",Font.ITALIC, 20));
        painelCadastro.add(jlbNome);
        painelCadastro.add(campoInserirNome); // Adiciona o campo de texto jlbNome ao painel.

        JLabel jlaSenha = new JLabel("SENHA");
        jlaSenha.setFont(new Font("Arial",Font.ITALIC, 20));
        painelCadastro.add(jlaSenha);
        painelCadastro.add(campoInserirSenha);

        JButton jButtonEntrar = new JButton("Entrar");
        painelCadastro.add(jButtonEntrar);

        JButton jButtonCadastrar = new JButton("Cadastrar");
        painelCadastro.add(jButtonCadastrar);
        jButtonEntrar.addActionListener(new ActionListener() { //adicinar evento ao botão
            @Override
            public void actionPerformed(ActionEvent e) {
                painelCadastro.setVisible(false);
                painelLogin.setVisible(true);
            }
        });
    }

    private void inicializarJanela() {
        this.setLayout(new FlowLayout()); // Define o layout da janela como FlowLayout.
        this.setSize(new Dimension(350, 400)); // Define o tamanho da janela.
        this.setResizable(false); // Impede que a janela seja redimensionada.
        this.setLocationRelativeTo(null); // Centraliza a janela na tela.

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true); // Torna a janela visível

        configPaineLogin(); // Chama o método para configurar o painel jpnDados.
        this.add(painelLogin); // Adiciona o painel à janela.

        configPainelCadastrar();
        this.add(painelCadastro);


        revalidate(); // Revalida a interface gráfica.

    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
