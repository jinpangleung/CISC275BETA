package model.inventory.factory;

import model.drawing.Coord;
import model.grid.griditem.towers.RedTower;
import model.gui.component.ComponentPosition;
import model.gui.touch.Touch;

/**
 * 
 * @author eric
 *
 */

public class RedTowerFactory extends TowerFactory {
	
	private int remainingRedTower;

	public RedTowerFactory(ComponentPosition topLeft, int width, int height) {
		super(topLeft, width, height);
		remainingRedTower = 2;
	}
	
	public RedTowerFactory(int x, int y, int width, int height){
		super(x, y, width, height);
		remainingRedTower = 2;
	}
	
	@Override
	public void mouseClicked(int mouseX, int mouseY){
		// If applicable, clamp new tower to touch
		if(remainingRedTower > 0){
			remainingRedTower -= 1;
			Touch.clamp(new RedTower(new Coord(topLeft.getX(), topLeft.getY())));
		}
	}
	
	@Override
	public void mouseReleased(int mouseX, int mouseY){
		// Do nothing
		Touch.snap();
	}

}
