package Element;

import static org.junit.Assert.*;

import java.awt.Image;

import javax.swing.ImageIcon;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GroundTest {

	Ground ground;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		this.ground=new Ground();

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGround() {

		final Image exp_image =new ImageIcon("sprites/ground.png").getImage();
		assertEquals(exp_image, ground.getImage());
	}

	@Test
	public void testGroundIntInt() {

		assertNotNull(ground.x);
		assertNotNull(ground.y);
	}

}
