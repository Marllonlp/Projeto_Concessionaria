import javax.swing.*;
import java.awt.*;

public class Login extends JPanel {
    private JTextField campoInserirCPF;
    private JPasswordField campoInserirSenha;
    private JComboBox<String> opcAdmUser;

    public Login() {
        configPaineLogin();
    }

    private void configEntraDados() {
        campoInserirCPF = new JTextField();
        campoInserirSenha = new JPasswordField();
        opcAdmUser = new JComboBox<String>(new String[]{"Admin","User"});
    }

    private void configPaineLogin() {
        this.setLayout(new GridLayout(10, 1, 4, 1));
        this.setPreferredSize(new Dimension(300, 500));
        this.setBorder(BorderFactory.createEmptyBorder(80, 1, 0, 0));
        configEntraDados();
        JLabel title = new JLabel("LOGIN",SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 40));
        this.add(title);

        JLabel jlbOpcAdmUser = new JLabel("Entrar como");
        jlbOpcAdmUser.setFont(new Font("Arial", Font.BOLD, 18));
        this.add(jlbOpcAdmUser);
        opcAdmUser.setFont(new Font("Arial", Font.BOLD, 18));
        this.add(opcAdmUser);


        JLabel jlbCPF = new JLabel("CPF");
        jlbCPF.setFont(new Font("Arial", Font.BOLD, 18));
        this.add(jlbCPF);
        this.add(campoInserirCPF);

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
        painelBotoes.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 6)); // Espaçamento horizontal
        painelBotoes.add(jButtonEntrar);
        painelBotoes.add(jButtonCadastrar);
        this.add(painelBotoes);
    }

    public static void main(String[] args) {
        new JanelaLoginCadastro(true);
    }
}
