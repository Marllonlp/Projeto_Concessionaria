import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {
    private JPanel jpMenu;
    private JPanel jpProdutos;

    public MenuPrincipal() {
        incializarJanelaP();
    }

    public void configJanela() {
        jpMenu = new JPanel();
        jpMenu.setBackground(Color.red);
        jpMenu.setPreferredSize(new Dimension(this.getWidth(), 30));
        jpMenu.setLayout(new BoxLayout(jpMenu, BoxLayout.LINE_AXIS)); // Altera para BoxLayout
        addBotoes();

    }

    public void addBotoes() {
        JButton botaoProd = new JButton("Menu");
        jpMenu.add(Box.createHorizontalStrut(10));
        botaoProd.setFont(new Font("Arial", Font.ITALIC, 10));
        jpMenu.add(botaoProd);

        jpMenu.add(Box.createHorizontalStrut(10));
        JButton botaoSimu = new JButton("Simulado");
        botaoSimu.setFont(new Font("Arial", Font.ITALIC, 10));
        jpMenu.add(botaoSimu);

        jpMenu.add(Box.createHorizontalStrut(450)); // Adiciona um preenchimento horizontal

        JButton botaoPerfil = new JButton("Pefil");
        botaoPerfil.setFont(new Font("Arial", Font.ITALIC, 10));
        jpMenu.add(botaoPerfil);

    }

//    public void carros() {
//       JPanel jCarros = new JPanel();
////       jCarros.setLayout(new GridLayout(10, 2, 10, 10));
//       jCarros.setPreferredSize(new Dimension(400, 400));
//       jCarros.setBackground(Color.blue);
//       jpMenu.add(jCarros);
//    }

    private void incializarJanelaP() {
        this.setLayout(new FlowLayout());
        this.setSize(new Dimension(700, 600));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        configJanela();
        add(jpMenu, BorderLayout.NORTH); // Adiciona o painel no norte (topo)
        jpMenu.revalidate();
    }
}
