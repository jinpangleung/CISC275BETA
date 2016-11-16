package tests;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import model.gui.component.Component;
import model.gui.component.ComponentPosition;
import model.gui.component.DefaultComponent;

public class ComponentTest {

	Component c;
	
	@Before
	public void setup(){
		c = new DefaultComponent(50,50,100,100);
	}
	
	@Test
	public void testGetTopLeft(){
		assertEquals(50, c.getTopLeft().getX());
		assertEquals(50, c.getTopLeft().getY());
	}
	
	@Test
	public void testSetTopLeft(){
		ComponentPosition p = new ComponentPosition(10,10);
		c.setTopLeft(p);
		assertEquals(10,c.getTopLeft().getX());
		assertEquals(10,c.getTopLeft().getY());
	}
	
	@Test
	public void testGetBottomRight(){
		assertEquals(149, c.getBottomRight().getX());
		assertEquals(149, c.getBottomRight().getY());
	}
	
	@Test
	public void testSetBottomRight(){
		ComponentPosition p = new ComponentPosition(9,9);
		c.setBottomRight(p);
		assertEquals(9,c.getBottomRight().getX());
		assertEquals(9,c.getBottomRight().getY());
	}
	
	@Test
	public void testIsWithin(){
		assertEquals(true, c.isWithin(50, 50));
		assertEquals(true, c.isWithin(149, 149));
		assertEquals(true, c.isWithin(50, 149));
		assertEquals(true, c.isWithin(149, 50));
		assertEquals(true, c.isWithin(70, 70));
		assertEquals(true, c.isWithin(55, 130));
		assertEquals(true, c.isWithin(115, 51));
		assertEquals(false, c.isWithin(49, 49));
		assertEquals(false, c.isWithin(150, 150));
		assertEquals(false, c.isWithin(49, 150));
		assertEquals(false, c.isWithin(150, 49));
		assertEquals(false, c.isWithin(0, 0));
		assertEquals(false, c.isWithin(115, 300));
		assertEquals(false, c.isWithin(175, 58));
	}

}
