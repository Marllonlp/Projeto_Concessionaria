package view;
import controller.*;
import dao.ProdutoDAO;
import dao.ReservarDAO;
import dao.UsuarioDAO;
import model.CarrinhoModel;
import model.Usuario;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Function;

public class MenuPrincipal extends JFrame {
    private JPanel jpMenu;
    private JPanel jpProdutos;
    private JTextField jtBusca;
    private JButton botaoPerfil;
    private UsuarioDAO usuarioDAO;
    private Usuario usuario;
    private JButton botaoProduto;
    private JButton botaoSimularCompra;
    private JButton botaoReservar;
    private int idProdutoSelecionado;
    private JButton minhasReservas;
    private String cpfUsuario;
    private Usuario usuarioLogado;

    public MenuPrincipal(Usuario usuario, UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
        this.usuario = usuario;
        inicializarJanelaP();
        new PerfilController(usuario, this);
        new ProdutoController(new ProdutoView(), this);

    }
    public void addBotoes() {
        // Função para criar botões estilizados
        Function<String, JButton> criarBotao = (texto) -> {
            JButton botao = new JButton(texto);
            botao.setFont(new Font("Arial", Font.BOLD, 14));
            botao.setBackground(Color.lightGray);
            botao.setForeground(Color.BLACK);
            botao.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.DARK_GRAY, 1),
                    BorderFactory.createEmptyBorder(5, 10, 5, 10)
            ));
            botao.setFocusPainted(false);
            return botao;
        };

        // Botão Home
        setMinhasReservas(criarBotao.apply("Minhas Reservas"));
        jpMenu.add(Box.createHorizontalStrut(10));
        jpMenu.add(getMinhasReservas());

        // Botão Produto
        setBotaoProduto(criarBotao.apply("Adicionar Produto"));
        jpMenu.add(Box.createHorizontalStrut(10));
        jpMenu.add(getBotaoProduto());


        // Botão Contato
        JButton botaoContato = criarBotao.apply("Contato");
        jpMenu.add(Box.createHorizontalStrut(10));
        jpMenu.add(botaoContato);

        botaoContato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Contato();
            }
        });

        jpMenu.add(Box.createHorizontalGlue()); // Adiciona um preenchimento horizontal flexível
        setBotaoPerfil(criarBotao.apply("Perfil"));
        jpMenu.add(Box.createHorizontalStrut(10));
        jpMenu.add(getBotaoPerfil());
    }

    public void configPainelProduto() {
        jpProdutos = new JPanel(new GridLayout(0, 2, 10, 10)); // Altera para GridLayout com 2 colunas e espaçamento de 10px
        produtos();
    }
    public void produtos() {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        List<model.Produto> produtos = produtoDAO.getProdutos();

        for (model.Produto produto : produtos) {
            adicionarProduto(produto.getTitulo(), produto.getDescricao(),
                    (produto.getPreco()), produto.getCaminhoImagem());
        }
    }

    public void adicionarProduto(String titulo, String descricao, Double valor, String caminhoImagem) {
        JPanel produtoPanel = new JPanel();
        produtoPanel.setLayout(new BoxLayout(produtoPanel, BoxLayout.Y_AXIS));
        produtoPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        produtoPanel.setBackground(Color.white);

        ImageIcon imagemIcone = new ImageIcon(caminhoImagem);
        imagemIcone = new ImageIcon(imagemIcone.getImage().getScaledInstance(350, 250, Image.SCALE_SMOOTH));
        JLabel imagemProduto = new JLabel(imagemIcone);
        JLabel labelTitulo = new JLabel(titulo);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 25));
        JLabel labelDescricao = new JLabel(descricao);
        labelDescricao.setFont(new Font("Arial", Font.PLAIN, 20));
        JLabel labelValor = new JLabel(String.valueOf(valor));
        labelValor.setFont(new Font("Arial", Font.BOLD, 20));

        setBotaoSimularCompra(new JButton("Simular Compra"));
        getBotaoSimularCompra().setFont(new Font("Arial", Font.BOLD, 14));
        getBotaoSimularCompra().setBackground(Color.lightGray);
        getBotaoSimularCompra().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        new SimuladorController(titulo, valor, this);


        setBotaoReservar(new JButton("Reservar Carro"));
        getBotaoReservar().setFont(new Font("Arial", Font.BOLD, 14));
        getBotaoReservar().setBackground(Color.lightGray);
        getBotaoReservar().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        new ReservarController(this, titulo, botaoReservar, new ReservarDAO());


        produtoPanel.add(imagemProduto);
        produtoPanel.add(Box.createVerticalStrut(10)); // Espaçamento entre a imagem e o título
        produtoPanel.add(labelTitulo);
        produtoPanel.add(Box.createVerticalStrut(5)); // Espaçamento entre o título e a descrição
        produtoPanel.add(labelDescricao);
        produtoPanel.add(Box.createVerticalStrut(5)); // Espaçamento entre o título e a descrição
        produtoPanel.add(labelValor);
        produtoPanel.add(Box.createVerticalStrut(10)); // Espaçamento entre a descrição e os botões
        produtoPanel.add(getBotaoSimularCompra());
        produtoPanel.add(Box.createVerticalStrut(5)); // Espaçamento entre os botões
        produtoPanel.add(getBotaoReservar());
        produtoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margem ao redor do produto

        jpProdutos.add(produtoPanel);
    }

    private void inicializarJanelaP() {
        setTitle("Elite Sports Cars");
        setSize(800, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        jpMenu = new JPanel();
        jpMenu.setBackground(Color.gray);
        jpMenu.setLayout(new BoxLayout(jpMenu, BoxLayout.LINE_AXIS)); // Layout horizontal

        // Barra de Pesquisa
        jtBusca = new JTextField(20);
        jtBusca.setMaximumSize(new Dimension(200, 30));
        jtBusca.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.DARK_GRAY, 1),
                BorderFactory.createEmptyBorder(2, 5, 2, 5)

        ));

        JButton botaoBuscar = new JButton("Buscar");
        botaoBuscar.setFont(new Font("Arial", Font.BOLD, 14));
        botaoBuscar.setBackground(Color.lightGray);
        botaoBuscar.setForeground(Color.BLACK);
        botaoBuscar.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.DARK_GRAY, 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        botaoBuscar.setFocusPainted(false);

        jpMenu.add(Box.createHorizontalStrut(10));
        jpMenu.add(jtBusca);
        jpMenu.add(Box.createHorizontalStrut(5));
        jpMenu.add(botaoBuscar);
        jpMenu.add(Box.createHorizontalGlue());
        addBotoes(); // Método para adicionar os botões existentes

        configPainelProduto();
        JScrollPane scrollPane = new JScrollPane(jpProdutos);
        this.add(scrollPane);

        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        this.setVisible(true);
        revalidate();

        setLayout(new BorderLayout());
        add(jpMenu, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    public JButton getBotaoSimularCompra() {
        return botaoSimularCompra;
    }

    public void setBotaoSimularCompra(JButton botaoSimularCompra) {
        this.botaoSimularCompra = botaoSimularCompra;
    }

    public JButton getBotaoPerfil() {
        return botaoPerfil;
    }

    public void setBotaoPerfil(JButton botaoPerfil) {
        this.botaoPerfil = botaoPerfil;
    }

    public JButton getBotaoProduto() {
        return botaoProduto;
    }

    public void setBotaoProduto(JButton botaoProduto) {
        this.botaoProduto = botaoProduto;
    }

    public JButton getBotaoReservar() {
        return botaoReservar;
    }

    public void setBotaoReservar(JButton botaoReservar) {
        this.botaoReservar = botaoReservar;
    }

    public int getIdProdutoSelecionado() {
        return idProdutoSelecionado;
    }

    public void setIdProdutoSelecionado(int idProdutoSelecionado) {
        this.idProdutoSelecionado = idProdutoSelecionado;
    }

    public JButton getMinhasReservas() {
        return minhasReservas;
    }

    public void setMinhasReservas(JButton minhasReservas) {
        this.minhasReservas = minhasReservas;
    }


    public String getNomeUsuarioLogado() {
        return this.usuario.getNome();
    }

    public String getCpfUsuarioLogado() {
        return this.usuario.getCpf();
    }
}
