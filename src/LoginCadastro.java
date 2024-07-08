import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginCadastro extends JFrame implements ActionListener { // Declaração da classe LoginCadastro, que herda da classe JFrame (para criar uma janela).
    private JPanel jpnDados;
    private JTextField campoInserirNome;
    private JTextField campoInserirEmail;
    private JPasswordField campoInserirSenha;
    private ActionEvent cadastrar;

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
    private void configJpnDados() {
        setTitle("Login");
        jpnDados = new JPanel();
        jpnDados.setLayout(new FlowLayout());
        jpnDados.setPreferredSize(new Dimension(300, 400));//jpnDados.setBackground(Color.cyan);
        configEntraDados(); // Chama o método para configurar os elementos de entrada de dados.

        JLabel title = new JLabel("Login");
        title.setFont(new Font("Arial",Font.BOLD, 100));

        title.setBackground(Color.red);
        jpnDados.add(title);


        JLabel jlbNome = new JLabel("NOME");
        jlbNome.setFont(new Font("Arial",Font.ITALIC, 20));
        jpnDados.add(jlbNome);
        jpnDados.add(campoInserirNome); // Adiciona o campo de texto jlbNome ao painel.

        JLabel jlaSenha = new JLabel("SENHA");
        jlaSenha.setFont(new Font("Arial",Font.ITALIC, 20));
        jpnDados.add(jlaSenha);
        jpnDados.add(campoInserirSenha);

        JButton jButtonEntrar = new JButton("Entrar");
        jpnDados.add(jButtonEntrar);

        JButton jButtonCadastrar = new JButton("Cadastrar");
        jpnDados.add(jButtonCadastrar);
        jButtonCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jpnDados.setVisible(false);
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

        configJpnDados(); // Chama o método para configurar o painel jpnDados.
        this.add(jpnDados); // Adiciona o painel à janela.

        revalidate(); // Revalida a interface gráfica.

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
