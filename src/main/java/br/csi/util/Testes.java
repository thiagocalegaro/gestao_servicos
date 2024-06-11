package br.csi.util;

import br.csi.dao.FuncionarioDAO;
import br.csi.dao.ServicoDAO;
import br.csi.dao.UsuarioDAO;
import br.csi.model.Funcionario;
import br.csi.model.Servico;
import br.csi.model.Usuario;
import br.csi.service.FuncionarioService;
import br.csi.service.ServicoService;

import java.util.ArrayList;

public class Testes {

    public static void testeCadastro(){
        Usuario u = new Usuario( 1, "thiago", "1234");
        new UsuarioDAO().cadastrar(u);
    }
    /*public static void testeCadastroServ(){
        Funcionario u = new Funcionario( 30, "amigo", 500);
        new FuncionarioDAO().cadastrar(u);
        Servico s = new Servico(50, "teste10", "local",200,u);
        new ServicoDAO().adicionar(s, u);
    }*/
    public static void testeExcluiFunc(){

        boolean demitir = new FuncionarioService().demitir(3);
    }

    public static void testeExcluiServ(){

        boolean cancelar = new ServicoService().cancelar(2);
    }
    public static void main(String[] args) {

        //testeCadastro();
        //testeCadastroServ();
        System.out.println("Usuários\n");
        UsuarioDAO dao = new UsuarioDAO();
        ArrayList<Usuario> usuarios = dao.getUsuarios();
        FuncionarioDAO dao1 = new FuncionarioDAO();
        ArrayList<Funcionario> funcionarios = dao1.getFuncionario();
        ServicoDAO dao2 = new ServicoDAO();
        ArrayList<Servico> servicos = dao2.getServico();
        //testeExcluiFunc();
        //testeExcluiServ();

        /*for(Usuario u : usuarios){
            System.out.println("ID: " + u.getIdUser()
                    + "\nNOME: " + u.getNome()
                    + "\nSENHA: " + u.getSenha());
        }
        System.out.println("Funcionários");
        for (Funcionario f : funcionarios) {
            System.out.println("ID: " + f.getIdFunc()
                    + "\nNOME: " + f.getNome()
                    + "\nSENHA: " + f.getSalario());
        }*/
        System.out.println("Servicos\n");
        for (Servico s : servicos) {
            System.out.println("ID: " + s.getIdServ()
                    + "\nNOME: " + s.getNome()
                    + "\nLOCAL: " + s.getLocal()
                    + "\nVALOR:" + s.getValor()
                    + "\nFUNC:" + s.getFuncionario().getNome());

        }


    }
}
