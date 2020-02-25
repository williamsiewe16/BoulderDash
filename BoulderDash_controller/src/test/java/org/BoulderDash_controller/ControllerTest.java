package org.BoulderDash_controller;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import contract.IModel;
import controller.Controller;

public class ControllerTest {

	Controller controller;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		//this.controller=new Controller(new Model());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testStart() {

		//assertTrue(controller.start());
}

	@Test
	public void testSetPos_diamond() {

	//	assertTrue(controller.pos_diamond>3);
	}


	@Test
	public void testGetModel() {
		
		final IModel exp_model = controller.getModel();
		assertEquals(exp_model, this.controller.getModel());
	}

}
