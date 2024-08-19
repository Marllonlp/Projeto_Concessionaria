package controller;
import model.Usuario;
import view.MenuPrincipal;
import view.PerfilUsuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PerfilController {
    private final MenuPrincipal menuPrincipalView;
    private final Usuario usuarioDAO;
    private final PerfilUsuario perfilView;

    public PerfilController(Usuario usuarioDAO, MenuPrincipal menuPrincipalView) {
        this.usuarioDAO = usuarioDAO;
        this.menuPrincipalView = menuPrincipalView;
        this.perfilView = new PerfilUsuario();
        initController();
    }

    private void initController() {
        this.menuPrincipalView.getBotaoPerfil().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carregarDadosPerfil();
                perfilView.setVisible(true);
            }
        });
    }


    private void carregarDadosPerfil() {
        try {
            Usuario usuario = this.usuarioDAO;
            if (usuario != null) {
                perfilView.exibirDadosUsuario(usuario.getNome(), usuario.getTel(), usuario.getEmail());
            }
        } catch (Exception e) {
            perfilView.exibirMensagemErro("Erro ao carregar os dados do perfil: " + e.getMessage());
        }
    }
}
