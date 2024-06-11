package br.csi.controller;
import br.csi.dao.FuncionarioDAO;
import br.csi.dao.UsuarioDAO;
import br.csi.model.Funcionario;
import br.csi.model.Usuario;
import br.csi.service.FuncionarioService;
import br.csi.service.LoginService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/funcionario")
public class  FuncionarioServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idFunc = req.getIntHeader("idfunc");
        String nome = req.getParameter("nome");
        float salario = Float.parseFloat(req.getParameter("salario"));
        Funcionario funcionario = new Funcionario(idFunc, nome, salario);

        if (new FuncionarioService().cadastrar(funcionario)) {
            RequestDispatcher rd =
                    req.getRequestDispatcher("WEB-INF/pages/dashbord.jsp");
            rd.forward(req, resp);
        } else {
            RequestDispatcher rd =
                    req.getRequestDispatcher("WEB-INF/pages/dashbord.jsp");
            req.setAttribute("retorno", "FALHA AO CADASTRAR FUNCIONÁRIO");
            rd.forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println("opção: " + req.getParameter("opcao"));

        String opcao = req.getParameter("opcao");
        if (opcao != null) {

            if (opcao.equals("excluir")) {

                int idFunc = Integer.parseInt(req.getParameter("idfunc"));

                if(new FuncionarioService().demitir(idFunc)) {
                    req.setAttribute("retorno", "FUNCIONÁRIO EXCLUÍDO com SUCESSO");
                }else {
                    req.setAttribute("retorno", "ERRO AO DELETAR/DEMITIR FUNCIONÁRIO");
                }

            } else if (opcao.equals("editar")) {
                //implementar editar
            }
        }
        RequestDispatcher rd =
                req.getRequestDispatcher("WEB-INF/pages/dashbord.jsp");
        rd.forward(req, resp);
    }
}