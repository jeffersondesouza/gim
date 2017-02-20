package gimblog.tests.database;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import br.com.gim.blog.dao.ArtigoDAO;
import br.com.gim.blog.model.builder.ArtigoBuilder;
import br.com.gim.blog.model.entity.Artigo;

public class PopulaDataBase {

	ArtigoDAO artigoDao;
	
	@Before
	public void iniciaDaos(){
		artigoDao = new ArtigoDAO();
	}
	
	@Test
	public void InsereUmArtigoDepoisRemove() {
		int quantidadeAntesAdd = artigoDao.lista().size();	
		
		Artigo a1 = new ArtigoBuilder()
				.comTitulo("")
				.comTexto("")
				.naDataPublicacaoo(Calendar.getInstance())
				.isPublico(true)
				.build();

		
		Artigo a2 = new ArtigoBuilder()
				.comTitulo("")
				.comTexto("")
				.naDataPublicacaoo(Calendar.getInstance())
				.isPublico(true)
				.build();

		
		Artigo a3 = new ArtigoBuilder()
				.comTitulo("")
				.comTexto("")
				.naDataPublicacaoo(Calendar.getInstance())
				.isPublico(true)
				.build();

		int quantidadeDepoisAdd = artigoDao.lista().size();	
		
		assertEquals((quantidadeAntesAdd+3),quantidadeDepoisAdd);
		
	
	}

	
	
	

}
