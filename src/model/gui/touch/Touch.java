package model.gui.touch;

import java.awt.Graphics;
import model.drawing.DrawableObject;

/**
 * Touch
 * Touch keeps a pointer to a DrawableObject
 * Touch is exclusively used for dragging DrawableObjects around the screen
 * Touch needs to be explicitly told when to pick something up and when to drop something using clamp and unClamp
 * The Touch pointer should never be null, because Touch should be able to draw the object it's holding
 * 
 * @author Eric
 *
 */

public class Touch {
	
	private DrawableObject holding;
	private DrawableObject nullObject;
	private boolean isHolding;
	private Coord coord;
	
	public Touch(){
		nullObject = new DefaultTouchObject();
		holding = nullObject;
		isHolding = false;
	}
	
	public void mouseDragged(int mouseX, int mouseY){
		this.holding.setCoord(mouseX, mouseY);
	}
	
	public void clamp(DrawableObject objectToBeClamped){
		this.holding = objectToBeClamped;
		this. coord = obejctToBeClamped.getCoord();
	}
	
	public DrawableObject unClamp(){
		DrawableObject d = holding;
		holding = nullObject;
		return DrawableObject;
	}
	
	public void draw(Graphics g){
		holding.draw(g);
	}
	
	public DrawableObject getHolding() {
		return holding;
	}
	
	public static Coord getCoord(){
		return coord;
	} 

	public void setHolding(DrawableObject holding) {
		this.holding = holding;
	}

	public DrawableObject getNullObject() {
		return nullObject;
	}

	public void setNullObject(DrawableObject nullObject) {
		this.nullObject = nullObject;
	}

	public static boolean isHolding() {
		return isHolding;
	}

	public void setHolding(boolean isHolding) {
		this.isHolding = isHolding;
	}

	public String toString(){
		String str = "";
		str += "Touch is holding...\n";
		str += holding.toString();
		return str;
	}

}
