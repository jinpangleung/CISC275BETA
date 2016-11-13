package model.gui;

/*
 * A Path is used to tell a Grid Items to move from one point of the screen to another
 */

public class Path {
	
	private GridItem gi;
	private Posn destination;
	private PathBehavior behavior;
	private PathTermination terminate;
	private int speed; // seperate from Grid Item's speed
	
	public Path(GridItem gi, Posn destination, PathBehavior behavior, PathTermination terminate, int speed){
		this.gi = gi;
		this.destination = destination;
		this.behavior = behavior;
		this.terminate = terminate;
		this.speed = speed;
	}
	
	public void toGrid(){
		Grid.getInstance().addGridItem(gi);
	}
	
	public boolean straightUpdate(){
		gi.getPixelPosn().addY(speed);
		if(gi.getPixelPosn().getY() >= destination.getY()){
			toGrid();
			return true;
		}
		return false;
	}
	
	public boolean update(){
		switch(behavior){
		case STRAIGHT: return straightUpdate();
		}
		return false;
	}
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public GridItem getGridItem() {
		return gi;
	}
	public void setGridItem(GridItem gi) {
		this.gi = gi;
	}
	public Posn getDestination() {
		return destination;
	}
	public void setDestination(Posn destination) {
		this.destination = destination;
	}
	public PathBehavior getBehavior() {
		return behavior;
	}
	public void setBehavior(PathBehavior behavior) {
		this.behavior = behavior;
	}
	public PathTermination getTerminate() {
		return terminate;
	}
	public void setTerminate(PathTermination terminate) {
		this.terminate = terminate;
	}
	
	

}
