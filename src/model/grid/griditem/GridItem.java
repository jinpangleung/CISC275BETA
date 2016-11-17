package model.grid.griditem;

import java.io.Serializable;

import model.drawing.Animation;
import model.drawing.Coord;
import model.drawing.DrawableObject;
import model.grid.GridColor;
import model.grid.gridcell.GridPosition;

/**
 * GridItem
 * Abstract class that represents an object that can exists on a Grid
 * A GridItem is drawable
 * @author Eric
 *
 */

public class GridItem extends DrawableObject implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2384943399880347105L;

	public GridItem(Coord coord, Animation animation, GridPosition gridPosition, GridColor gc) {
		super(coord, animation);
		this.gridPosition = gridPosition;
		this.gridColor = gc;
	}

	protected GridPosition gridPosition;
	protected GridColor gridColor;
	
	public GridPosition getGridPosition(){
		return gridPosition;
	}
	
	public void setGridPosition(GridPosition gp){
		this.gridPosition = gp;
	}
	
	public GridColor getGridColor(){
		return gridColor;
	}
	
	public void setGridColor(GridColor gc){
		this.gridColor = gc;
	}

	public void update(long elapsedTime) {
		// TODO Auto-generated method stub
		
	}

}