package model.grid.griditem.trailitem;

import java.util.Collection;

import com.sun.scenario.effect.Offset;

import model.*;
import model.drawing.Coord;
import model.grid.GridColor;
import model.grid.gridcell.GridPosition;
import model.moving.Velocity;

/**
 * 
 * Pollutant are stuff that's bad for the estuary, you are supposed to pick them up.
 * 
 * @author Roy Cheng
 * @version 1
 * @attributes health - health of the trailitems
 * @attributes speed - how fast they travel in the river
 * @attributes isBad - if it is bad to click on it
 * 
 */

public class Pollutant extends TrailItem{

	public Pollutant(Coord coord, model.drawing.Animation animation, GridPosition gridPosition, Velocity velocity) {
		super(coord, animation, gridPosition, velocity);
		gridcolor = GridColor.RED;
		animation = new Animation("pollutant", Offset.CENTER, Offset.CENTER);
	}
	
}
