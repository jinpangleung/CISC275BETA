package model.grid.gridcell;
// A spot on the underlying Grid of the game
// Mostly controls direction of the water flowing
public class GridCell {
	
	private GridPosition gridPosition;
	public boolean isTrail;
	public boolean isLand;
	public Direction direction;
	
	public GridCell(GridPosition g, boolean isT, boolean isL, Direction d){
		this.gridPosition = g;
		this.isTrail = isT;
		this.isLand = isL;
		this.direction = d;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public GridPosition getGridPosition() {
		return gridPosition;
	}

	public void setGridPosition(GridPosition gridPosition) {
		this.gridPosition = gridPosition;
	}

	public boolean isTrail() {
		return isTrail;
	}

	public void setTrail(boolean isTrail) {
		this.isTrail = isTrail;
	}

	public boolean isLand() {
		return isLand;
	}

	public void setLand(boolean isLand) {
		this.isLand = isLand;
	}
	

}
