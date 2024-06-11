package br.csi.service;

import br.csi.dao.UsuarioDAO;
import br.csi.model.Usuario;

public class UsuarioService {

    public boolean cadastrar(Usuario usuario) {

        return new UsuarioDAO().cadastrar(usuario);
    }
}