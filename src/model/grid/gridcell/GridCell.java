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
		public String toString(){
		String str = "";
		switch(direction){
		case NORTH: str += "North"; break;
		case EAST: str += "South"; break;
		case WEST: str += "West"; break;
		case SOUTH: str += "South"; break;
		case SOUTHEAST: str += "South East"; break;
		case SOUTHWEST: str += "South West"; break;
		case NORTHEAST: str += "North East"; break;
		case NORTHWEST: str += "North West"; break;
		}
		return str;
	}

}
