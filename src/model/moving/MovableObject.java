package model.moving;

import model.drawing.Animation;
import model.drawing.Coord;
import model.drawing.DrawableObject;
import model.grid.gridcell.GridPosition;
import model.grid.griditem.GridItem;

/**
 * MovableObject
 * An Object that can be moved
 * Needs to have a velocity to dictate movement
 * A MovableObject is also a DrawableObject
 * @see DrawableObject
 * @author Eric
 *
 */

public abstract class MovableObject extends GridItem {

	public MovableObject(Coord coord, Animation animation, GridPosition gridPosition, Velocity velocity) {
		super(coord, animation, gridPosition);
		this.velocity = velocity;
	}

	private Velocity velocity;
	
	public void move(){
		// TODO
	}
	
	public Velocity getVelocity(){
		return velocity;
	}
	
	public void setVelocity(Velocity velocity){
		this.velocity = velocity;
	}
	
	

}
