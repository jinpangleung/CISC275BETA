package model.grid;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import model.*;
import model.drawing.Coord;
import model.grid.Grid;
import model.grid.gridcell.Direction;
import model.grid.gridcell.GridPosition;
import model.grid.griditem.trailitem.InvasiveItem;
import model.grid.griditem.trailitem.Larvae;
import model.grid.griditem.trailitem.Oyster;
import model.grid.griditem.trailitem.Pollutant;
import model.grid.griditem.trailitem.TrailItem;
import model.gui.path.*;

public class Difficulty {
	
	private int timeToSpawn;
	private final int SPAWN_TIME = 120;
	private int oysterCount;
	private int invasiveCount;
	private int pollutantCount;
	private int larvaeCount;
	
	public Difficulty(){
		timeToSpawn = SPAWN_TIME;
	}
	
	/**
	 * Returns void
	 * <p>
	 * Look at the current Grid and decide how to scale difficulty and when to spawn new objects
	 */
	public void update(){
		if(timeToSpawn > 0){
			timeToSpawn--;
		} else {
			spawn();
			timeToSpawn = SPAWN_TIME;
		}
	}
	
	/**
	 * Place the trail item into the Grid
	 * 
	 */
	
	//this needs to be fixed
	public void spawn(){
		TrailItem toBeSpawned = decideSpawn();
		List<GridPosition> listOfSpawnPoints = Grid.getInstance().getCells().getSpawnPositions();
		int randomIndex = ThreadLocalRandom.current().nextInt(0, listOfSpawnPoints.size());
		GridPosition spawnPoint = listOfSpawnPoints.get(randomIndex);
		toBeSpawned.setGridPosition(spawnPoint);
		GridPosition coord = Grid.getInstance().getPixelGrid().getValidPixelPosn(spawnPoint);
		toBeSpawned.setCoord(coord.getX(), 0);
//		toBeSpawned.setCoord(new Coord(toBeSpawned.getCoord().getX(), 0));
		Grid.getInstance().addPath(new Path(toBeSpawned, coord, Direction.STRAIGHT, PathTermination.TO_GRID, 1));
	}
	
	/**
	 * Returns void
	 * <p>
	 * Use the difficulty and what has been spawned recently to decide
	 * what needs to be spawned, avoid unwinnable scenarios
	 */
	public TrailItem decideSpawn(){
		//(Poissen process? maybe not) in time the random should have a nice average between the 4
		//if by chance it doesnt, the spawn rate should be adjusted when the item is called by our random.
		int randomNum = (int)(Math.random() * 3);
		
		if(randomNum == 0){
			oysterCount++;
			if (timeToSpawn < 90 && oysterCount < 4){
				return new Oyster();//need to change speed(slower) or spawn rate
			}
			else if(timeToSpawn < 90 && oysterCount > 6){
				return new Oyster();//need to change speed(faster) or spawn rate
			}
			if (timeToSpawn < 30 && oysterCount < 12){
				return new Oyster();//need to change speed(slower) or spawn rate
			}
			else if (timeToSpawn < 30 && oysterCount > 16){
				return new Oyster();//need to change speed(faster) or spawn rate
			}
			return new Oyster();
		}
		else if (randomNum == 1){
			invasiveCount++;
			if (timeToSpawn < 90 && invasiveCount < 4){
				return new InvasiveItem();//need to change speed(slower) or spawn rate
			}
			else if(timeToSpawn < 90 && invasiveCount > 6){
				return new InvasiveItem();//need to change speed(faster) or spawn rate
			}
			if (timeToSpawn < 30 && invasiveCount < 12){
				return new InvasiveItem();//need to change speed(slower) or spawn rate
			}
			else if (timeToSpawn < 30 && invasiveCount > 16){
				return new InvasiveItem();//need to change speed(faster) or spawn rate
			}
			return new InvasiveItem();
		}
		else if (randomNum == 2){
			larvaeCount++;
			if (timeToSpawn < 90 && larvaeCount < 4){
				return new Larvae();//need to change speed(slower) or spawn rate
			}
			else if(timeToSpawn < 90 && larvaeCount > 6){
				return new Larvae();//need to change speed(faster) or spawn rate
			}
			if (timeToSpawn < 30 && larvaeCount < 12){
				return new Larvae();//need to change speed(slower) or spawn rate
			}
			else if (timeToSpawn < 30 && larvaeCount > 16){
				return new Larvae();//need to change speed(faster) or spawn rate
			}
			return new Larvae();
		}
		else{	
			//if we are still giving pollutants "health" or "drags" then we need to make it known in pollutant constructor
			pollutantCount++;
//			int randomPol = (int)(Math.random() * 2); 
			if (timeToSpawn < 90 && pollutantCount < 4){
				return new Pollutant();//need to change speed(slower) or spawn rate
			}
			else if(timeToSpawn < 90 && pollutantCount > 6){
				return new Pollutant();//need to change speed(faster) or spawn rate
			}
			if (timeToSpawn < 30 && pollutantCount < 12){
				return new Pollutant();//need to change speed(slower) or spawn rate
			}
			else if (timeToSpawn < 30 && pollutantCount > 16){
				return new Pollutant();//need to change speed(faster) or spawn rate
			}
//			if(randomPol == 0){
//				return new Pollutant(1);
//			}
//			else if (randomPol == 1){
//				return new Pollutant(2);
//			}
//			else if (randomPol == 2){
//				return new Pollutant(3);
//			}
		return new Pollutant();
		}
	}

}
