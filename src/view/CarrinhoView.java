// view/CarrinhoView.java
package view;

import model.CarrinhoModel;
import model.Reservar;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CarrinhoView extends JFrame {
    private JPanel panelReservas;

    public CarrinhoView() {
        setTitle("Meu Carrinho de Reservas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        panelReservas = new JPanel();
        panelReservas.setLayout(new BoxLayout(panelReservas, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(panelReservas);
        add(scrollPane);
    }

    public void atualizarReservas(List<Reservar> reservas) {
        panelReservas.removeAll();
        if (reservas != null && !reservas.isEmpty()) {
            for (Reservar reserva : reservas) {
                JLabel lblTitulo = new JLabel(reserva.getTitulo());
                lblTitulo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                panelReservas.add(lblTitulo);
            }
        } else {
            JLabel lblMensagem = new JLabel("Nenhuma reserva encontrada.");
            lblMensagem.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            panelReservas.add(lblMensagem);
        }
        panelReservas.revalidate();
        panelReservas.repaint();
    }

    public void exibir() {
        setVisible(true);
    }
}
