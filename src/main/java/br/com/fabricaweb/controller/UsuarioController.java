package br.com.fabricaweb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabricaweb.persistencia.entidade.Usuario;
import br.com.fabricaweb.persistencia.jdbc.UsuarioDAO;
//http://localhost:8080/fabricadeWeb/usucontroller.do

@WebServlet("/usucontroller.do")
public class UsuarioController extends HttpServlet{


	public UsuarioController(){
		super();
		System.out.println("Construtor");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("Chamou o init");
		super.init();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("Chamou o get: "+req);
	String acao = req.getParameter("acao");
	if(acao.equals("esc")){
	String id = req.getParameter("id");
	Usuario usu = new Usuario();
		if(usu!=null)
			usu.setId(Integer.parseInt(id));
		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.excluir(usu);
		resp.sendRedirect("usucontroller.do?acao=lis");
	}
	else
		if(acao.equals("lis")){
			UsuarioDAO usuDao = new UsuarioDAO();
			List<Usuario>lista=usuDao.buscarTodos();
//			for (Usuario usuario : lista) {
//			resp.getWriter().println(usuario);	
//			}
			req.setAttribute("lista", lista);
			RequestDispatcher viagemParaJSP = req.getRequestDispatcher("WEB-INF/listausu.jsp");
			viagemParaJSP.forward(req, resp);
		}else if(acao.equals("alt")){
			String id = req.getParameter("id");
			UsuarioDAO usuDAO = new UsuarioDAO();
			Usuario usu = usuDAO.buscaPorId(Integer.parseInt(id));
			usu.setSenha("");
			req.setAttribute("usu", usu);
			RequestDispatcher levarUsuario = req.getRequestDispatcher("WEB-INF/frmusuario.jsp");
			levarUsuario.forward(req, resp);
		}else if(acao.equals("cad")){
			Usuario usu = new Usuario();
			usu.setId(0);
			usu.setNome("");
			usu.setLogin("");
			usu.setSenha("");
			req.setAttribute("usu", usu);
			RequestDispatcher levarUsuario = req.getRequestDispatcher("WEB-INF/frmusuario.jsp");
			levarUsuario.forward(req, resp);
		}
	
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Chamou o post: "+req);
		String id = req.getParameter("id");
		String nome = req.getParameter("nome");
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		
		Usuario usu =new Usuario();
	    if(id!=null)
		usu.setId(Integer.parseInt(id));
		usu.setNome(nome);
		usu.setLogin(login);
		usu.setSenha(senha);
		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.salvar(usu);
		resp.sendRedirect("usucontroller.do?acao=lis");
		
		
	}
	@Override
	public void destroy() {
		System.out.println("Chamou o destroy");
		super.destroy();
	}
}
