package model;

import java.io.Serializable;

import model.grid.Grid;

/**
 * Player
 * player has the timer of the game and it keeps count for the estuary health
 * 
 * @author Roy
 *
 */

public class Player implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4335174976411188096L;
	
	private int estuaryHealth;
	private long startTime;
	private long gameTime;
	private int oysterCount;
	
	static private Player player;
	private Player(){
		estuaryHealth = 500; // ranging from 0 -> 1000, start right in the middle
		startTime = System.currentTimeMillis();
		gameTime = 0;
	}
	
	static public Player getInstance(){
		if(player == null){
			player = new Player();
		}
		return player;
	}
	
	public long getStartTime(){
		return startTime;
	}
	
	public int getEstuaryHealth() {
		return estuaryHealth;
	}

	public void setEstuaryHealth(int estuaryHealth) {
		this.estuaryHealth = estuaryHealth;
	}

	public long getGameTime() {
		return gameTime;
	}

	public void setGameTime(long gameTime) {
		this.gameTime = gameTime;
	}
	
	public void update(long timeElapsed) {
		gameTime += timeElapsed;
	}
	
	
	

}
