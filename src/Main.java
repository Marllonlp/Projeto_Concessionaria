import dao.UsuarioDAO;
import model.Usuario;

public class Main {
    public static void main(String[] args) {
        Usuario user = new Usuario();
        user.setNome("Marlon");
        user.setCpf("1736253652");
        user.setEmail("marlon@2091");
        user.setTel("390002111");
        user.setEnd("if goiano");
        user.setSenha("1234");

        UsuarioDAO teste = new UsuarioDAO();
        teste.save(user);
    }
}
