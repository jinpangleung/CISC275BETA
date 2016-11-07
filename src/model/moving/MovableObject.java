package model.moving;

import model.drawing.Animation;
import model.drawing.Coord;
import model.drawing.DrawableObject;

/**
 * MovableObject
 * An Object that can be moved
 * Needs to have a velocity to dictate movement
 * A MovableObject is also a DrawableObject
 * @see DrawableObject
 * @author Eric
 *
 */

public abstract class MovableObject extends DrawableObject {
	
	public MovableObject(Coord coord, Animation animation) {
		super(coord, animation);
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
