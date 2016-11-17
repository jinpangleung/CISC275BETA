package model.grid.griditem.trailitem;

import java.util.Collection;

import model.drawing.Animation;
import model.drawing.Offset;
import model.*;
import model.drawing.Coord;
import model.grid.gridcell.GridPosition;
import model.grid.GridColor;
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
	public Oyster(){
		super(new Coord(0,0), new Animation("oyster", Offset.CENTER, Offset.CENTER), new GridPosition(0,0), new Velocity(0,1),  GridColor.BLUE);
	}

}
