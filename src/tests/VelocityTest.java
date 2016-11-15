package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.moving.Velocity;

public class VelocityTest
{

    Velocity a;
    
    @Before
    public void setup(){
        a = new Velocity(1, 1);
    }
    
    @Test
    public void testGetX()
    {
        assertEquals(1, a.getX(), 0);
    }
    @Test
    public void testGetY()
    {
        assertEquals(1, a.getY(), 0);
    }
    @Test
    public void testSetX()
    {
        a.setX(5);
        assertEquals(5, a.getX(), 0);
    }
    @Test
    public void testSetY()
    {
        a.setY(5);
        assertEquals(5, a.getY(), 0);
    }

}
