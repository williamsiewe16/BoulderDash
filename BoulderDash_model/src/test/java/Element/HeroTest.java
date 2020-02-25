package Element;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Model;

public class HeroTest {

	Hero hero;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		this.hero=new Hero();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetX() {

		//assertNotNull(hero.setX(getX()!=0));
	}

	@Test
	public void testSetY() {
	}

	@Test
	public void testHero() {
	}

	@Test
	public void testHeroIntInt() {
	}

	@Test
	public void testDig() {

		assertNull(Model.scene);
	}

	@Test
	public void testIsFreeze() {
	}

	@Test
	public void testSetFreeze() {
	}

}
