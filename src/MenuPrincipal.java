import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MenuPrincipal extends JFrame {
    private JPanel jpMenu;
    private JPanel jpProdutos;

    public MenuPrincipal() {
        inicializarJanelaP();
    }

    public void configJanela() {
        jpMenu = new JPanel();
        jpMenu.setBackground(Color.gray);
        jpMenu.setPreferredSize(new Dimension(this.getWidth(), 30));
        jpMenu.setLayout(new BoxLayout(jpMenu, BoxLayout.LINE_AXIS)); //Altera para BoxLayout
        addBotoes();
    }

    public void addBotoes() {
        JButton botaoHome = new JButton("Home");
        jpMenu.add(Box.createHorizontalStrut(10));
        botaoHome.setFont(new Font("Arial", Font.BOLD, 15));
        botaoHome.setBackground(Color.white);
        jpMenu.add(botaoHome);

        jpMenu.add(Box.createHorizontalStrut(10));
        JButton botaoSimu = new JButton("Simulado");
        jpMenu.add(Box.createHorizontalStrut(2));
        botaoSimu.setFont(new Font("Arial", Font.BOLD, 15));
        botaoSimu.setBackground(Color.white);
        jpMenu.add(botaoSimu);

        JButton botaoSobre = new JButton("Sobre");
        jpMenu.add(Box.createHorizontalStrut(10));
        botaoSobre.setFont(new Font("Arial", Font.BOLD, 15));
        botaoSobre.setBackground(Color.white);
        jpMenu.add(botaoSobre);

        jpMenu.add(Box.createHorizontalGlue()); // Adiciona um preenchimento horizontal flexível

        JButton botaoPerfil = new JButton("Perfil");
        botaoPerfil.setFont(new Font("Arial", Font.BOLD, 15));
        botaoPerfil.setBackground(Color.white);
        jpMenu.add(botaoPerfil);
    }

    public void configPainelProduto() {
        jpProdutos = new JPanel(new GridLayout(0, 2, 10, 10)); // Altera para GridLayout com 2 colunas e espaçamento de 10px
        produtos();
    }

    public void produtos() {
        adicionarProduto("Porche Macan", "Descrição do Porche Macan", "imagens/porche_macan.jpg");
        adicionarProduto("Ferrari Furosangue", "Descrição da Ferrari Furosangue", "imagens/ferrari_furosangue.jpg");
        adicionarProduto("Nissan GTR", "Descrição da Nissan GTR", "imagens/nissan_GTR.jpg");
        adicionarProduto("BMW 320i", "Descrição da BMW 320i", "imagens/bmw_320i.jpg");
        adicionarProduto("BMW 320i", "Descrição da BMW 320i", "imagens/bmw_320i.jpg");
    }

    public void adicionarProduto(String titulo, String descricao, String caminhoImagem) {
        JPanel produtoPanel = new JPanel();
        produtoPanel.setLayout(new BoxLayout(produtoPanel, BoxLayout.Y_AXIS));
        produtoPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        produtoPanel.setBackground(Color.white);

        ImageIcon imagemIcone = new ImageIcon(caminhoImagem);
        imagemIcone = new ImageIcon(imagemIcone.getImage().getScaledInstance(350, 250, Image.SCALE_SMOOTH));
        JLabel imagemProduto = new JLabel(imagemIcone);

        JLabel labelTitulo = new JLabel(titulo);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel labelDescricao = new JLabel(descricao);
        labelDescricao.setFont(new Font("Arial", Font.PLAIN, 14));

        JButton botaoSimularCompra = new JButton("Simular Compra");
        botaoSimularCompra.setFont(new Font("Arial", Font.BOLD, 14));;
        botaoSimularCompra.setBorder(new EmptyBorder(10,1,1,1));
        botaoSimularCompra.setBackground(Color.lightGray);
        botaoSimularCompra.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        produtoPanel.add(imagemProduto);
        produtoPanel.add(Box.createVerticalStrut(10)); // Espaçamento entre a imagem e o título
        produtoPanel.add(labelTitulo);
        produtoPanel.add(Box.createVerticalStrut(5)); // Espaçamento entre o título e a descrição
        produtoPanel.add(labelDescricao);
        produtoPanel.add(Box.createVerticalStrut(10)); // Espaçamento entre a descrição e o botão
        produtoPanel.add(botaoSimularCompra);
        produtoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margem ao redor do produto
        jpProdutos.add(produtoPanel);
    }

    private void inicializarJanelaP() {
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(798, 700));
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

}
