package view;

import controller.SimuladorController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Simulador extends JFrame {
    private JPanel simu;
    private JButton buttonSimular;
    private JTextField parcelasV;
    private JTextField valorParcelaV;


    public Simulador(String titulo, Double valor) {
        inicializarJanela();
        simulando(titulo, valor);
    }

    private void inicializarJanela() {
        setLayout(new FlowLayout());
        setTitle("Simulador de Carros");
        setSize(600, 400);
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setResizable(false); // Impede o redimensionamento da janela
        setVisible(true);
    }

    private void simulando(String titulo, Double valor) {
        simu = new JPanel();
        simu.setLayout(new GridLayout(12,1,0,0));
        simu.setPreferredSize(new Dimension(400,400));

        JLabel title = new JLabel(" Simulação ", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        simu.add(title);

        JLabel carroInfo = new JLabel("Título do Carro: " + titulo);
        JLabel valorInfo = new JLabel("Valor do Carro: R$ " + valor);

        JLabel jurosD = new JLabel("5% de juros por mês");

        parcelasV = new JTextField(10);
        valorParcelaV = new JTextField(10);

        JLabel parcelasD = new JLabel("Entrada ");
        JLabel valorParD = new JLabel("Valor da Parcela ");

        setButtonSimular(new JButton("Simular"));


        simu.add(carroInfo);
        simu.add(valorInfo);
        simu.add(jurosD);
        simu.add(parcelasD);
        simu.add(parcelasV);
        simu.add(valorParD);
        simu.add(valorParcelaV);
        simu.add(getButtonSimular());

        add(simu);
        revalidate();
    }

    public JButton getButtonSimular() {
        return buttonSimular;
    }

    public void setButtonSimular(JButton buttonSimular) {
        this.buttonSimular = buttonSimular;
    }

    public JPanel getSimu() {
        return simu;
    }

    public void setSimu(JPanel simu) {
        this.simu = simu;
    }

    public JTextField getParcelasV() {
        return parcelasV;
    }

    public void setParcelasV(JTextField parcelasV) {
        this.parcelasV = parcelasV;
    }

    public JTextField getValorParcelaV() {
        return valorParcelaV;
    }

    public void setValorParcelaV(JTextField valorParcelaV) {
        this.valorParcelaV = valorParcelaV;
    }
}
