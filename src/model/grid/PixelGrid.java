package model.grid;

import model.drawing.Coord;
import model.grid.gridcell.GridCell;
import model.grid.gridcell.GridPosition;


/**
 * PixelGrid
 * it helps for moveableObject, so the animation can move smoothly, instead of jumping from
 * gridcell to gridcell
 * 
 * @author Roy, Eric
 *
 */

public class PixelGrid {

	
	public PixelGrid(){
		
	}
	
	public GridPosition getGridCell(Coord coord){
		//get offset X and Y position
		int offsetX = Grid.getInstance().getTopLeft().getX();
		int offsetY = Grid.getInstance().getTopLeft().getY();
		//get coord X and Y position
		int coordX = (int) coord.getX();
		int coordY = (int) coord.getY();
		//get exact X and Y position
		int xPos = (coordX - offsetX) / Board.getSquareSize();
		int yPos = (coordY - offsetY) / Board.getSquareSize();
		//crash program if goes out of grid
		if(xPos >= Grid.getInstance().getSquareWidth() || xPos < 0 
				|| yPos >= Grid.getInstance().getSquareHeight() || yPos < 0){
			throw new OutOfGridException();
		}
		return new GridPosition(xPos, yPos);
	}
	
	public Coord getValidCoord(GridPosition gp){
		int offsetX = Grid.getInstance().getTopLeft().getX();
		int offsetY = Grid.getInstance().getTopLeft().getY();
		int posX = gp.getX() * Board.getSquareSize();
		int posY = gp.getY() * Board.getSquareSize();
		return new Coord(posX + offsetX, posY + offsetY);
	}
}
