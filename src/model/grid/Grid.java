package model.grid;

import model.grid.gridcell.GridCell;

public class Grid extends Component {
	
	private Grid grid = null;
	
	public Grid(){
	}
	
	public void initialize(){
		this.grid = new Grid();
	}
	
	public static Grid getInstance(){
		return this.grid;
	}
	
	public Acceleration getAcceleration(GridPosition gridPosition){
		return null;	
	}

}
