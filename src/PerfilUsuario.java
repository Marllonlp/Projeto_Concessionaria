import dao.UsuarioDAO;
import model.Usuario;

import javax.swing.*;
import java.awt.*;

public class PerfilUsuario extends JFrame {
    private JPanel perfilUsuario;
    public PerfilUsuario() {
        inicializarJanelaP();
        janelaPerfil();
    }

    private void inicializarJanelaP() {
        setSize(700, 400);  // Define o tamanho da janela
        setLocationRelativeTo(null);  // Centraliza a janela na tela
        setTitle("Perfil de Usuário");
        setResizable(false);
        setVisible(true);
    }

    public void janelaPerfil() {
        perfilUsuario = new JPanel();  // Cria um novo painel para o perfil do usuário
        perfilUsuario.setBackground(Color.white);
        perfilUsuario.setLayout(new BoxLayout(perfilUsuario, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Perfil");
        title.setFont(new Font("Arial", Font.BOLD, 40));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);  // Alinha o título ao centro horizontalmente
        perfilUsuario.add(Box.createVerticalStrut(20));  // Adiciona um espaço vertical antes do título
        perfilUsuario.add(title);
        perfilUsuario.add(Box.createVerticalStrut(40));

//        Usuario dadosUser = new Usuario();
//        config("E-mail: "+ dadosUser.getEmail());
//        config("Telefone: "+ dadosUser.getTel());
//        config("CPF: "+ dadosUser.getCpf());
//        UsuarioDAO salva = new UsuarioDAO();
//        salva.save(dadosUser);


        add(perfilUsuario, BorderLayout.CENTER);
        revalidate();
    }

    private void config(String texto) {
        JLabel fonte = new JLabel(texto);
        fonte.setFont(new Font("Sans-serif", Font.BOLD, 13));
        fonte.setAlignmentX(Component.CENTER_ALIGNMENT);
        perfilUsuario.add(fonte);
        perfilUsuario.add(Box.createVerticalStrut(10));
    }

}
