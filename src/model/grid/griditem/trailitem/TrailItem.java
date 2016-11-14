package model.grid.griditem.trailitem;

import java.util.Collection;

import model.Model;
import model.drawing.Animation;
import model.drawing.Coord;
import model.grid.Grid;
import model.grid.gridcell.GridPosition;
import model.grid.griditem.GridColor;
import model.grid.griditem.tower.Tower;
import model.moving.MovableObject;
import model.moving.Velocity;

/**
 * TrailItem
 * A TrailItem is a GridItem that moves along with the direction of the GridCells
 * They can be picked up via the Grid's mouse handlers
 * 
 * @author Roy
 *
 */

public class TrailItem extends MovableObject {
	
	protected GridColor gridcolor;
	
	public TrailItem(Coord coord, Animation animation, GridPosition gridPosition, Velocity velocity) {
		super(coord, animation, gridPosition, velocity);
	}
	
	public GridColor getColor(){
		return this.gridcolor;
	}
	
	public void click(){
		Collection<Tower> TI = Grid.getInstance().getTowers();
		for (Tower a:TI){
			if (a.getColor() == this.getColor()){
				if (isInRange(a.getCoord())){
					Model.getInstance().getTouch().Clamp(a);					
				}
			}
			else{
				System.out.println("Not in range for any tower");
			}
		}
	}

}
