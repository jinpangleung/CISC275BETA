package model.moving;

import model.drawing.Animation;
import model.drawing.Coord;
import model.drawing.DrawableObject;
import model.grid.Grid;
import model.grid.GridColor;
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

	public MovableObject(Coord coord, Animation animation, GridPosition gridPosition, GridColor gc, Velocity velocity) {
		super(coord, animation, gridPosition, gc);
		this.velocity = velocity;
	}

	private Velocity velocity;
	final double MAXVELOCITY = Grid.getInstance().getWidthByHeight()/50;
	
	public void move(long elapsedTime){
		Acceleration a = Grid.getInstance().getAcceleration(this.getGridPosition(), elapsedTime);//grabs acceleration of current
		double ax = a.getX();//for specifics
		double ay = a.getY();
		Velocity v = this.getVelocity();//grabs velocity of current
		double vx = v.getX();//for specifics
		double vy = v.getY();
		
		//specifics for readability, xx and yy represent acceleration + velocity which is velocity
		double xx =  ax + vx;
		double yy = ay + vy;
		
		//changes velocity
		v.setX(xx);
		v.setY(yy);
		
		//coordinate for positon
		double cx = this.getCoord().getX(); 
		double cy = this.getCoord().getY();
		
		//calculations for coordinate
		cx = cx + (xx * elapsedTime);
		cy = cy + (yy * elapsedTime);
		
		//setting coordinates
		this.getCoord().setX(cx);
		this.getCoord().setY(cy);
		
		//checks if goes into next grid, if yes update grid position.	
		this.setGridPosition(Grid.getInstance().getGridCell(coord).getGridPosition());
			
		//get grid position for checking block
		//get coor position for checking pixel
		//GridPosition gridPos = Grid.getGridPosition(coord);
		//this.setGridPosition(Grid.getInstance().getGridPosition(this.getCoord()));
		
		
	}
	//eventually move code from move() to this for readability
	public void updateVelocity(){
		//nothing yet
	}
	//eventually move code from move() to this for readability
	public void applyVelocity(){
		//nothing yet
	}
	
	public Velocity getVelocity(){
		return velocity;
	}
	
	public void setVelocity(Velocity velocity){
		this.velocity = velocity;
	}
	
	

}