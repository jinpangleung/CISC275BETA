package model.grid.griditem;

import model.drawing.Animation;
import model.drawing.Coord;
import model.drawing.DrawableObject;
import model.grid.gridcell.GridPosition;

/**
 * GridItem
 * Abstract class that represents an object that can exists on a Grid
 * A GridItem is drawable
 * @author Eric
 *
 */

public class GridItem extends DrawableObject {
	
	public GridItem(Coord coord, Animation animation, GridPosition gridPosition) {
		super(coord, animation);
		this.gridPosition = gridPosition;
	}

	private GridPosition gridPosition;
	
	public GridPosition getGridPosition(){
		return gridPosition;
	}
	
	public void setGridPosition(GridPosition gp){
		this.gridPosition = gp;
	}

}
