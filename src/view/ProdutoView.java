package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

public class ProdutoView extends JFrame {
    private JPanel jproduto;
    private JTextField idField, tituloField, descricaoField, precoField;
    private JLabel imagemLabel;
    private String caminhoImagem;
    private JButton adicionarButton;

    public ProdutoView() {
        inicializarJanela();
        inicializarComponentes();
    }

    private void inicializarJanela() {
        setLayout(new FlowLayout());
        setTitle("Cadastro de Veículo");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void inicializarComponentes() {
        jproduto = new JPanel();
        jproduto.setLayout(new GridLayout(15, 1, 0, 5));  // Alterado para 15 linhas
        jproduto.setPreferredSize(new Dimension(500, 500));  // Alterado para 500x500

        JLabel title = new JLabel("Cadastrar veículo", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        jproduto.add(title);


        idField = new JTextField(10);
        tituloField = new JTextField(10);
        descricaoField = new JTextField(10);
        precoField = new JTextField(10);  // Campo para o preço

        JLabel idLabel = new JLabel("ID do Veículo");
        JLabel tituloLabel = new JLabel("Título do Veículo");
        JLabel descricaoLabel = new JLabel("Descrição do Veículo");
        JLabel precoLabel = new JLabel("Preço do Veículo");  // Label para o preço

        jproduto.add(idLabel);  // Adiciona o label do ID
        jproduto.add(idField);  // Adiciona o campo do ID
        jproduto.add(tituloLabel);
        jproduto.add(tituloField);
        jproduto.add(descricaoLabel);
        jproduto.add(descricaoField);
        jproduto.add(precoLabel);  // Adiciona o label do preço
        jproduto.add(precoField);  // Adiciona o campo do preço

        JLabel imagemTituloLabel = new JLabel("Imagem do Veículo");
        jproduto.add(imagemTituloLabel);

        JButton escolherImagemButton = new JButton("Escolher Imagem");
        jproduto.add(escolherImagemButton);

        imagemLabel = new JLabel("Nenhuma imagem selecionada");
        jproduto.add(imagemLabel);

        escolherImagemButton.addActionListener(e -> escolherImagem());

        adicionarButton = new JButton("Adicionar");
        jproduto.add(adicionarButton);

        add(jproduto);
        pack();
    }

    private void escolherImagem() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            caminhoImagem = selectedFile.getAbsolutePath();
            imagemLabel.setText(caminhoImagem);
        }
    }

    public void addAdicionarListener(ActionListener listener) {
        adicionarButton.addActionListener(listener);
    }

    public model.Produto getProduto() {
        String idText = idField.getText();
        String titulo = tituloField.getText();
        String descricao = descricaoField.getText();
        Double preco;

        int id;
        try {
            id = Integer.parseInt(idText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID inválido. Por favor, insira um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        try {
            preco = Double.parseDouble(precoField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Preço inválido. Por favor, insira um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        return new model.Produto(id, titulo, descricao, preco, caminhoImagem);
    }

    public void limparCampos() {
        idField.setText("");
        tituloField.setText("");
        descricaoField.setText("");
        precoField.setText("");  // Limpa o campo de preço
        imagemLabel.setText("Nenhuma imagem selecionada");
        caminhoImagem = null;
    }

    public void exibir() {
        setVisible(true);
    }
}
