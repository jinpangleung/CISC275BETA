package model.inventory.factory;

import model.grid.griditem.Coord;
import model.grid.griditem.tower.BlueTower;
import model.gui.component.ComponentPosition;
import model.gui.touch.Touch;

/**
 * 
 * @author eric
 *
 */

public class BlueTowerFactory extends TowerFactory {
	
	private int remainingBlueTower;

	public BlueTowerFactory(ComponentPosition topLeft, int width, int height) {
		super(topLeft, width, height);
		remainingBlueTower = 2;
	}
	
	public BlueTowerFactory(int x, int y, int width, int height){
		super(x, y, width, height);
		remainingBlueTower = 2;
	}
	
	@Override
	public void mouseClicked(int mouseX, int mouseY){
		// If applicable, clamp new tower to touch
		if(remainingBlueTower > 0){
			remainingBlueTower -= 1;
			Touch.clamp(new BlueTower(new Coord(topLeft.getX(), topLeft.getY())));
		}
	}
	
	@Override
	public void mouseReleased(int mouseX, int mouseY){
		// Do nothing
		Touch.snap();
	}

}