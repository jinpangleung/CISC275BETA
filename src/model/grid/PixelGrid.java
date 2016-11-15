package model.grid;

import model.drawing.Coord;
import model.grid.gridcell.GridCell;

public class PixelGrid {

	
	public PixelGrid(){
		
	}
	
	public GridCell getGridCell(Coord coord){
		//get offset X and Y position
		double offsetX = Grid.getInstance().getTopLeft().getX();
		double offsetY = Grid.getInstance().getTopLeft().getY();
		//get coord X and Y position
		double coordX = coord.getX();
		double coordY = coord.getY();
		//get exact X and Y position
		double xPos = (coordX - offsetX) / Board.getSquareSize();
		double yPos = (coordY - offsetY) / Board.getSquareSize();
		//crash program if goes out of grid
		if(xPos >= Grid.getInstance().getSquareWidth() || xPos < 0 
				|| yPos >= Grid.getInstance().getSquareHeight() || yPos < 0){
			throw new OutOfGridException();
		}
		return Grid.getInstance().getGridCell(xPos,yPos);
	}
}
