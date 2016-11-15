package model.grid.griditem.trailitem;

import java.util.Collection;

import model.*;
import model.drawing.Animation;
import model.drawing.Coord;
import model.drawing.Offset;
import model.grid.gridcell.GridPosition;
import model.grid.GridColor;
import model.moving.Velocity;

/**
 * 
 * Larvae are stuff that can be picked up anywhere, but you aren't supposed to pick any of them up,
 * since it is suppose to be in the estuary
 * 
 * @author Roy Cheng, Eric
 * @version 1
 * @attributes health - health of the trailitems
 * @attributes speed - how fast they travel in the river
 * @attributes isBad - if it is bad to click on it
 * 
 */

public class Larvae extends TrailItem{

	public Larvae(Coord coord, Animation animation, GridPosition gridPosition, Velocity velocity) {
		super(coord, animation, gridPosition, velocity);
		setGridColor(GridColor.WHITE);
		animation = new Animation("larvae", Offset.CENTER, Offset.CENTER);
	}

}
