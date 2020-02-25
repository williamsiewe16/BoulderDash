package Element;

import static org.junit.Assert.*;

import java.awt.Image;

import javax.swing.ImageIcon;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MonsterTest {

	Monster monster;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		this.monster=new Monster();

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMonster() {
		

		final Image exp_image =new ImageIcon("sprites/monster.png").getImage();
		assertEquals(exp_image, monster.getImage());
	}

	@Test
	public void testMonsterIntInt() {

		assertNotNull(monster.x);
		assertNotNull(monster.y);
	}

}
