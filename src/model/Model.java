package model;

import java.awt.Graphics;

import model.drawing.Animation;
import model.grid.Grid;
import model.grid.griditem.trailitem.TrailItem;
import model.gui.component.*;
import model.gui.touch.Touch;
import model.inventory.Inventory;

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
	private int screenWidth;
	private int screenHeight;
	private Grid grid;
	private Inventory inventory;
	private Player player;
	private Storm storm;
	private int stormNum;
	
	
	public void initialize(int screenWidth, int screenHeight){
		System.out.println("\tModel is being initialized");
		// Initialize component mapping
		defaultComponent = new DefaultComponent(0, 0, screenWidth, screenHeight);
		componentMapping = new ComponentMapping(defaultComponent, screenWidth, screenHeight);
		// Initialize Animation
		Animation.initialize();
		// Initialize Touch
		touch = Touch.getInstance();
		// Initialize Grid component
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		int xOffset = (int) (screenWidth * .05);
		int yOffset = (int) (screenHeight * .1);
		int xSize = (int) (screenWidth * .7);
		int ySize = (int) (screenHeight * .8);
		this.grid = new Grid(new ComponentPosition(xOffset, yOffset), xSize, ySize);
		this.componentMapping.addComponent(grid);
		// Initialize Player
		this.player = Player.getInstance();
		// Initialize Storm
		this.storm = new Storm();
		this.stormNum = 0;
		System.out.println("\tModel has been initialized");
	}
	
	public void update(long timeElapsed){
		grid.update(timeElapsed);
		player.update(timeElapsed);
		if (player.getGameTime()/1000000000 - stormNum == 1){
			storm.dealDamage();
			stormNum++;
		}
	}
	
	public void draw(Graphics g){
		grid.draw(g);
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
