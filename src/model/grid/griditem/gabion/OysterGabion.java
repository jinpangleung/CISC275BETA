package model.grid.griditem.gabion;

import model.drawing.Animation;
import model.drawing.Coord;
import model.grid.gridcell.GridPosition;

/**
 * OysterGabion
 * Player collects osyter and build oyster gabions, which it helps to prevent storm from damaging estuary
 * 
 * @author Roy
 *
 */

public class OysterGabion extends Gabion{
	public OysterGabion(Coord coord, Animation animation, GridPosition gridPosition){
		super(coord, animation, gridPosition);
	}

    @Override
    public void takeDamage()
    {
        this.setHealth(this.getHealth() - 10);
        
    }
}
