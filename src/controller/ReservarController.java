package controller;

import dao.ReservarDAO;
import model.Reservar;
import view.MenuPrincipal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReservarController {
    private MenuPrincipal menuPrincipal;
    private String titulo;
    private JButton botaoReservar;
    private ReservarDAO reservarDAO;

    public ReservarController(MenuPrincipal menuPrincipal, String titulo, JButton botaoReservar, ReservarDAO reservarDAO) {
        this.menuPrincipal = menuPrincipal;
        this.titulo = titulo;
        this.botaoReservar = botaoReservar;
        this.reservarDAO = reservarDAO;

        this.botaoReservar.addActionListener(new ReservarActionListener());
    }

    private class ReservarActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String cpfUsuarioLogado = menuPrincipal.getCpfUsuarioLogado();
            String nomeUsuarioLogado = menuPrincipal.getNomeUsuarioLogado();

            System.out.println("CPF do usuário logado: " + cpfUsuarioLogado); // Debugging

            if (cpfUsuarioLogado == null || cpfUsuarioLogado.isEmpty()) {
                JOptionPane.showMessageDialog(menuPrincipal, "Você precisa estar logado para fazer uma reserva.", "Erro de Reserva", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (reservarDAO.existeReserva(cpfUsuarioLogado, titulo)) {
                JOptionPane.showMessageDialog(menuPrincipal, "Você já reservou este carro.", "Reserva Existente", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Criar a reserva com os dados do usuário logado
                Reservar reserva = new Reservar(nomeUsuarioLogado, cpfUsuarioLogado, titulo);
                reservarDAO.save(reserva);
            }
        }
    }
}
