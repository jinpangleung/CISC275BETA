package model.grid.griditem.trailitem;

import java.util.Collection;

import model.Model;
import model.drawing.Animation;
import model.drawing.Coord;
import model.grid.Grid;
import model.grid.gridcell.GridPosition;
import model.grid.griditem.GridColor;
import model.grid.griditem.towers.Tower;
import model.gui.touch.Touch;
import model.moving.MovableObject;
import model.moving.Velocity;

/**
 * TrailItem
 * A TrailItem is a GridItem that moves along with the direction of the GridCells
 * They can be picked up via the Grid's mouse handlers
 * 
 * @author Roy, Eric
 *
 */

public class TrailItem extends MovableObject {
	
	public TrailItem(Coord coord, Animation animation, GridPosition gridPosition, Velocity velocity) {
		super(coord, animation, gridPosition, velocity);
	}
	
	public void click(){
		Collection<Tower> TI = Grid.getInstance().getTowers();
		for (Tower a : TI){
			if (a.getGridColor() == this.getGridColor()){
				if (a.isInRange(this.getCoord())){
					Touch.getInstance().clamp(a);					
				}
			}
			else{
				System.out.println("Not in range for any tower");
			}
		}
	}

}
