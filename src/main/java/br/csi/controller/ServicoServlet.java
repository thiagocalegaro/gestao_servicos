package br.csi.controller;
import br.csi.dao.FuncionarioDAO;
import br.csi.dao.ServicoDAO;
import br.csi.model.Funcionario;
import br.csi.model.Servico;
import br.csi.service.FuncionarioService;
import br.csi.service.ServicoService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet("/servico")
public class  ServicoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idServ = req.getIntHeader("idserv");
        String nome = req.getParameter("nomeserv");
        String local = req.getParameter("local");
        String func = req.getParameter("func");
        /*Date data = null;
        try {
            data = new SimpleDateFormat("yyyy/MM/dd").parse(req.getParameter("data"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }*/

        float valor = Float.parseFloat(req.getParameter("valor"));

        Funcionario funcionario = new ServicoService().buscarFuncionario(func);
        Servico servico = new Servico(idServ, nome, local, /*data,*/ valor, funcionario);

        if (funcionario != null && new ServicoService().adicionar(servico, funcionario)) {
            servico.setFuncionario(funcionario);
            RequestDispatcher rd =
                    req.getRequestDispatcher("WEB-INF/pages/dashbord.jsp");
            rd.forward(req, resp);
        }else {
                RequestDispatcher rd =
                        req.getRequestDispatcher("WEB-INF/pages/dashbord.jsp");
                req.setAttribute("retorno", "FALHA AO CADASTRAR SERVIÇO");
                rd.forward(req, resp);
            }
        }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String opcao = req.getParameter("opcao");
        if (opcao != null) {

            int idServ = Integer.parseInt(req.getParameter("idserv"));

            if (opcao.equals("excluir")) {

                if(new ServicoService().cancelar(idServ)) {
                    req.setAttribute("retorno", "SERVIÇO CANCELADO com SUCESSO");
                }else {
                    req.setAttribute("retorno", "ERRO AO CANCELAR SERVIÇO");
                }

            } else if (opcao.equals("editar")) {
                //if (new ServicoDAO().editar())
                Servico servico = new Servico();
                req.setAttribute("servioc", servico);
                Funcionario funcionario = new Funcionario();
                funcionario.setIdFunc(18);
                funcionario.setNome("amigo");
            }
        }

        RequestDispatcher rd =
                req.getRequestDispatcher("WEB-INF/pages/dashbord.jsp");
        rd.forward(req, resp);
    }
}