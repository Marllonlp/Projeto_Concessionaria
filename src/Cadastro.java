import javax.swing.*;
import java.awt.*;

public class Cadastro extends JPanel {
    private JTextField campoNome;
    private JTextField campoCPF;
    private JTextField campoEmail;
    private JTextField campoEnder;
    private JTextField campoTel;
    private JPasswordField campoSenha;

    public Cadastro() {
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
        this.setLayout(new GridLayout(14, 1, 4, 1));
        this.setPreferredSize(new Dimension(300, 480));
        configEntraDados();

        JLabel title = new JLabel("CADASTRO", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        this.add(title);

        JLabel jlbNome = new JLabel("NOME");
        jlbNome.setFont(new Font("Arial", Font.BOLD, 15));
        this.add(jlbNome);
        this.add(campoNome);


        JLabel jlbCPF = new JLabel("CPF");
        jlbCPF.setFont(new Font("Arial", Font.BOLD, 15));
        this.add(jlbCPF);
        this.add(campoCPF);

        JLabel jlbEmail = new JLabel("E-MAIL");
        jlbEmail.setFont(new Font("Arial", Font.BOLD, 15));
        this.add(jlbEmail);
        this.add(campoEmail);

        JLabel jlbTel = new JLabel("TELEFONE");
        jlbTel.setFont(new Font("Arial", Font.BOLD, 15));
        this.add(jlbTel);
        this.add(campoTel);

        JLabel jlbEnd = new JLabel("ENDEREÇO");
        jlbEnd.setFont(new Font("Arial", Font.BOLD, 15));
        this.add(jlbEnd);
        this.add(campoEnder);

        JLabel jlaSenha = new JLabel("SENHA");
        jlaSenha.setFont(new Font("Arial", Font.BOLD, 15));
        this.add(jlaSenha);
        this.add(campoSenha);


        JButton jButtonEntrar = new JButton("Entrar");
        jButtonEntrar.setFont(new Font("Arial", Font.BOLD, 15));
        jButtonEntrar.setBackground(Color.LIGHT_GRAY);
        jButtonEntrar.setForeground(Color.black);

        JButton jButtonCadastrar = new JButton("Cadastrar");
        jButtonCadastrar.setFont(new Font("Arial", Font.BOLD, 15));
        jButtonCadastrar.setBackground(Color.LIGHT_GRAY);
        jButtonCadastrar.setForeground(Color.BLACK);

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 6)); // Espaçamento horizontal
        painelBotoes.add(jButtonEntrar);
        painelBotoes.add(jButtonCadastrar);
        this.add(painelBotoes);
    }

    public static void main(String[] args) {
        new JanelaLoginCadastro(false);
    }
}

