package Element;

import static org.junit.Assert.*;

import java.awt.Image;

import javax.swing.ImageIcon;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class WallTest {

	Wall wall;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.wall=new Wall();

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testWall() {

		final Image exp_image =new ImageIcon("sprites/wall.png").getImage();
		assertEquals(exp_image, wall.getImage());
	}

	@Test
	public void testWallIntInt() {

		assertNotNull(wall.x);
		assertNotNull(wall.y);
	}

}
