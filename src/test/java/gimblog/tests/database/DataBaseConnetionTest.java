package gimblog.tests.database;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import br.com.gim.blog.util.jpa.EntityManagerProducer;

public class DataBaseConnetionTest {

	@Test
	public void ConectandoDataBaseViaDriver() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/gimblog", "root", "duppoe");
	}

	@Test
	public void ConectandoDataBaseViaPersistenceUnit() throws SQLException {
		EntityManager manager = new EntityManagerProducer().getEntityManager();
	}

}
