package br.com.fabricaweb;

import br.com.fabricaweb.persistencia.entidade.Usuario;
import br.com.fabricaweb.persistencia.jdbc.UsuarioDAO;

public class TesteUsuarioDAO {

	public static void main(String[] args) {
	// testAlterar();	
		testExcluir();
	}
	public static void testCadastrar(){
		// Criando um usuario
		Usuario usu = new Usuario();
		usu.setNome("Jãozão");
		usu.setLogin("jzao");
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


}
