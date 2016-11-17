package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.drawing.Coord;
import model.grid.gridcell.GridPosition;

public class GridPositionTest
{

    GridPosition g;
    
    @Before
    public void setup(){
        g = new GridPosition(1, 1);
    }
    
    @Test
    public void testGetX()
    {
        assertEquals(1, g.getX());
    }
    @Test
    public void testGetY()
    {
        assertEquals(1, g.getY());
    }
    @Test
    public void testSetX()
    {
        g.setX(5);
        assertEquals(5, g.getX());
     
    }
    @Test
    public void testSetY()
    {
        
        g.setY(5);
        assertEquals(5, g.getY());
    }

}
