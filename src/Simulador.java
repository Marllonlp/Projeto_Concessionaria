import javax.swing.*;
import java.awt.*;

public class Simulador extends JFrame {

    private JPanel simu;

    public Simulador() {
        inicializarJanela();
        simulando();
    }

    private void inicializarJanela() {
        setLayout(new FlowLayout());
        setTitle("Simulador de Carros");
        setSize(600, 400);
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setResizable(false); // Impede o redimensionamento da janela
        setVisible(true);
    }

    private void simulando() {
        simu = new JPanel();  // Cria um novo painel para o perfil do usuário
        simu.setLayout(new GridLayout(12,1,0,0));
        simu.setPreferredSize(new Dimension(400,400));

        JLabel title = new JLabel(" Simulação ", SwingConstants.CENTER);
        title.setFont(new Font(" Arial ", Font.BOLD, 30));
        simu.add(title);


        JTextField parcelasV = new JTextField(10);
        JTextField valorParcelaV = new JTextField(10);


        JLabel carro = new JLabel(" INFORMAÇÕES DO CARRO ");
        JLabel c = new JLabel(" -------- ");
        JLabel ca = new JLabel(" -------- ");

        JLabel parcelasD = new JLabel(" Entrada ");
        JLabel valorParD = new JLabel(" Valor da Parcela ");

        JButton simularButton = new JButton("Simular");


        simu.add(carro);
        simu.add(c);
        simu.add(ca);
        simu.add(parcelasD);
        simu.add(parcelasV);
        simu.add(valorParD);
        simu.add(valorParcelaV);

        // Adicionando o botão "Simular" ao painel
        simu.add(simularButton);

        add(simu);
        revalidate();
    }
}
