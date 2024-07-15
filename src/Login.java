import javax.swing.*;
import java.awt.*;

public class Login extends JPanel {
    private JTextField campoInserirNome;
    private JPasswordField campoInserirSenha;

    public Login() {
        configPaineLogin();
    }

    private void configEntraDados() {
        campoInserirNome = new JTextField();
        campoInserirSenha = new JPasswordField();
    }

    private void configPaineLogin() {
        this.setLayout(new GridLayout(10, 1, 4, 1));
        this.setPreferredSize(new Dimension(300, 400));

        configEntraDados();
        JLabel title = new JLabel("LOGIN",SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 40));
        this.add(title);

        JLabel jlbNome = new JLabel("CPF");
        jlbNome.setFont(new Font("Arial", Font.BOLD, 18));
        this.add(jlbNome);
        this.add(campoInserirNome);

        JLabel jlaSenha = new JLabel("SENHA");
        jlaSenha.setFont(new Font("Arial", Font.BOLD, 18));
        this.add(jlaSenha);
        this.add(campoInserirSenha);

        JButton jButtonEntrar = new JButton("Entrar");
        jButtonEntrar.setBackground(Color.white);
        jButtonEntrar.setFont(new Font("Arial", Font.BOLD, 18));

        JButton jButtonCadastrar = new JButton("Cadastrar");
        jButtonCadastrar.setBackground(Color.white);
        jButtonCadastrar.setFont(new Font("Arial", Font.BOLD, 18));

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5)); // Espaçamento horizontal
        painelBotoes.add(jButtonEntrar);
        painelBotoes.add(jButtonCadastrar);
        this.add(painelBotoes);
    }

    private void setLayout(java.awt.GridLayout gridLayout) {

    }

    public static void main(String[] args) {
        new JanelaLoginCadastro(true);
    }
}
