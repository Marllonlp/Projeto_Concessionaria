import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal extends JFrame {
    private JPanel jpMenu;
    private JPanel jpProdutos;
    private JTextField jtBusca;

    public MenuPrincipal() {
        inicializarJanelaP();

    }

    public void configJanela() {
        jpMenu = new JPanel();
        jpMenu.setBackground(Color.darkGray);
        jpMenu.setPreferredSize(new Dimension(this.getWidth(), 30));
        jpMenu.setLayout(new BoxLayout(jpMenu, BoxLayout.LINE_AXIS)); //Altera para BoxLayout
        addBotoes();
    }

    //Botao Home
    public void addBotoes() {
        JButton botaoHome = new JButton("Home");
        jpMenu.add(Box.createHorizontalStrut(0));
        botaoHome.setFont(new Font("Arial", Font.BOLD, 15));
        botaoHome.setBackground(Color.white);
        jpMenu.add(botaoHome);

        // Botao Sobre
        JButton botaoSobre = new JButton("Sobre");
        jpMenu.add(Box.createHorizontalStrut(10));
        botaoSobre.setFont(new Font("Arial", Font.BOLD, 15));
        botaoSobre.setBackground(Color.white);
        jpMenu.add(botaoSobre);

        JButton botaoContato = new JButton("Contato");
        jpMenu.add(Box.createHorizontalStrut(10));
        botaoContato.setFont(new Font("Arial", Font.BOLD, 15));
        botaoContato.setBackground(Color.white);
        jpMenu.add(botaoContato);

        botaoContato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Contato();
                botaoContato.setVisible(true);
            }
        });

        jpMenu.add(Box.createHorizontalGlue()); // Adiciona um preenchimento horizontal flexível

        // Botao Perfil
        JButton botaoPerfil = new JButton("Perfil");
        botaoPerfil.setFont(new Font("Arial", Font.BOLD, 15));
        botaoPerfil.setBackground(Color.white);
        jpMenu.add(botaoPerfil);

        botaoPerfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PerfilUsuario();
                botaoPerfil.setVisible(true);
            }
        });


    }

    public void configPainelProduto() {
        jpProdutos = new JPanel(new GridLayout(0, 2, 10, 10)); // Altera para GridLayout com 2 colunas e espaçamento de 10px
        produtos();
    }

    public void produtos() {
        adicionarProduto("Nissan GTR", "Descrição do Nissan GTR", "imagens/nissan_GTR.jpg");
        adicionarProduto("Porche Macan", "Descrição do Porche Macan", "imagens/porche_macan.jpg");
        adicionarProduto("Lamborghini Urus", "Descrição da Lamborghini Urus", "imagens/urus.jpg");
        adicionarProduto("Fusca", "Descrição do Volkswagen Fusca", "imagens/fusca.jpg");
        adicionarProduto("Ferrari Furosangue", "Descrição da Ferrari Furosangue", "imagens/ferrari_furosangue.jpg");
        adicionarProduto("Audi R8", "Descrição do Audi R8", "imagens/audi.jpeg");
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
        botaoSimularCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Simulador();
                botaoSimularCompra.setVisible(true);
            }
        });

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
        setTitle("Elite Sports Cars");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


        configJanela();
        this.add(jpMenu, BorderLayout.NORTH);

        configPainelProduto();
        JScrollPane scrollPane = new JScrollPane(jpProdutos);
        this.add(scrollPane);

        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        this.setVisible(true);
        revalidate();

    }
}
