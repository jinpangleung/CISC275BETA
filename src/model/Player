package model;

import model.grid.Grid;

public class Player {
	private int estuaryHealth;
	private long startTime;
	private long gameTime;
	private int oysterCount;
	
	static private Player player;
	public Player(){
		estuaryHealth = 500; // ranging from 0 -> 1000, start right in the middle
		startTime = System.currentTimeMillis();
		gameTime = 0;
		player = this;
	}
	
	static public Player getInstance(){
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
	
	public void update() {
		gameTime = System.currentTimeMillis() - startTime;
	}
	
	
	

}
