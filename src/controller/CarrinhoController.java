package controller;

import dao.CarrinhoDAO;
import model.CarrinhoModel;
import model.Reservar;
import view.CarrinhoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;

public class CarrinhoController {
    private CarrinhoDAO carrinhoDAO;
    private String cpfUsuarioLogado;
    private JButton minhasReservasButton;
    private CarrinhoView carrinhoView;

    public CarrinhoController(String cpfUsuarioLogado, JButton minhasReservasButton) {
        this.carrinhoDAO = new CarrinhoDAO();
        this.cpfUsuarioLogado = cpfUsuarioLogado;
        this.minhasReservasButton = minhasReservasButton;
        configurarBotaoMinhasReservas();
        carrinhoView = new CarrinhoView();
    }

    private void configurarBotaoMinhasReservas() {
        minhasReservasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirJanelaReservas();
            }
        });
    }

    private void abrirJanelaReservas() {
        List<Reservar> reservas = carrinhoDAO.getReservasPorCpf(cpfUsuarioLogado);
        for (Reservar reserva : reservas) {
            carrinhoView.atualizarReservas(reservas);
            carrinhoView.exibir();
        }
    }
}
