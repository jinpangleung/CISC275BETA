package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.drawing.Coord;
import model.grid.GridColor;
import model.grid.gridcell.GridPosition;
import model.grid.griditem.GridItem;
import model.grid.griditem.trailitem.Pollutant;
import model.moving.Velocity;

public class GridItemTest
{
    GridItem item;
    
    @Before
    public void setup(){
        item = new Pollutant(new Coord(4,4), null, new GridPosition(4,6), 
                new Velocity(1.5,1.5));
    }
    
    @Test
    public void testGetGridPosition()
    {
        assertEquals(4, item.getGridPosition().getX());
        assertEquals(6, item.getGridPosition().getY());
    }
    
    @Test
    public void testSetGridPosition()
    {
        item.setGridPosition(new GridPosition(2,3));
        
        assertEquals(2, item.getGridPosition().getX());
        assertEquals(3, item.getGridPosition().getY());
    }

    @Test
    public void testGetGridColor()
    {
        assertEquals(GridColor.RED, item.getGridColor());
    }
    
    @Test
    public void testSetGridColor()
    {
        item.setGridColor(GridColor.BLUE);
        assertEquals(GridColor.BLUE, item.getGridColor());
    }
    
    @Test
    public void testUpdate(){
        //TODO implement this test
    }
}
