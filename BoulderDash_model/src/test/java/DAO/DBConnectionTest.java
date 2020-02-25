package DAO;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DBConnectionTest {

	DBConnection dbconnection;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.dbconnection = new DBConnection();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDBConnection() {
		
		
	}

	@Test
	public void testOpen() {
		
		assertNotNull(dbconnection.open());
	}

	@Test
	public void testGetConnection() {
		
		assertNull(dbconnection.getConnection());
	}

	@Test
	public void testGetStatement() {
		
		assertNull(dbconnection.getStatement());

	}


}
