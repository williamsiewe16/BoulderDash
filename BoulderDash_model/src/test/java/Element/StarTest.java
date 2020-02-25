package Element;

import static org.junit.Assert.*;

import java.awt.Image;

import javax.swing.ImageIcon;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StarTest {
	
	Star star;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		this.star = new Star();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testStar() {
		
		final Image exp_image =new ImageIcon("sprites/upstar.png").getImage();

		assertEquals(exp_image, star.getImage());
	}

}
