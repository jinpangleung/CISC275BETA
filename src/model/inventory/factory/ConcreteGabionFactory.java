package model.inventory.factory;

import model.grid.griditem.Coord;
import model.gui.component.ComponentPosition;
import model.gui.touch.Touch;

/**
 * 
 * @author eric
 *
 */

public class ConcreteGabionFactory extends TowerFactory {
	
	private int concrete;

	public ConcreteGabionFactory(ComponentPosition topLeft, int width, int height) {
		super(topLeft, width, height);
		concrete = 3;
	}
	
	public ConcreteGabionFactory(int x, int y, int width, int height){
		super(x, y, width, height);
		concrete = 3;
	}
	
	@Override
	public void mouseClicked(int mouseX, int mouseY){
		// If applicable, clamp new tower to touch
		if(concrete > 0){
			concrete -= 1;
			Touch.clamp(new ConcreteGabion(new Coord(topLeft.getX(), topLeft.getY())));
		}
	}
	
	@Override
	public void mouseReleased(int mouseX, int mouseY){
		// Do nothing
		Touch.snap();
	}

}