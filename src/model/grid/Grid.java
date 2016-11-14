package model.grid;

import java.util.Collection;

import model.*;

import model.grid.gridcell.GridCell;
import model.grid.griditem.GridItem;
import model.grid.griditem.tower.Tower;
import model.grid.griditem.trailitem.TrailItem;
import model.gui.Path;
import model.gui.touch.Touch;


///////////////HAS LOTS OF ERRORS, WILL DEBUG AFTER ALL CLASSES ARE IMPLEMENTED/////////////
public class Grid {
	
	private Collection<GridItem> items;
	private Collection<Tower> towers;
	private Collection<TrailItem> trailItems;
	private Collection<Gabion> gabions;
	private Collection<Path> paths;
	private Difficulty difficulty;
	private Touch touch;
	
	static private Grid grid = null;
	//// Attributes ////
	
	static public Grid getInstance(){
		if(grid == null){
			grid = new Grid();
		}
		return grid;
	}
	
	//// Constructor ////
	public Grid(){
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		cells = new DirectionGrid();
		System.out.println(cells);
		items = new ArrayList<GridItem>();
		towers = new ArrayList<Tower>();
		trailItems = new ArrayList<TrailItem>();
		gabions = new ArrayList<Gabion>();
		paths = new ArrayList<Path>();
		difficulty = new Difficulty();
		new ImageLibrary();
		touch = new Touch();
		towerComponent = new Structures((int) d.getWidth(), (int) d.getHeight(), pixelGrid);
	}
	
	//// Getters and Setters ////
	public Structures getTowerComponent(){
		return towerComponent;
	}
	public DirectionGrid getCells(){
		return cells;
	}
	public Collection<GridItem> getItems(){
		return items;
	}
	public Collection<Tower> getTowers(){
		return towers;
	}
	public Collection<TrailItem> getTrailItems(){
		return trailItems;
	}
	public Collection<Gabion> getGabions(){
		return gabions;
	}
	public int getGridSize(){
		return cells.getGridSize();
	}
	

}
