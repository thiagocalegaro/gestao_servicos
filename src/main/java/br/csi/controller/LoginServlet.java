package br.csi.controller;
        import br.csi.service.LoginService;
        import jakarta.servlet.RequestDispatcher;
        import jakarta.servlet.ServletException;
        import jakarta.servlet.annotation.WebServlet;
        import jakarta.servlet.http.HttpServlet;
        import jakarta.servlet.http.HttpServletRequest;
        import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nome = req.getParameter("nome");
        String senha = req.getParameter("senha");


        if(new LoginService().logar(nome, senha)){

            RequestDispatcher rd =
                    req.getRequestDispatcher("WEB-INF/pages/dashbord.jsp");
            rd.forward(req, resp);

        }else{
            RequestDispatcher rd =
                    req.getRequestDispatcher("index.jsp");
            req.setAttribute("erro", "USUÁRIO OU SENHA INCORRETOS");
            rd.forward(req, resp);
        }

    }
}
