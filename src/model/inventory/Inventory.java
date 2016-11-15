package model.inventory;

import model.grid.GridColor;
import model.gui.component.ComponentPosition;
import model.inventory.factory.*;

public class Inventory {
	
	RedTowerFactory rtf;
	BlueTowerFactory btf;
	GreenTowerFactory gtf;
	ConcreteGabionFactory cgf;
	OysterGabionFactory ogf;
	
	private static Inventory instance;
	
	public Inventory(){
		rtf = new RedTowerFactory(new ComponentPosition(0, 0), 0, 0);
		btf = new BlueTowerFactory(new ComponentPosition(0, 0), 0, 0);
		gtf = new GreenTowerFactory(new ComponentPosition(0, 0), 0, 0);
		cgf = new ConcreteGabionFactory(new ComponentPosition(0, 0), 0, 0);
		ogf = new OysterGabionFactory(new ComponentPosition(0, 0), 0, 0);
		
		instance = this;
	}
	
	public static Inventory getInstance(){
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
