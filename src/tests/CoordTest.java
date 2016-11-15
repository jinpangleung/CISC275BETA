package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.drawing.Coord;


public class CoordTest
{

    Coord doubleCoord;
    Coord intCoord;
    
    @Before
    public void setup(){
        doubleCoord = new Coord(1.5, 1.5);
        intCoord = new Coord(1,1);
    }
    
    @Test
    public void testGetX()
    {
        assertEquals(1.5, doubleCoord.getX(), 0);
        assertEquals(1, intCoord.getX(), 0);
    }
    @Test
    public void testGetY()
    {
        assertEquals(1.5, doubleCoord.getY(), 0);
        assertEquals(1, intCoord.getY(), 0);
    }
    @Test
    public void testSetX()
    {
        doubleCoord.setX(5.5);
        intCoord.setX(5);
        assertEquals(5.5, doubleCoord.getX(), 0);
        assertEquals(5, intCoord.getX(), 0);
    }
    @Test
    public void testSetY()
    {
        doubleCoord.setY(5.5);
        intCoord.setY(5);
        assertEquals(5.5, doubleCoord.getY(), 0);
        assertEquals(5, intCoord.getY(), 0);
    }
    
    @Test
    public void testAddX(){
        doubleCoord.addX(1.5);
        intCoord.addX(1);
        assertEquals(3, doubleCoord.getX(), 0);
        assertEquals(2, intCoord.getX(), 0);
    }

    @Test
    public void testAddY(){
        doubleCoord.addY(1.5);
        intCoord.addY(1);
        assertEquals(3, doubleCoord.getY(), 0);
        assertEquals(2, intCoord.getY(), 0);
    }
}
