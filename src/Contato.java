import javax.swing.*;
import java.awt.*;

public class Contato extends JFrame {
    private JPanel contato;

    public Contato() {
        inicializarJanelaP();
        janelaPerfil();
    }

    private void inicializarJanelaP() {
        setSize(700, 400);  // Define o tamanho da janela
        setLocationRelativeTo(null);  // Centraliza a janela na tela
        setTitle("Atendimento ao Cliente");
        setResizable(false);
        setVisible(true);
    }

    public void janelaPerfil() {
        contato = new JPanel();  // Cria um novo painel para o perfil do usuário
        contato.setBackground(Color.white);
        contato.setLayout(new BoxLayout(contato, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Contato");
        title.setFont(new Font("Arial", Font.BOLD, 40));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);  // Alinha o título ao centro horizontalmente
        contato.add(Box.createVerticalStrut(20));  // Adiciona um espaço vertical antes do título
        contato.add(title);
        contato.add(Box.createVerticalStrut(40));

        config("E-mail: user@example.com");
        config("Avenida das Nações, 1234");
        config("Bairro: Centro");
        config("Cidade: Cidade - Estado");
        config("CEP: 01234-567");
        config("Telefone: (00) 12345 - 6789");


        add(contato, BorderLayout.CENTER);
        revalidate();
    }

    private void config(String texto) {
        JLabel fonte = new JLabel(texto);
        fonte.setFont(new Font("Sans-serif", Font.BOLD, 13));
        fonte.setAlignmentX(Component.CENTER_ALIGNMENT);
        contato.add(fonte);
        contato.add(Box.createVerticalStrut(10));
    }

}
