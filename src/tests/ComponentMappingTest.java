package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.gui.component.ComponentMapping;
import model.gui.component.DefaultComponent;

public class ComponentMappingTest {

	ComponentMapping compMap;
	DefaultComponent bottomComp;
	DefaultComponent topCompLeft;
	DefaultComponent topCompRight;
	
	@Before @Test
	public void setup() {
		bottomComp = new DefaultComponent(0,0,100,100);
		//Padding of 10 on every side
		topCompLeft = new DefaultComponent(0,0,40,100);
		topCompRight = new DefaultComponent(60,0,40,100);
		
		compMap = new ComponentMapping(bottomComp, 100, 100);
	}
	
	@Test
	public void testAddComponent() {
		boolean b1 = compMap.addComponent(bottomComp);
		boolean b2 = compMap.addComponent(topCompLeft);
		boolean b3 = compMap.addComponent(topCompRight);
		
		assertEquals(false, b1);
		assertEquals(true, b2);
		assertEquals(true, b3);
	}
	
	@Test
	public void testGetComponent() {
		compMap.addComponent(bottomComp);
		compMap.addComponent(topCompLeft);
		compMap.addComponent(topCompRight);
		
		assertEquals(bottomComp, compMap.getComponent(40, 0));
		assertEquals(bottomComp, compMap.getComponent(40, 99));
		assertEquals(bottomComp, compMap.getComponent(59, 0));
		assertEquals(bottomComp, compMap.getComponent(59, 99));
		assertEquals(bottomComp, compMap.getComponent(45, 0));
		assertEquals(bottomComp, compMap.getComponent(45, 50));
		assertEquals(bottomComp, compMap.getComponent(45, 99));
		
		assertEquals(topCompLeft, compMap.getComponent(0, 0));
		assertEquals(topCompLeft, compMap.getComponent(39, 0));
		assertEquals(topCompLeft, compMap.getComponent(0, 99));
		assertEquals(topCompLeft, compMap.getComponent(39, 99));
		assertEquals(topCompLeft, compMap.getComponent(20, 0));
		assertEquals(topCompLeft, compMap.getComponent(20, 50));
		assertEquals(topCompLeft, compMap.getComponent(20, 99));
		
		assertEquals(topCompRight, compMap.getComponent(60, 0));
		assertEquals(topCompRight, compMap.getComponent(99, 0));
		assertEquals(topCompRight, compMap.getComponent(60, 99));
		assertEquals(topCompRight, compMap.getComponent(99, 99));
		assertEquals(topCompRight, compMap.getComponent(80, 0));
		assertEquals(topCompRight, compMap.getComponent(80, 50));
		assertEquals(topCompRight, compMap.getComponent(80, 99));
	}

}
