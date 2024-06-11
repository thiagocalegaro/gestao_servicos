package br.csi.controller;
import br.csi.dao.UsuarioDAO;
import br.csi.model.Usuario;
import br.csi.service.UsuarioService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/usuario")
public class  UsuarioServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idUser = req.getIntHeader("iduser");
        String nome = req.getParameter("nome");
        String senha = req.getParameter("senha");
        Usuario usuario = new Usuario(idUser, nome, senha);

        if (new UsuarioService().cadastrar(usuario)) {
            RequestDispatcher rd =
                    req.getRequestDispatcher("index.jsp");
            rd.forward(req, resp);
        } else {
            RequestDispatcher rd =
                    req.getRequestDispatcher("cadastrar.jsp");
            req.setAttribute("erro", "FALHA AO CADASTRAR USUÁRIO");
            rd.forward(req, resp);
        }
    }
}
