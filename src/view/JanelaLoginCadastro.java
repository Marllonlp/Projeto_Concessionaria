package view;
import controller.AutenticarUserController;

import javax.swing.*;
import java.awt.*;

public class JanelaLoginCadastro extends JFrame {
    JPanel painelLogin;
    JPanel painelCadastro;



    CardLayout cardLayout;
    JPanel contentPane;

    public JanelaLoginCadastro(Boolean cond) {
        inicializarJanela();
        painelLogin = new Login(this);
        painelCadastro = new Cadastro(this);

        cardLayout = new CardLayout();
        contentPane = new JPanel(cardLayout);
        contentPane.add(painelLogin, "login");
        contentPane.add(painelCadastro, "cadastro");

        this.setContentPane(contentPane);
        new AutenticarUserController((Cadastro) painelCadastro, (Login) painelLogin, this);

        if(cond) {
            cardLayout.show(contentPane, "login");
        } else {
            cardLayout.show(contentPane, "cadastro");
        }
    }

    private void inicializarJanela() {
        this.setSize(new Dimension(400, 600));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void mostrarLogin() {
        cardLayout.show(contentPane, "login");
    }

    public void mostrarCadastro() {
        cardLayout.show(contentPane, "cadastro");
    }
    public CardLayout getCardLayout() {
        return cardLayout;
    }
}