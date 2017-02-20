package gimblog.tests.database;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import br.com.gim.blog.dao.UsuarioDAO;
import br.com.gim.blog.model.builder.ArtigoBuilder;
import br.com.gim.blog.model.entity.Artigo;
import br.com.gim.blog.model.entity.Usuario;

public class UsuarioTests {

	UsuarioDAO usuarioDao;
	
	@Before
	public void iniciaDaos(){
		usuarioDao = new UsuarioDAO();
	}
	
	@Test
	public void InsereUmUsuario() {
		
		int quantidadeAntesAdd = usuarioDao.lista().size();	
		insereUsuarioComDoisArtigos();	
		int quantidadeDepoisAdd = usuarioDao.lista().size();

		assertEquals((quantidadeAntesAdd+1),quantidadeDepoisAdd);
		
	
	}
	
	
	@Test
	public void InsereUmUsuarioDepoisRemove() {
		
		int quantidadeAntesAdd = usuarioDao.lista().size();	
		insereUsuarioComDoisArtigos();	
		int quantidadeDepoisAdd = usuarioDao.lista().size();
		removePrimeiroUsuario();
		int quantidadeDepoisRemove = usuarioDao.lista().size();
		
		assertEquals((quantidadeAntesAdd+1),quantidadeDepoisAdd);
		
		assertEquals((quantidadeAntesAdd),quantidadeDepoisRemove);
		
	
	}


	private void insereUsuarioComDoisArtigos() {
		
		Usuario usuario = new Usuario();
		usuario.setEmail("joao@email.com");
		usuario.setSenha("123");
		usuario.setUsername("joao123");
		
		
		Artigo artigo1 = new ArtigoBuilder()
							.comTitulo("Java 8")
							.comTexto("Novas ferramentas do Java")
							.naDataPublicacaoo(Calendar.getInstance())
							.isPublico(true)
							.build();
		
		Artigo artigo2 = new ArtigoBuilder()
				.comTitulo("Design Patterns")
				.comTexto("O legado da GoF")
				.naDataPublicacaoo(Calendar.getInstance())
				.isPublico(false)
				.build();

		usuario.addArtigo(artigo1);
		usuario.addArtigo(artigo2);
		
	
		
		
		usuarioDao.salvar(usuario);
	}
	
	private Usuario primeiroUsuario(){
		return usuarioDao.lista().get(0);
	}
	
	
	private void removePrimeiroUsuario(){
	
		Usuario usuario = primeiroUsuario();
		
		usuarioDao.remove(usuario);
	
	}
	
	
	
//	@Test
//	public void RemoveUmArtigo() {
//		int quantidadeAntesRemove = artigoDao.lista().size();
//	
//		
//		
//		int quantidadeDepoisRemove = artigoDao.lista().size();
//		
//		
//		
//		assertEquals((quantidadeAntesRemove-1),quantidadeDepoisRemove);
//	}
	
	
	

}
