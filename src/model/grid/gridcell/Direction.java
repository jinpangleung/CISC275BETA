package model.grid.gridcell;

import java.io.Serializable;

/**
 * Direction
 * enum class that indicates the direction of where the object is heading
 * 
 * @author Roy
 *
 */

public enum Direction implements Serializable {
	NORTH, EAST, SOUTH, WEST, SOUTHWEST, SOUTHEAST, NORTHEAST, NORTHWEST, NONE, STRAIGHT
}
