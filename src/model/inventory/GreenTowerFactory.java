package model.inventory;

import model.gui.component.ComponentPosition;

/**
 * 
 * @author eric
 *
 */

public class GreenTowerFactory extends TowerFactory {
	
	private int remainingGreenTower;

	public GreenTowerFactory(ComponentPosition topLeft, int width, int height) {
		super(topLeft, width, height);
		remainingGreenTower = 2;
	}
	
	public GreenTowerFactory(int x, int y, int width, int height){
		super(x, y, width, height);
		remainingGreenTower = 2;
	}
	
	@Override
	public void mouseClicked(int mouseX, int mouseY){
		// If applicable, clamp new tower to touch
		if(remainingGreenTower > 0){
			remainingGreenTower -= 1;
			Touch.clamp(new GreenTower(new Coord(topLeft.getX(), topLeft.getY())));
		}
	}
	
	@Override
	public void mouseReleased(int mouseX, int mouseY){
		// Do nothing
		Touch.snap();
	}

}