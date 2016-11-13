package model.grid.griditem.trailitem;

import java.util.Collection;

import model.Model;
import model.drawing.Animation;
import model.drawing.Coord;
import model.grid.Grid;
import model.grid.gridcell.GridPosition;
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

	public TrailItem(Coord coord, Animation animation, GridPosition gridPosition, Velocity velocity) {
		super(coord, animation, gridPosition, velocity);
	}
	
	public void click(){
		Collection<TrailItem> TI = Grid.getInstance().getTrailItems();
		double x = this.coord.getX();
		double y = this.coord.getY();
		for (TrailItem a:TI){
			if (Math.sqrt(x*x+y*y)<a.radius){
				Model.getInstance().getTouch().Clamp(a);
			}
			else{
				System.out.println("Not in range for any tower");
			}
		}
	}

}
