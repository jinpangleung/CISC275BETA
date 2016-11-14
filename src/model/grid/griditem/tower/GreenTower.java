package model.grid.griditem.tower;

import model.drawing.Animation;
import model.drawing.Coord;
import model.drawing.Offset;
import model.grid.gridcell.GridPosition;
import model.grid.griditem.GridColor;
/**
 * A GreenTower is a tower that can pick up Invasive Items. 
 * 
 * @author leung
 * @version 1
 * @attributes GridColor - Color on the grid
 * @attributes cooldownRemaining - Cooldown for tower
 * @attributes range - range of tower
 * @throw
 * @return
 */

public class GreenTower extends Tower{
	
	public GreenTower(Coord coord, Animation animation, GridPosition gridPosition){
		super(coord, animation, gridPosition);
		gridColor = GridColor.GREEN;
		cooldownRemaining = 10;
		range = 10;
		animation = new Animation("invasive_item_tower", Offset.CENTER, Offset.CENTER);
	}
	
	@Override
	public void ability(){
		System.out.println(gridColor + " active");
	}
}
