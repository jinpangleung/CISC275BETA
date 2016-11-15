
package model.grid;

import model.grid.gridcell.GridCell;

public class Board {
	
	private GridCell[][] gridCell;
	
	// Constructor
	public Board(){
		try{
			// Read from grid.txt
			Path path = Paths.get("grid.txt");
		    List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
		    gridSize = lines.get(0).length();
		    System.out.println("Grid Size " + Integer.toString(gridSize));
		} catch (IOException e){
			System.out.println("Could not open grid.txt");
			throw new RuntimeException();
		}
	}
	
	public void getSquareWidth(){
		
	}
	public void getSquareHeight(){
		
	}
	public void getSquareSize(){
		
	}
	public void getGridCell(int x, int y){
		
	}
	public class DirectionGrid {
		
	}
}
