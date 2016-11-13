package model.grid.griditem.trailitem;

import java.util.Collection;

import drawing.Animation;
import drawing.Offset;
import model.*;
import model.drawing.Coord;
import model.grid.GridColor;
import model.grid.gridcell.GridPosition;
import model.moving.Velocity;

/**
 * 
 * Oyster is thing that you want to pick up, and when you picked up enough oysters you can build a oyster
 * gabion
 * 
 * @author Roy Cheng
 * @version 1
 * @attributes health - health of the trailitems
 * @attributes speed - how fast they travel in the river
 * @attributes isBad - if it is bad to click on it
 * 
 */

public class Oyster extends TrailItem{

	public Oyster(Coord coord, model.drawing.Animation animation, GridPosition gridPosition, Velocity velocity) {
		super(coord, animation, gridPosition, velocity);
		gridcolor = GridColor.BLUE;
		animation = new Animation("oyster", Offset.CENTER, Offset.CENTER);
	}

}
