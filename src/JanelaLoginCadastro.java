import javax.swing.*;
import java.awt.*;
public class JanelaLoginCadastro extends JFrame{
    JPanel painelLogin = new Login();
    JPanel painelCadastro = new Cadastro();

    public JanelaLoginCadastro(Boolean cond) {
        inicializarJanela();
        if(cond){
            painelLogin.setVisible(true);
            painelCadastro.setVisible(false);
        }else {
            painelCadastro.setVisible(true);
            painelLogin.setVisible(false);
        }
    }

    private void inicializarJanela() {
        this.setLayout(new FlowLayout());
        this.setSize(new Dimension(450, 550));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true); // Torna a janela visível
        this.add(painelLogin);
        this.add(painelCadastro);
        revalidate(); // Revalida a interface gráfica.
    }


}
