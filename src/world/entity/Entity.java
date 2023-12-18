package world.entity;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import world.Cell;
import world.terrain.Dirt;
import world.terrain.Terrain;

public abstract class Entity {

	protected Cell cell;
	protected Color color;
	public Entity()
	{
		
	}
	public abstract void nextDay();
	public abstract boolean isValid(Terrain t);
	
	public void render(Graphics g)
	{
		g.setColor(color);
		g.fillOval(cell.getX() * Cell.getWidth(), cell.getY() * Cell.getHeight(), Cell.getWidth(), Cell.getHeight());
	}
	
	public void setCell(Cell c)
	{
		cell = c;
	}
	
	
}
