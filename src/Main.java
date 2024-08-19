import controller.PerfilController;
import dao.UsuarioDAO;
import view.JanelaLoginCadastro;
import view.MenuPrincipal;

public class Main {
    public static void main(String[] args) {
        JanelaLoginCadastro a = new JanelaLoginCadastro(true);
        a.setVisible(true);
    }

}
