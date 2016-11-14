package model.grid;

import java.util.Collection;

import model.*;

import model.grid.gridcell.GridCell;
import model.grid.griditem.GridItem;
import model.grid.griditem.gabion.Gabion;
import model.grid.griditem.towers.Tower;
import model.grid.griditem.trailitem.TrailItem;
import model.gui.Path;
import model.gui.component.Component;
import model.gui.component.ComponentPosition;
import model.gui.touch.Touch;


///////////////HAS LOTS OF ERRORS, WILL DEBUG AFTER ALL CLASSES ARE IMPLEMENTED/////////////
// Fixed the errors for now, but Grid has a lot going on, will look into finishing it later - Eric
public class Grid extends Component {
	
	private Collection<GridItem> items;
	private Collection<Tower> towers;
	private Collection<TrailItem> trailItems;
	private Collection<Gabion> gabions;
	private Collection<Path> paths;
	private Difficulty difficulty;
	private Touch touch;
	
	static private Grid grid;
	//// Attributes ////
	
	static public Grid getInstance(){
		return grid;
	}
	
	//// Constructor ////
	public Grid(){
		super(new ComponentPosition(0, 0), 0, 0);
		grid = this;
	}
	
	//// Getters and Setters ////
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
}
