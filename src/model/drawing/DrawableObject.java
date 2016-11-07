package model.drawing;

import java.awt.Graphics;

/**
 * DrawableObject
 * Any object that can be drawn
 * Drawable object contains a Coord
 * 
 * @see Coord
 * @author Eric
 *
 */

public abstract class DrawableObject {
	
	private Coord coord;
	private Animation animation;
	
	public DrawableObject(Coord coord, Animation animation){
		this.coord = coord;
		this.animation = animation;
	}
	
	public void draw(Graphics g){
		animation.draw(g, coord);
	}
	
	public void drawStatic(Graphics g){
		animation.drawStatic(g, coord);
	}
	
	public Coord getCoord(){
		return coord;
	}
	
	public void setCoord(Coord c){
		this.coord = c;
	}
	
	public void setCoord(int x, int y){
		this.coord.setX(x);
		this.coord.setY(y);
	}
	
	/* Example String
	 * DrawableObject
	 * (11.21, 198.14)
	 * [oyster_1, oyster_2, oyster_3, oyster_4]
	 * Length : 4
	 * Current Index : 2 : oyster_3
	 * Size : 128x128
	 * Offset : 63, 63
	 */
	public String toString(){
		String str = "";
		str += "DrawableObject\n";
		str += coord.toString();
		str += "\n";
		str += animation.toString();
		return str;
	}

}
