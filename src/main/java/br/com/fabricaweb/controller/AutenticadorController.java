package br.com.fabricaweb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fabricaweb.persistencia.entidade.Usuario;
import br.com.fabricaweb.persistencia.jdbc.UsuarioDAO;

@WebServlet("/autenticador.do")
public class AutenticadorController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sessao = req.getSession(false);
		if(sessao!=null){
			sessao.invalidate();
		}
		resp.sendRedirect("login.html");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		Usuario usu = new Usuario();
		usu.setLogin(login);
		usu.setSenha(senha);
		UsuarioDAO usuDao = new UsuarioDAO();
	    Usuario usuario = usuDao.Autenticar(usu);
	    if(usuario!=null){
	    HttpSession sessao=	req.getSession();
	    sessao.setAttribute("usuario", usuario);
	    sessao.setMaxInactiveInterval(3000);
	    req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp);;
	    }
	    resp.getWriter().print("<script> window.alert('Não Encontrado');location.href='login.html'</script>");
	}
}
