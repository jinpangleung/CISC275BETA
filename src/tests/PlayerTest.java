package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Player;

public class PlayerTest {

	Player player;
	
	@Before
	public void setup(){
		player = Player.getInstance();
	}
	
	@Test
	public void testGetStartTime() {
		assertEquals(true, player.getStartTime() > 0);
	}
	
	@Test
	public void testGetSetEstuaryHealth() {
		assertEquals(500, player.getEstuaryHealth());
		player.setEstuaryHealth(100);
		assertEquals(100, player.getEstuaryHealth());
	}
	
	@Test
	public void testGetSetGameTime() {
		assertEquals(0, player.getGameTime());
		player.setGameTime(100);
		assertEquals(100, player.getGameTime());
	}
	
	@Test
	public void testUpdate() {
		player.update(54);
		assertEquals(54, player.getGameTime());
	}
}
