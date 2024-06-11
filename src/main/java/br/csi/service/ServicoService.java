package br.csi.service;

import br.csi.dao.FuncionarioDAO;
import br.csi.dao.ServicoDAO;
import br.csi.model.Funcionario;
import br.csi.model.Servico;

import java.util.ArrayList;

public class ServicoService {
    public boolean adicionar(Servico servico, Funcionario funcionario){

        return new ServicoDAO().adicionar(servico, funcionario);
    }
    public boolean cancelar(int idServ) {

        return new ServicoDAO().cancelar(idServ);
    }
    public Funcionario buscarFuncionario(String func){
        return new FuncionarioDAO().buscarFuncionario(func);
    }
}
