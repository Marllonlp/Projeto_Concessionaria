
package model;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoModel {
    private List<Reservar> reservas;

    public CarrinhoModel() {
        this.reservas = new ArrayList<>();
    }

    public void adicionarReserva(Reservar reserva) {
        reservas.add(reserva);
    }

    public List<Reservar> getReservas() {
        return reservas;
    }
}
