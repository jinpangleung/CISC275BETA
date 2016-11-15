package model.grid.griditem.trailitem;

import java.util.Collection;

import model.drawing.Animation;
import model.drawing.Offset;
import model.*;
import model.drawing.Coord;
import model.grid.gridcell.GridPosition;
import model.grid.griditem.GridColor;
import model.moving.Velocity;

/**
 * 
 * Oyster is thing that you want to pick up, and when you picked up enough oysters you can build a oyster
 * gabion
 * 
 * @author Roy Cheng, Eric
 * @version 1
 * @attributes health - health of the trailitems
 * @attributes speed - how fast they travel in the river
 * @attributes isBad - if it is bad to click on it
 * 
 */

public class Oyster extends TrailItem{

	public Oyster(Coord coord, Animation animation, GridPosition gridPosition, Velocity velocity) {
		super(coord, animation, gridPosition, velocity);
		setGridColor(GridColor.BLUE);
		animation = new Animation("oyster", Offset.CENTER, Offset.CENTER);
	}

}
