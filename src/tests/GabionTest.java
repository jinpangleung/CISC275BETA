package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.drawing.Animation;
import model.drawing.Coord;
import model.grid.gridcell.GridPosition;
import model.grid.griditem.gabion.ConcreteGabion;
import model.grid.griditem.gabion.Gabion;
import model.grid.griditem.gabion.OysterGabion;

public class GabionTest
{
    Gabion oystGab;
    Gabion concGab;

    @Before
    public void setup(){
        oystGab = new OysterGabion(new Coord(1.5,3.5), null, new GridPosition(2,3));
        concGab = new ConcreteGabion(new Coord(4.23,3.45), null, new GridPosition(5,6));
    }
    
    @Test
    public void testGetHealth(){
        assertEquals(100, oystGab.getHealth());
        assertEquals(100, concGab.getHealth());
    }
    
    @Test
    public void testSetHealth(){
        oystGab.setHealth(90);
        concGab.setHealth(80);
        assertEquals(90, oystGab.getHealth());
        assertEquals(80, concGab.getHealth());
    }
    
    @Test
    public void testTakeDamage(){
        oystGab.takeDamage();
        concGab.takeDamage();
        assertEquals(90, oystGab.getHealth());
        assertEquals(80, concGab.getHealth());
    }
}
