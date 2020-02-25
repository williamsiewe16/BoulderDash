package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ModelTest {

	Model model;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		model = new Model();
		Model.setLag_T(3);
		Model.setLag_L(2);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetLag_L() {
		int expected = 2;
		assertEquals(expected,Model.getLag_L());
	}

	@Test
	public void testSetLag_L() {
		Model.setLag_L(4);
		assertEquals(4,Model.getLag_L());
	}

	@Test
	public void testGetLag_T() {
		int expected = 3;
		assertEquals(expected,Model.getLag_T());
	}

	@Test
	public void testSetLag_T() {
		Model.setLag_T(4);
		assertEquals(4,Model.getLag_T());
	}

}
