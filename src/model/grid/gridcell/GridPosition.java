package model.grid.gridcell;

import java.io.Serializable;

/**
 * GridPosition
 * x, y positions that correlates the a cell on the grid
 * 
 * @author Eric
 *
 */

public class GridPosition implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3814282873416020711L;
	
	private int x;
	private int y;
	
	public GridPosition(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public String toString(){
		String str = "";
		str += "(";
		str += Integer.toString(x);
		str += ", ";
		str += Integer.toString(y);
		str += ")";
		return str;
	}

}
