package Element;

import static org.junit.Assert.*;

import java.awt.Image;

import javax.swing.ImageIcon;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RockTest {

	Rock rock;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	
		this.rock=new Rock();

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRock() {
		final Image exp_image =new ImageIcon("sprites/rock.png").getImage();
		assertEquals(exp_image, rock.getImage());
	}

	@Test
	public void testRockIntInt() {
		
		assertNotNull(rock.x);
		assertNotNull(rock.y);
	}

	@Test
	public void testFixBooleans() {

	}

	

}
