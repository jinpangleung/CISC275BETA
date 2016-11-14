package model.gui.touch;

import model.drawing.Animation;
import model.drawing.Coord;
import model.grid.griditem.GridItem;
import model.grid.gridcell.GridPosition;

public class DefaultTouchObject extends GridItem {

	public DefaultTouchObject() {
		super(new Coord(0.0, 0.0), new Animation(), new GridPosition(0, 0));
	}

}
