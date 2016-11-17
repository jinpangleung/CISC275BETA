package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.drawing.Coord;
import model.grid.gridcell.GridPosition;
import model.grid.griditem.GridItem;
import model.grid.griditem.towers.BlueTower;
import model.grid.griditem.towers.RedTower;
import model.grid.griditem.towers.Tower;
import model.grid.griditem.trailitem.Pollutant;
import model.moving.Velocity;

public class TowerTest
{

    Tower btower;
    Tower rtower;
    
    @Before
    public void setup(){
        btower = new BlueTower(new Coord(10, 10));
        rtower = new RedTower(new Coord(5,5));
    }
    
    @Test
    public void testGetCooldownRemaining()
    {
        assertEquals(10, btower.getCooldownRemaining());
    }
    
    @Test
    public void testSetCooldownRemaining()
    {
        btower.setCooldownRemaining(5);
        assertEquals(5, btower.getCooldownRemaining());
    }

    @Test
    public void testGetRange()
    {
        assertEquals(10, btower.getRange());
    }
    
    @Test
    public void testIsInRange()
    {
        Coord c1 = new Coord(10,10);
        Coord c2 = new Coord(9, 9);
        Coord c3 = new Coord(5, 10);
        Coord c4 = new Coord(1, 10);
        Coord c5 = new Coord(10, 5);
        Coord c6 = new Coord(10, 1);
        Coord c7 = new Coord(10,19);
        Coord c8 = new Coord(19,10);
        Coord c9 = new Coord(0, 10);
        Coord c10 = new Coord(10, 0);
        Coord c11 = new Coord(10, 20);
        Coord c12 = new Coord(20, 10);
        
        Coord c13 = new Coord(20,20);
        Coord c14 = new Coord(0,20);
        Coord c15 = new Coord(20,0);
        Coord c16 = new Coord(0,0);
        
        assertEquals(true, btower.isInRange(c1));
        assertEquals(true, btower.isInRange(c2));
        assertEquals(true, btower.isInRange(c3));
        assertEquals(true, btower.isInRange(c4));
        assertEquals(true, btower.isInRange(c5));
        assertEquals(true, btower.isInRange(c6));
        assertEquals(true, btower.isInRange(c8));
        assertEquals(true, btower.isInRange(c9));
        assertEquals(true, btower.isInRange(c10));
        assertEquals(true, btower.isInRange(c11));
        assertEquals(true, btower.isInRange(c12));
        
        assertEquals(false, btower.isInRange(c13));
        assertEquals(false, btower.isInRange(c14));
        assertEquals(false, btower.isInRange(c15));
        assertEquals(false, btower.isInRange(c16));
    }
    
    @Test
    public void testReact(){
        //TODO add oyster case
        GridItem redItem = new Pollutant(new Coord(4,4), null, new GridPosition(4,4), 
                new Velocity(1.5,1.5));
        
        //TODO drag red item to red tower case
        rtower.react(redItem, rtower.getGridColor());
        // assert equals estuary happiness when implemented
        //TODO drag red item to blue tower case
        btower.react(redItem, btower.getGridColor());
        // assert equals estuary happiness when implemented
    }
    
    @Test
    public void testUpdate(){
        btower.update(2);
        assertEquals(8, btower.getCooldownRemaining());
        
        btower.setCooldownRemaining(-3);
        btower.update(876);
        assertEquals(-3, btower.getCooldownRemaining());        
    }
}
