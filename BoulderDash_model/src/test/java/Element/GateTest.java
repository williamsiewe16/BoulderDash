package Element;

import static org.junit.Assert.*;

import java.awt.Image;

import javax.swing.ImageIcon;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GateTest {

	Gate gate;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.gate=new Gate();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGate() {
		
		final Image exp_image =new ImageIcon("sprites/gate1.png").getImage();
		assertEquals(exp_image, gate.getImage());
	}

}
