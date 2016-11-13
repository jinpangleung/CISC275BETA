package model.grid.griditem.towers;

import model.drawing.Animation;
import model.drawing.Coord;
import model.drawing.Offset;
import model.grid.GridColor;
import model.grid.gridcell.GridPosition;
import model.grid.griditem.GridItem;
import model.grid.griditem.trailitem.TrailItem;
import model.gui.touch.Touch;
/**
 * A Tower is an abstract object that extends GridItem. 
 * 
 * @author leung
 * @version 1
 * @attributes GridColor - Color on the grid
 * @attributes cooldownRemaining - Cooldown for tower
 * @attributes range - range of tower
 * @throw
 * @return
 */

public abstract class Tower extends GridItem {

	////Attributes ////
	protected GridColor gridColor;
	protected int cooldownRemaining;
	protected int range;
//	protected Coord loc;
//	protected Animation ani;
//	protected GridPosition gridPos;
	
	public Tower(Coord coord, Animation animation, GridPosition gridPosition) {
		super(coord, animation, gridPosition);
//		loc = coord;
//		ani = animation;
//		gridPos = gridPosition;
		
		
	}
	
	////  Getters  ////
	public GridColor getColor(){
		return this.gridColor;
	}
	
	public int getCooldownRemaining(){
		return this.cooldownRemaining;
	}
	
	public int getRange(){
		return this.range;
	}
	
	
	public void setCooldownRemaining(int cd){
		this.cooldownRemaining = cd;
	}
	
	public boolean isInRange(Coord cd){
		if(range <= Math.sqrt(Math.pow(cd.getX()+coord.getX(),2)+Math.pow(cd.getY()+coord.getY(),2))){
			return true;
		}
		return false;	
	}
	
	public String toString(){
		String str = "";
		switch(gridColor){
		case RED: str += "Red Tower "; break;
		case BLUE: str += "Blue Tower "; break;
		case GREEN: str += "Green Tower "; break;
		default: str += "Undefined Color Tower "; break;
		}
		str += "Grid Posn: " + gridPosition.toString() + " Pixel Posn " + coord.toString() + " ";
		str += "Cooldown Remaining = " + Integer.toString(cooldownRemaining);
		return str;
	}
	
	
	
	//// Methods ////
	public void ability(){
		
	}
	
	public void release(){
		GridItem gi = Touch.unClamp();
		if(gi instanceof TrailItem){
			if(gi.getColor()==this.getColor()){
				//DO SOMETHING
			}
			else{
				//snap()
			}
		}
		else{
			//snap()
		}
	}
	
//	@Override
//	public void update(){
//		//TODO update should probably pass around elapsedTickTime, add after controller is implemented - Gifan
//		if(cooldownRemaining > 0){
//			cooldownRemaining--;
//		} else {
//			ability();
//		}
//	}
}
