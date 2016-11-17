package model.grid.gridcell;

import model.grid.Grid;
import model.grid.griditem.GridItem;
import model.grid.griditem.gabion.Gabion;
import model.grid.griditem.towers.Tower;
import model.grid.griditem.trailitem.TrailItem;
import model.gui.path.BackToGridBehavior;
import model.gui.path.TowerBehavior;
import model.gui.touch.Touch;

// A spot on the underlying Grid of the game
// Mostly controls direction of the water flowing
public class GridCell {
	
	private GridPosition gridPosition;
	private boolean isTrail;
	//public boolean isLand;
	private Direction direction;
	private boolean forGabion;
	
	public GridCell(GridPosition g, boolean isT, Direction d){//boolean isL
		this.gridPosition = g;
		this.isTrail = isT;
		//this.isLand = isL; probably dont need this, if its not the trail then its the land.
		this.direction = d;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public GridPosition getGridPosition() {
		return gridPosition;
	}

	public void setGridPosition(GridPosition gridPosition) {
		this.gridPosition = gridPosition;
	}

	public boolean isTrail() {
		return isTrail;
	}

	public void setTrail(boolean isTrail) {
		this.isTrail = isTrail;
	}

//	public boolean isLand() {
//		return isLand;
//	}
//
//	public void setLand(boolean isLand) {
//		this.isLand = isLand;
//	}
	public String toString(){
		String str = "";
		switch(direction){
		case NORTH: str += "North"; break;
		case EAST: str += "South"; break;
		case WEST: str += "West"; break;
		case SOUTH: str += "South"; break;
		case SOUTHEAST: str += "South East"; break;
		case SOUTHWEST: str += "South West"; break;
		case NORTHEAST: str += "North East"; break;
		case NORTHWEST: str += "North West"; break;
		default: str += "Something is wrong with direction..."; break;
		}
		return str;
	}
	
	public void release(int mouseX, int mouseY){
		GridItem gi = Touch.getInstance().unClamp();
		if(gi instanceof TrailItem){
			model.gui.path.Path.snap(gi, Touch.getInstance().getStartPosition(), new BackToGridBehavior());
		} else if (gi instanceof Tower){
			makeAnHonestAttemptToPlaceTheTower((Tower) gi);
		} else if (gi instanceof Gabion){
			makeAnHonestAttemptToPlaceTheGabion((Gabion) gi);
		}
	}
	
	public void makeAnHonestAttemptToPlaceTheTower(Tower t){
		if(forGabion){
			model.gui.path.Path.snap(t, Touch.getInstance().getStartPosition(), new TowerBehavior());
			return;
		}
		if(Grid.getInstance().hasTower(this.gridPosition)){
			model.gui.path.Path.snap(t, Touch.getInstance().getStartPosition(), new BackToGridBehavior());
			return;
		}
		Grid.getInstance().addTower(t);
		
	}
	
	public void makeAnHonestAttemptToPlaceTheGabion(Gabion g){
		if(forGabion){
			if(Grid.getInstance().hasGabion(this.gridPosition)){
				model.gui.path.Path.snap(g, Touch.getInstance().getStartPosition(), new TowerBehavior());
				return;
			} else {
				Grid.getInstance().addGabion(g);
			}
		}
	}

}
