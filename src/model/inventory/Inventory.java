package model.inventory;

import model.grid.GridColor;
import model.gui.component.ComponentPosition;
import model.inventory.factory.*;

/**
 * Inventory
 * where the towers and gabions are going to be shown intially before players drag it onto
 * the grid
 * 
 * @author eric
 *
 */

public class Inventory {
	
	RedTowerFactory rtf;
	BlueTowerFactory btf;
	GreenTowerFactory gtf;
	ConcreteGabionFactory cgf;
	OysterGabionFactory ogf;
	
	private static Inventory instance;
	
	private Inventory(){
		rtf = new RedTowerFactory(new ComponentPosition(0, 0), 0, 0);
		btf = new BlueTowerFactory(new ComponentPosition(0, 0), 0, 0);
		gtf = new GreenTowerFactory(new ComponentPosition(0, 0), 0, 0);
		cgf = new ConcreteGabionFactory(new ComponentPosition(0, 0), 0, 0);
		ogf = new OysterGabionFactory(new ComponentPosition(0, 0), 0, 0);
	}
	
	public static Inventory getInstance(){
		if(instance == null){
			instance = new Inventory();
		}
		
		return instance;
	}
	
	public TowerFactory getTowerFactory(GridColor gc){
		switch(gc){
		case RED: return rtf;
		case BLUE: return btf;
		case GREEN: return gtf;
		default: System.out.println("Inventory cannot process white tower");
		throw new RuntimeException();
		}
	}

}
