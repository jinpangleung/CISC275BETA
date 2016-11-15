package model.grid.griditem.trailitem;

import java.util.Collection;
import model.*;
import model.drawing.Animation;
import model.drawing.Coord;
import model.grid.Grid.*;
import model.grid.gridcell.GridPosition;
import model.grid.GridColor;
import model.moving.Velocity;

/**
 * 
 * InvasiveItem are creatures that's bad for the estuary, you are supposed to pick them up from river
 * 
 * @author Roy Cheng, Eric
 * @version 1
 * @attributes health - health of the trailitems
 * @attributes speed - how fast they travel in the river
 * @attributes isBad - if it is bad to click on it
 * 
 */

public class InvasiveItem extends TrailItem{

	public InvasiveItem(Coord coord, Animation animation, GridPosition gridPosition, Velocity velocity) {
		super(coord, animation, gridPosition, velocity);
		setGridColor(GridColor.GREEN);
		
	}
	
}
