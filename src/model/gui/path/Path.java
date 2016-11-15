package model.gui.path;

import model.drawing.Coord;
import model.grid.Grid;
import model.grid.griditem.GridItem;
import model.moving.Velocity;

/*
 * A Path is used to tell a Grid Items to move from one point of the screen to another
 */

public class Path {
	
	private GridItem gi;
	private Coord destination;
	private double speed; // separate from Grid Item's speed
	private Velocity velocity;
	private PathBehavior termination;
	private boolean posX;
	private boolean posY;
	
	public Path(GridItem gi, Coord destination, PathBehavior termination){
		this.gi = gi;
		this.destination = destination;
		this.termination = termination;
		this.initializeSpeed();
	}
	
	private void initializeSpeed(){
		Coord start = gi.getCoord();
		Coord end = this.getDestination();
		long desiredNanoSeconds = 1000000000; // How many nano seconds should it take for the path to finish
		// Currently it takes 1 second to complete a path
		double distance = Math.sqrt(Math.pow(end.getX() - start.getX(), 2) + Math.pow(end.getY() - start.getY(), 2));
		this.speed = distance / desiredNanoSeconds;
		double angle = Math.atan2(end.getY() - start.getY(), end.getX() - start.getX());
		this.velocity = new Velocity(this.speed * Math.cos(angle), this.speed * Math.sin(angle));
		this.posX = this.velocity.getX() >= 0;
		this.posY = this.velocity.getY() >= 0;
		
	}
	
	public static void snap(GridItem gi, Coord destination, PathBehavior termination){
		Path p = new Path(gi, destination, termination);
		p.initializeSpeed();
		Grid.getInstance().addPath(p);
	}
	
	public void update(long elapsedTime){
		double origX = gi.getCoord().getX();
		double origY = gi.getCoord().getY();
		double vx = this.velocity.getX();
		double vy = this.velocity.getY();
		vx *= elapsedTime;
		vy *= elapsedTime;
		gi.setCoord(new Coord(origX + vx, origY + vy));
		
		if(this.finished()){
			termination.terminate(this);
			this.removeFromGrid();
		}
	}
	
	private boolean finished(){
		boolean isFinished = true;
		if(this.posX){
			isFinished = isFinished && gi.getCoord().getX() >= this.destination.getX();
		} else {
			isFinished = isFinished && gi.getCoord().getX() <= this.destination.getX();
		}
		if(this.posY){
			isFinished = isFinished && gi.getCoord().getY() >= this.destination.getY();
		} else {
			isFinished = isFinished && gi.getCoord().getY() <= this.destination.getY();
		}
		
		return isFinished;
	}
	
	private void removeFromGrid(){
		
	}
	
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public GridItem getGridItem() {
		return gi;
	}
	public void setGridItem(GridItem gi) {
		this.gi = gi;
	}
	public Coord getDestination() {
		return destination;
	}
	public void setDestination(Coord destination) {
		this.destination = destination;
	}

}
