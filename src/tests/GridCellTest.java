package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.grid.gridcell.Direction;
import model.grid.gridcell.GridCell;
import model.grid.gridcell.GridPosition;

public class GridCellTest
{
    GridCell cell;
    
    @Before
    public void setup(){
        cell = new GridCell(new GridPosition(1, 2), true, Direction.EAST);
    }

    @Test
    public void testGetDirection()
    {
        assertEquals(Direction.EAST, cell.getDirection());
    }
    
    @Test
    public void testSetDirection()
    {
        cell.setDirection(Direction.WEST);
        assertEquals(Direction.WEST, cell.getDirection());
    }
    
    @Test
    public void testGetGridPosition()
    {
        assertEquals(1, cell.getGridPosition().getX());
        assertEquals(2, cell.getGridPosition().getY());
    }
    
    @Test
    public void testGetSridPosition()
    {
        GridPosition g = new GridPosition(5, 3);
        cell.setGridPosition(g);
        assertEquals(5, cell.getGridPosition().getX());
        assertEquals(3, cell.getGridPosition().getY());
    }
    
    @Test
    public void testIsTrail()
    {
        assertEquals(true, cell.isTrail());
    }
    
    @Test
    public void testSetTrail()
    {
        cell.setTrail(false);
        assertEquals(false, cell.isTrail());
    }
}
