package Element;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.awt.Image;

import javax.swing.ImageIcon;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DiamondTest {

	Diamond diamond;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.diamond=new Diamond();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDiamond() {
		
		assertNotNull(diamond.getState());
		//fail("Not yet implemented");
	}

	@Test
	public void testDiamondIntInt() {
		
		assertNotNull(diamond.x);
		assertNotNull(diamond.y);

		//fail("Not yet implemented");
	}

	@Test
	public void testGetState() {
		
		//assertNotNull(Diamond.getState());
	}

	@Test
	public void testSetState() {		
		final Image expected1 = new ImageIcon("sprites/diam1.png").getImage();
		final Image expected2 = new ImageIcon("sprites/diam2.png").getImage();
		final Image expected3 = new ImageIcon("sprites/diam3.png").getImage();
		final Image expected4 = new ImageIcon("sprites/diam4.png").getImage();

		
		assertEquals(expected1, diamondState.diam1.getImage());
		assertEquals(expected2, diamondState.diam2.getImage());
		assertEquals(expected3, diamondState.diam3.getImage());
		assertEquals(expected4, diamondState.diam4.getImage());

		//fail("Not yet implemented");
	}

}
