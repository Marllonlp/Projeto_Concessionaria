package controller;

import dao.ProdutoDAO;
import view.MenuPrincipal;
import view.ProdutoView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProdutoController {
    private ProdutoView produtoView;
    private MenuPrincipal menuPrincipalView;

    public ProdutoController(ProdutoView view, MenuPrincipal menuPrincipal) {
        this.produtoView = view;
        this.menuPrincipalView = menuPrincipal;
        this.produtoView.addAdicionarListener(new AdicionarProdutoListener());
        initController();
    }

    private void initController() {
        this.menuPrincipalView.getBotaoProduto().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                produtoView.setVisible(true);
                menuPrincipalView.revalidate();
                menuPrincipalView.repaint();
            }
        });
    }

    public class AdicionarProdutoListener implements ActionListener {
        ProdutoDAO produtoDAO = new ProdutoDAO();

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                model.Produto produto = produtoView.getProduto();
                Boolean resut = produtoDAO.save(produto);
                if (!resut) {
                    throw new Exception("Erro ao adicionar produto: ");
                }
                JOptionPane.showMessageDialog(produtoView, "Produto adicionado com sucesso!");
                produtoView.limparCampos();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(produtoView, " " + ex.getMessage());
            }
        }
    }
}

