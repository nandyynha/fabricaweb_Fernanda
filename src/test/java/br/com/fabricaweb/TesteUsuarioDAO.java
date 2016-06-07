package br.com.fabricaweb;

import java.util.List;

import br.com.fabricaweb.persistencia.entidade.Usuario;
import br.com.fabricaweb.persistencia.jdbc.UsuarioDAO;

public class TesteUsuarioDAO {

	public static void main(String[] args) {
	// testAlterar();	
	//	testExcluir();
		//testSalvar();
		testBuscarTodos();
		//testAutenticar();
	}
	public static void testCadastrar(){
		// Criando um usuario
		Usuario usu = new Usuario();
		usu.setNome("Jãozão");
		usu.setLogin("123");
		usu.setSenha("123");
		//Cadastrando o usuario no banco
		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.cadastrar(usu);
		System.out.println("Cadastrado com sucesso!");
	}
	public static void testAlterar(){
		// Criando um usuario
		Usuario usu = new Usuario();
		usu.setId(5);
		usu.setNome("Jão");
		usu.setLogin("jaozao");
		usu.setSenha("1234");
		//Alterando o usuario no banco
		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.alterar(usu);
		System.out.println("Alterado com sucesso!");
	}

	public static void testExcluir(){
		// Criando um usuario
		Usuario usu = new Usuario();
		usu.setId(5);
		//Excluir o usuario no banco
		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.excluir(usu);
		System.out.println("Excluído com sucesso!");
	}

	public static void testSalvar(){
		Usuario usu = new Usuario();
		//usu.setId(2);
		usu.setNome("Ronald");
		usu.setLogin("ronald@gmail");
		usu.setSenha("123");
		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.salvar(usu);
		System.out.println("Salvo com sucesso!");
	}
	public static void testBuscarPorId(){
		UsuarioDAO usuDao = new UsuarioDAO();
		Usuario usuario = usuDao.buscaPorId(1);
		System.out.println(usuario);
	}
	public static void testBuscarTodos(){
		UsuarioDAO usuDao = new UsuarioDAO();
		List<Usuario> lista = usuDao.buscarTodos();
		for (Usuario usuario : lista) {
		System.out.println(usuario);
	}

	}
	public static void testAutenticar(){
		UsuarioDAO usuDao = new UsuarioDAO();
		Usuario usuario = new Usuario();
		usuario.setLogin("jão");
		usuario.setSenha("123");
		Usuario usu = usuDao.Autenticar(usuario);
		System.out.println(usu);
	}
	
}
