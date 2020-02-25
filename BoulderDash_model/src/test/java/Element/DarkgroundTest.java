package Element;

import static org.junit.Assert.*;

import java.awt.Image;

import javax.swing.ImageIcon;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DarkgroundTest {

	Darkground darkground;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.darkground=new Darkground();

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDarkground() {
		final Image exp_image =new ImageIcon("sprites/darkground.png").getImage();

		assertEquals(exp_image, darkground.getImage());
		//fail("Not yet implemented");
	}

	@Test
	public void testDarkgroundIntInt() {
		assertNotNull(darkground.getX());
		assertNotNull(darkground.getY());
		
		
	}

}
