package controller;

import model.SimuladorModel;
import view.MenuPrincipal;
import view.Simulador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimuladorController extends Component {
    private String titulo;
    private Double valor;
    private SimuladorModel simuladorModel;
    private MenuPrincipal menuPrincipal;
    private Simulador simulador;

    public SimuladorController(String titulo, Double valor, MenuPrincipal menuPrincipal) {
        this.titulo = titulo;
        this.valor = valor;
        this.menuPrincipal = menuPrincipal;
        initialize();
    }

    private void initialize() {
        menuPrincipal.getBotaoSimularCompra().addActionListener(e -> {
            simulador = new Simulador(titulo, valor);
            initCalculo();
        });
    }

    private void initCalculo() {
        simulador.getButtonSimular().addActionListener(e -> calcularSimulacao(valor));
    }

    private void calcularSimulacao(Double valorCarro) {
        try {
            double entrada = Double.parseDouble(simulador.getParcelasV().getText());
            double valorParcela = Double.parseDouble(simulador.getValorParcelaV().getText());
            double taxaJurosMensal = 0.01; // 5% de juros ao mês

            // Cálculo do valor financiado
            double valorFinanciado = valorCarro - entrada;

            // Verifica se o valor da parcela é válido
            if (valorParcela <= 0) {
                JOptionPane.showMessageDialog(this, "O valor da parcela deve ser maior que zero.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Calcula o número de meses
            double meses = Math.log((valorParcela / (valorParcela - valorFinanciado * taxaJurosMensal)) /
                    (valorParcela / valorFinanciado)) / Math.log(1 + taxaJurosMensal);

            // Calcula o valor total pago
            double valorTotalPago = meses * valorParcela;

            JOptionPane.showMessageDialog(this, String.format(
                    "Número de meses para pagar o carro: %d\nValor total pago: R$ %.2f",
                    Math.round(meses), valorTotalPago), "Resultado", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos para a entrada e o valor da parcela.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
