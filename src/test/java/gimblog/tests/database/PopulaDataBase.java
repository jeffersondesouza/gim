package gimblog.tests.database;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import br.com.gim.blog.dao.ArtigoDAO;
import br.com.gim.blog.dao.UsuarioDAO;
import br.com.gim.blog.model.builder.ArtigoBuilder;
import br.com.gim.blog.model.entity.Artigo;
import br.com.gim.blog.model.entity.Usuario;

public class PopulaDataBase {


	UsuarioDAO usuarioDao;
	ArtigoDAO artigoDao;
	
	@Before
	public void iniciaDaos(){
		usuarioDao = new UsuarioDAO();
		artigoDao = new ArtigoDAO();
		
		artigoDao.lista();
	}
	
	@Test
	public void InsereUmUsuario() {
		
		int quantidadeAntesAdd = usuarioDao.lista().size();	
		insereUsuarioComDoisArtigos();	
		int quantidadeDepoisAdd = usuarioDao.lista().size();

		assertEquals((quantidadeAntesAdd+1),quantidadeDepoisAdd);
		
	
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
	


}
