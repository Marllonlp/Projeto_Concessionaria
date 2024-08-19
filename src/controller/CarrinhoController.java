package controller;

import dao.CarrinhoDAO;
import model.CarrinhoModel;
import view.CarrinhoView;
import java.util.List;

public class CarrinhoController {
    private CarrinhoDAO carrinhoDAO;
    private String cpfUsuarioLogado;

    public CarrinhoController(String cpfUsuarioLogado) {
        this.carrinhoDAO = new CarrinhoDAO();
        this.cpfUsuarioLogado = cpfUsuarioLogado;
    }

    public void abrirJanelaReservas() {
        List<CarrinhoModel> reservas = carrinhoDAO.getReservasPorCpf(cpfUsuarioLogado);

    }
}
