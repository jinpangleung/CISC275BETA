package model.inventory.factory;

import model.gui.component.Component;
import model.gui.component.ComponentPosition;

/**
 * TowerFactory
 * an abstract class of factory that creates towers
 * 
 * @author eric
 *
 */

public abstract class TowerFactory extends Component {
	
	private int towerCount;
	
	public TowerFactory(ComponentPosition topLeft, int width, int height){
		super(topLeft, width, height);
	}
	
	public TowerFactory(int x, int y, int width, int height){
		super(x, y, width, height);
	}
	
	@Override
	public void mouseClicked(int mouseX, int mouseY){
		// If applicable, clamp new tower to touch
	}
	
	@Override
	public void mouseReleased(int mouseX, int mouseY){
		// Do nothing
	}
	
	public void increaseTowerCount(){
		towerCount++;
	}
	
	

}
