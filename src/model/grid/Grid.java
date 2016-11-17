package model.grid;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import model.drawing.Coord;
import model.grid.gridcell.Direction;
import model.grid.gridcell.GridCell;
import model.grid.gridcell.GridPosition;
import model.grid.griditem.GridItem;
import model.grid.griditem.gabion.Gabion;
import model.grid.griditem.towers.Tower;
import model.grid.griditem.trailitem.TrailItem;
import model.gui.path.Path;
import model.gui.component.Component;
import model.gui.component.ComponentPosition;
import model.moving.Acceleration;

/**
 * Grid
 * the grid is the area where the player is going to be playing on the game on
 * you can only click in the grid area plus drag and drop it on grid
 * 
 * @author Roy, Eric
 *
 */


///////////////HAS LOTS OF ERRORS, WILL DEBUG AFTER ALL CLASSES ARE IMPLEMENTED/////////////
// Fixed the errors for now, but Grid has a lot going on, will look into finishing it later - Eric
public class Grid extends Component {
	
	private Collection<GridItem> items;
	private Collection<Tower> towers;
	private Collection<TrailItem> trailItems;
	private Collection<Gabion> gabions;
	private Collection<Path> paths;
	private Difficulty difficulty;
	private PixelGrid pixelgrid;
	private Board board;
	
	static private Grid grid;
	//// Attributes ////
	
	static public Grid getInstance(){
		return grid;
	}
	
	//// Constructor ////
	public Grid(ComponentPosition cp, int width, int height){
		super(cp, width, height);
		this.items = new ArrayList<GridItem>();
		this.towers = new ArrayList<Tower>();
		this.trailItems = new ArrayList<TrailItem>();
		this.gabions = new ArrayList<Gabion>();
		this.paths = new ArrayList<Path>();
		//this.difficulty = new Difficulty();
		grid = this;
		this.board = new Board();
		this.pixelgrid = new PixelGrid();
		System.out.println(board.getSquareWidth());
		System.out.println(board.getSquareHeight());
		System.out.println(this.getTopLeft());
		System.out.println(this.getBottomRight());
		System.out.println(this.pixelgrid.squareWidth);
		System.out.println(this.pixelgrid.squareHeight);
	}
	
	public void update(long timeElapsed){
		//difficulty.update(timeElapsed);
		for(GridItem gi : items){
			gi.update(timeElapsed);
		}
	}
	
	public List<GridPosition> getSpawnPositions(){
		return board.getSpawnPositions();
	}
	
	public Coord getValidCoord(GridPosition gp){
		return pixelgrid.getValidCoord(gp);
	}
	
	/*
	public void draw(Graphics g){
		g.setColor(Color.CYAN);
		g.fillRect(this.getTopLeft().getX(), this.getTopLeft().getY(),
				this.getBottomRight().getX() - this.getTopLeft().getX(),
				this.getBottomRight().getY() - this.getTopLeft().getY());
	}
	*/
	
	private void addGridItem(GridItem gi){
		items.add(gi);
	}
	
	public void addTrailItem(TrailItem ti){
		trailItems.add(ti);
		addGridItem(ti);
	}
	
	public void addTower(Tower t){
		towers.add(t);
		addGridItem(t);
	}
	
	public void addGabion(Gabion g){
		gabions.add(g);
		addGridItem(g);
	}
	
	public void addPath(Path p){
		paths.add(p);
	}
	
	public void removePath(Path p){
		Iterator<Path> it = paths.iterator();
		while(it.hasNext()){
			Path path = it.next();
			if(p.equals(path)){
				it.remove();
				return;
			}
		}
	}
	
	//// Getters and Setters ////
	public Collection<GridItem> getItems(){
		return items;
	}
	public Collection<Tower> getTowers(){
		return towers;
	}
	public Collection<TrailItem> getTrailItems(){
		return trailItems;
	}
	public Collection<Gabion> getGabions(){
		return gabions;
	}
	
	public int getSquareWidth(){
		return board.getSquareWidth();
	}
	public int getSquareHeight(){
		return board.getSquareHeight();
	}
	
	@Override
	public void mouseClicked(int mouseX, int mouseY){
		Iterator<TrailItem> it = trailItems.iterator();
		while(it.hasNext()){
			TrailItem trailItem = it.next();
			if(trailItem.isWithin(mouseX, mouseY)){
				trailItem.click();
				return;
			}
		}
	}
	
	@Override
	public void mouseReleased(int mouseX, int mouseY){
		System.out.println("Grid " + Integer.toString(mouseX) + ", " + Integer.toString(mouseY));
		this.getGridCell(mouseX, mouseY).release(mouseX, mouseY);
	}
	
	public boolean hasTower(GridPosition gp){
		for(Tower t : towers){
			if(gp.equals(t.getGridPosition())){
				return true;
			}
		}
		return false;
	}
	
	public boolean hasGabion(GridPosition gp){
		for(Gabion g : gabions){
			if(gp.equals(g.getGridPosition())){
				return true;
			}
		}
		return false;
	}
	
	public Acceleration getAcceleration(GridPosition gridPosition, long elapsedTime) {
		Direction dir = board.getGridCell(gridPosition.getX(), gridPosition.getY()).getDirection();
		Acceleration acc = new Acceleration(0,0);
		double dg = 1/(Math.sqrt(2));
		switch(dir){
			case NORTH: acc.setY(-1);
			case NORTHEAST: acc.setY(-dg); acc.setY(dg);
			case NORTHWEST: acc.setY(-dg); acc.setX(-dg);
			case WEST: acc.setX(-1);
			case SOUTHWEST: acc.setY(dg); acc.setX(-dg);
			case SOUTH: acc.setY(1);
			case SOUTHEAST: acc.setY(dg); acc.setX(dg);
			case EAST: acc.setX(1);
			default: System.out.println("ERROR"); break;
		}
		return acc;
	}
	
	public GridCell getGridCell(int x, int y){
		System.out.println("Model:GetGridCell " + Integer.toString(x) + ", " + Integer.toString(y));
		GridPosition gp = pixelgrid.getGridCell(x, y);
		return board.getGridCell(gp);
	}
	public GridCell getGridCell(Coord coord){
		return getGridCell((int) coord.getX(), (int) coord.getY());
	}

	public int getWidthByHeight() {
		return board.getWidthByHeight();
	}
	
}
