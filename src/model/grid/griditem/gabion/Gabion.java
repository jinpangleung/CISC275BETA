package model.grid.griditem.gabion;

import model.drawing.Animation;
import model.drawing.Coord;
import model.grid.gridcell.GridPosition;
import model.grid.griditem.GridItem;

/**
 * 
 * @author leung
 *
 */

public class Gabion extends GridItem {
	
	int health;

	public Gabion(Coord coord, Animation animation, GridPosition gridPosition) {
		super(coord, animation, gridPosition);
		// TODO Auto-generated constructor stub
	}
	
	public int getHealth(){
		return health;
	}
	
	public static void snap(GridItem gridI, Coord dest){
		gridI.setCoord(dest);
	}

}