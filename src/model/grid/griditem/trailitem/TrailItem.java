package model.grid.griditem.trailitem;

import model.drawing.Animation;
import model.drawing.Coord;
import model.grid.gridcell.GridPosition;
import model.moving.MovableObject;
import model.moving.Velocity;

/**
 * TrailItem
 * A TrailItem is a GridItem that moves along with the direction of the GridCells
 * They can be picked up via the Grid's mouse handlers
 * 
 * @author Eric
 *
 */

public class TrailItem extends MovableObject {

	public TrailItem(Coord coord, Animation animation, GridPosition gridPosition, Velocity velocity) {
		super(coord, animation, gridPosition, velocity);
	}

}
