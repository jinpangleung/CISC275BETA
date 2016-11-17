package model.inventory.factory;

import java.io.Serializable;

import model.drawing.Coord;
import model.grid.griditem.towers.GreenTower;
import model.gui.component.ComponentPosition;
import model.gui.touch.Touch;

/**
 * GreenTowerFactory
 * a factory that creates greentower
 * 
 * @author eric
 *
 */

public class GreenTowerFactory extends TowerFactory implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1068159228629894456L;
	
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
	public void mouseReleased(int mouseX, int mouseY){
		
	}

}
