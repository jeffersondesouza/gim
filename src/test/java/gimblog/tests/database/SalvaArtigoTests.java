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

public class SalvaArtigoTests {

	ArtigoDAO artigoDao;
	
	@Before
	public void iniciaDaos(){
		artigoDao = new ArtigoDAO();
	}
	
	@Test
	public void InsereUmArtigoDepoisRemove() {
		int quantidadeAntesAdd = artigoDao.lista().size();	
		insereArtigo();		
		int quantidadeDepoisAdd = artigoDao.lista().size();
		removePrimeiroArtigo();
		int quantidadeDepoisRemove = artigoDao.lista().size();

		
		
		assertEquals((quantidadeAntesAdd+1),quantidadeDepoisAdd);
		
		assertEquals((quantidadeAntesAdd),quantidadeDepoisRemove);
		
	
	}

	private void insereArtigo() {
		Artigo artigo = new ArtigoBuilder()
							.comTitulo("")
							.comTexto("")
							.naDataPublicacaoo(Calendar.getInstance())
							.isPublico(true)
							.build();
		
		artigoDao.salvar(artigo);
	}
	
	private Artigo primeiroArtigo(){
		return artigoDao.lista().get(0);
	}
	
	
	private void removePrimeiroArtigo(){
	
		Artigo artigo = primeiroArtigo();
		
		artigoDao.remove(artigo);
	
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
