package br.csi.service;

import br.csi.dao.FuncionarioDAO;
import br.csi.model.Funcionario;

public class FuncionarioService {

    public boolean cadastrar(Funcionario funcionario){

        return  new FuncionarioDAO().cadastrar(funcionario);
    }

    public boolean demitir(int idFunc) {

        return new FuncionarioDAO().demitir(idFunc);
    }
}
