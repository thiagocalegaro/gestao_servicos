package br.csi.service;

import br.csi.dao.UsuarioDAO;

public class LoginService {

    public boolean logar(String nome, String senha){
        return new UsuarioDAO().login(nome, senha);
    }


}
