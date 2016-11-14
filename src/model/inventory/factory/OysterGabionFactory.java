package model.inventory.factory;
	
import model.grid.griditem.Coord;
import model.gui.component.ComponentPosition;
import model.gui.touch.Touch;

/**
 * 
 * @author eric
 *
 */

public class OysterGabionFactory extends TowerFactory {
	
	private int oysters;
	private final int OYSTERS_PER_GABION = 4;

	public OysterGabionFactory(ComponentPosition topLeft, int width, int height) {
		super(topLeft, width, height);
		oysters = 0;
	}
	
	public OysterGabionFactory(int x, int y, int width, int height){
		super(x, y, width, height);
		oysters = 2;
	}
	
	@Override
	public void mouseClicked(int mouseX, int mouseY){
		// If applicable, clamp new tower to touch
		if(oysters >= OYSTERS_PER_GABION){
			oysters -= OYSTERS_PER_GABION;
			Touch.clamp(new OysterGabion(new Coord(topLeft.getX(), topLeft.getY())));
		}
	}
	
	@Override
	public void mouseReleased(int mouseX, int mouseY){
		// Do nothing
		Touch.snap();
	}

}