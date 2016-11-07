package model;

import java.awt.Graphics;

import model.drawing.Animation;
import model.gui.component.*;
import model.gui.touch.Touch;

/**
 * Model
 * Model holds all of the game elements
 * It should be updatable based on elapsed time since last update
 * @author Eric
 *
 */

public class Model {
	
	// Model Attributes
	private Component defaultComponent;
	private ComponentMapping componentMapping;
	private Touch touch;
	
	public void initialize(int screenWidth, int screenHeight){
		System.out.println("\tModel is being initialized");
		defaultComponent = new Component(0, 0, screenWidth, screenHeight);
		componentMapping = new ComponentMapping(defaultComponent, screenWidth, screenHeight);
		Animation.initialize();
		touch = new Touch();
		System.out.println("\tModel has been initialized");
	}
	
	public void update(long timeElapsed){
		
	}
	
	public void draw(Graphics g){
		
	}
	
	public void mouseClicked(int mouseX, int mouseY){
		componentMapping.mouseClicked(mouseX, mouseY);
	}
	
	public void mouseReleased(int mouseX, int mouseY){
		componentMapping.mouseReleased(mouseX, mouseY);
	}
	
	public void mouseDragged(int mouseX, int mouseY){
		touch.mouseDragged(mouseX, mouseY);
	}

}
