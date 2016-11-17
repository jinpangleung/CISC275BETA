package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.grid.GridColor;
import model.inventory.Inventory;
import model.inventory.factory.BlueTowerFactory;
import model.inventory.factory.GreenTowerFactory;
import model.inventory.factory.RedTowerFactory;

public class InventoryTest {

	Inventory inv;
	
	@Before
	public void setup(){
		inv = Inventory.getInstance();
	}
	
	@Test
	public void testGetTowerFactory() {
		GridColor red = GridColor.RED;
		GridColor blue = GridColor.BLUE;
		GridColor green = GridColor.GREEN;
		
		assertEquals(RedTowerFactory.class, inv.getTowerFactory(red).getClass());
		assertEquals(BlueTowerFactory.class, inv.getTowerFactory(blue).getClass());
		assertEquals(GreenTowerFactory.class, inv.getTowerFactory(green).getClass());
	}

}
