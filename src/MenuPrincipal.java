import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {
    private JPanel jpMenu;
    private JPanel jpProdutos;

    public MenuPrincipal() {
        inicializarJanelaP();
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

        jpMenu.add(Box.createHorizontalGlue()); // Adiciona um preenchimento horizontal flexível

        JButton botaoPerfil = new JButton("Perfil");
        botaoPerfil.setFont(new Font("Arial", Font.ITALIC, 10));
        jpMenu.add(botaoPerfil);
    }

    public void configPainelProduto() {
        jpProdutos = new JPanel();
        jpProdutos.setLayout(new BoxLayout(jpProdutos, BoxLayout.Y_AXIS));
        produtos();
    }

    public void produtos() {
        adicionarProduto("Porche Macan", "Descrição do Porche Macan", "imagens/porche_macan.jpg");
        adicionarProduto("Ferrari Furosangue", "Descrição da Ferrari Furosangue", "imagens/ferrari_furosangue.jpg");
    }

    public void adicionarProduto(String titulo, String descricao, String caminhoImagem) {
        JPanel produtoPanel = new JPanel(new BorderLayout());
        produtoPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        produtoPanel.setBackground(Color.green);

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        ImageIcon imagemIcone = new ImageIcon(caminhoImagem);
        imagemIcone = new ImageIcon(imagemIcone.getImage().getScaledInstance(350, 250, Image.SCALE_SMOOTH));
        JLabel imagemProduto = new JLabel(imagemIcone);

        JLabel labelTitulo = new JLabel(titulo);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 15));

        JLabel labelDescricao = new JLabel(descricao);
        labelDescricao.setFont(new Font("Arial", Font.PLAIN, 12));

        infoPanel.add(imagemProduto);
        infoPanel.add(Box.createVerticalStrut(10)); // Espaçamento entre a imagem e o título
        infoPanel.add(labelTitulo);
        infoPanel.add(Box.createVerticalStrut(5)); // Espaçamento
        infoPanel.add(labelDescricao);

        JButton botaoSimularCompra = new JButton("Simular Compra");
        botaoSimularCompra.setFont(new Font("Arial", Font.BOLD, 12));
        botaoSimularCompra.setBackground(Color.yellow);

        produtoPanel.add(infoPanel, BorderLayout.CENTER);
        produtoPanel.add(botaoSimularCompra, BorderLayout.EAST);
        produtoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margem ao redor do produto

        jpProdutos.add(produtoPanel);
        jpProdutos.add(Box.createVerticalStrut(10)); // Espaçamento entre produtos
    }

    private void inicializarJanelaP() {
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(800, 700));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        configJanela();
        this.add(jpMenu, BorderLayout.NORTH);

        configPainelProduto();
        this.add(new JScrollPane(jpProdutos), BorderLayout.CENTER);

        this.setVisible(true);
        revalidate();
    }

    public static void main(String[] args) {
        new MenuPrincipal();
    }
}
