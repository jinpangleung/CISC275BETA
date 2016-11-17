package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.drawing.Coord;
import model.grid.gridcell.GridPosition;
import model.grid.griditem.GridItem;
import model.grid.griditem.trailitem.Pollutant;
import model.gui.touch.DefaultTouchObject;
import model.gui.touch.Touch;
import model.moving.Velocity;

public class TouchTest {

	Touch touch;
	
	@Before
	public void setup(){
		touch = Touch.getInstance();
	}
	
	@Test
	public void testGetNullObject() {
		assertEquals(DefaultTouchObject.class, touch.getNullObject().getClass());
	}
	
	@Test
	public void testSetNullObject() {
		GridItem item = new Pollutant(new Coord(4,4), null, new GridPosition(4,6), 
                new Velocity(1.5,1.5));
		touch.setNullObject(item);
		
		assertEquals(item, touch.getNullObject());
	}
	
	@Test
	public void testSetGetHolding() {
		GridItem item = new Pollutant(new Coord(4,4), null, new GridPosition(4,6), 
                new Velocity(1.5,1.5));
		touch.setHolding(item);
		
		assertEquals(item, touch.getHolding());
	}
	
	@Test
	public void testIsSetHolding() {
		assertEquals(false, touch.isHolding());
		touch.setHolding(true);
		assertEquals(true, touch.isHolding());
	}
	
	@Test
	public void testGetStartPosition(){
		assertEquals(0, touch.getStartPosition().getX(), 0);
		assertEquals(0, touch.getStartPosition().getY(), 0);
		
		GridItem item = new Pollutant(new Coord(5,2), null, new GridPosition(4,6), 
                new Velocity(1.5,1.5));
		
		assertEquals(item.getCoord().getX(), touch.getStartPosition().getX(), 0);
		assertEquals(item.getCoord().getY(), touch.getStartPosition().getY(), 0);
	}
	
	@Test
	public void testClamp() {
		GridItem item = new Pollutant(new Coord(4,4), null, new GridPosition(4,6), 
                new Velocity(1.5,1.5));
		touch.clamp(item);
		
		GridItem held = (GridItem) touch.getHolding();
		
		assertEquals(item, held);
		assertEquals(item.getCoord().getX(), touch.getStartPosition().getX(), 0);
		assertEquals(item.getCoord().getY(), touch.getStartPosition().getY(), 0);
		assertEquals(true, touch.isHolding());
	}
	
	@Test
	public void testUnClamp(){
		GridItem item = new Pollutant(new Coord(4,4), null, new GridPosition(4,6), 
                new Velocity(1.5,1.5));
		touch.clamp(item);
		GridItem unclamped = touch.unClamp();
		
		assertEquals(item, unclamped);
		assertEquals(DefaultTouchObject.class, touch.getNullObject().getClass());
		assertEquals(false, touch.isHolding());
	}
	
	@Test
	public void testMouseDragged() {
		GridItem item = new Pollutant(new Coord(4,4), null, new GridPosition(4,6), 
                new Velocity(1.5,1.5));
		touch.clamp(item);
		touch.mouseDragged(15, 20);
		
		assertEquals(15, touch.getHolding().getCoord().getX(), 0);
		assertEquals(20, touch.getHolding().getCoord().getY(), 0);
	}
	
}
