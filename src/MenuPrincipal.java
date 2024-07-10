import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {
    private JPanel jpMenu;
    private JPanel jpProdutos;

    public MenuPrincipal(){
        incializarJanelaP();
    }

    public void confgJanela() {
        jpMenu = new JPanel();
        jpMenu.setBackground(Color.red);
        jpMenu.setPreferredSize(new Dimension(this.getWidth(), 40));
        jpMenu.setLayout(new FlowLayout(FlowLayout.LEFT,20, 10));
        addBotoes();
    }

    public void addBotoes(){
        JButton botaoProd = new JButton("Menu");
        botaoProd.setFont(new Font("Arial", Font.ITALIC, 10));
        jpMenu.add(botaoProd);

        JButton botaoSimu = new JButton("Simulado");
        botaoSimu.setFont(new Font("Arial", Font.ITALIC,10));
        jpMenu.add(botaoSimu);

        JButton botaoPerfil = new JButton("Pefil");
        botaoPerfil.setFont(new Font("Arial",Font.ITALIC,10));
        jpMenu.add(botaoPerfil);

    }

    private void incializarJanelaP(){
        this.setLayout(new FlowLayout());
        this.setSize(new Dimension(900,800 ));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        confgJanela();
        add(jpMenu);

        revalidate();
    }
}
