package br.com.fabricaweb.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fabricaweb.persistencia.entidade.Usuario;

public class UsuarioDAO {
	private Connection con = ConexaoFactory.getConnection();
	public void cadastrar(Usuario usu) {
		String sql = "insert into usuario(nome,login,senha)values(?,?,md5(?))";
		try (PreparedStatement preparador=con.prepareStatement(sql)){;
		 preparador.setString(1, usu.getNome());
		 preparador.setString(2, usu.getLogin());
		 preparador.setString(3, usu.getSenha());
		 
		 preparador.execute();
		// preparador.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void alterar(Usuario usu) {
		String sql = "update usuario set nome=?, login=?, senha=md5(?) where id=? ";
		try (PreparedStatement preparador=con.prepareStatement(sql)){;
		 preparador.setString(1, usu.getNome());
		 preparador.setString(2, usu.getLogin());
		 preparador.setString(3, usu.getSenha());
		 preparador.setInt(4, usu.getId());
		 
		 preparador.execute();
		// preparador.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void excluir(Usuario usu) {
		String sql = "delete from usuario where id=? ";
		try (PreparedStatement preparador=con.prepareStatement(sql)){;
		 preparador.setInt(1, usu.getId());
		 
		 preparador.execute();
		// preparador.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void salvar(Usuario usuario){
	
		if(usuario.getId()!=null && usuario.getId()!=0){
			alterar(usuario);
		}
		else{
			cadastrar(usuario);
		}
	}
	/**
	 * Buscar um registro no banco de dados pelo número do id do usuario
	 * @param id É um inteiro que representa o número do id do usuário
	 * @return Um Objeto Usuario quando encontra ou Null quando não encontra o objeto Usuario
	 */
	public Usuario buscaPorId(Integer id){
		String sql = "select * from usuario where id=?";
		try (PreparedStatement preparador = con.prepareStatement(sql)){;
		preparador.setInt(1, id);
		ResultSet resultado = preparador.executeQuery();
		if(resultado.next()){
			Usuario usuario = new Usuario();
			usuario.setId(resultado.getInt("id"));
			usuario.setNome(resultado.getString("nome"));
			usuario.setLogin(resultado.getString("login"));
			usuario.setSenha(resultado.getString("senha"));
			return usuario;
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	/**
	 * Realiza a busca de todos registros da tabela usuarios
	 * @return Uma lista de objetos Usuario contendo 0 elementos quando não tiver registros ou n elementos quando tiver registros
	 */
	public List<Usuario> buscarTodos(){
		String sql = "select * from usuario order by id";
		List<Usuario> lista = new ArrayList<Usuario>();
		try (PreparedStatement preparador = con.prepareStatement(sql)){;
		ResultSet resultado = preparador.executeQuery();
		while(resultado.next()){
			Usuario usu = new Usuario();
			usu.setId(resultado.getInt("id"));
			usu.setNome(resultado.getString("nome"));
			usu.setLogin(resultado.getString("login"));
			usu.setSenha(resultado.getString("senha"));
			lista.add(usu);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
		
	}
		public Usuario Autenticar(Usuario usuario){
			String sql = "select * from usuario where login=? and senha=md5(?)";
			try (PreparedStatement preparador = con.prepareStatement(sql)){;
			preparador.setString(1, usuario.getLogin());
			preparador.setString(2, usuario.getSenha());
			ResultSet resultado = preparador.executeQuery();
			if(resultado.next()){
				Usuario usuFound = new Usuario();
				usuFound.setId(resultado.getInt("id"));
				usuFound.setNome(resultado.getString("nome"));
				usuFound.setLogin(resultado.getString("login"));
				usuFound.setSenha(resultado.getString("senha"));
				return usuFound;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	}

	

