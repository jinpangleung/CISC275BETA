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
		defaultComponent = new DefaultComponent(0, 0, screenWidth, screenHeight);
		componentMapping = new ComponentMapping(defaultComponent, screenWidth, screenHeight);
		Animation.initialize();
		touch = new Touch();
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		double offset = (double) screenHeight * 0.1;
		double width = (double) screenHeight * 0.8;
		this.grid = new Grid(new ComponentPosition((int) offset, (int) offset), (int) width, (int) width);
		this.componentMapping.addComponent(grid);
		this.player = new Player();
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
