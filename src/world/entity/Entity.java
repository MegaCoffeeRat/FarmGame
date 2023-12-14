package world.entity;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import world.Cell;
import world.terrain.Terrain;

abstract public class Entity {
	protected Cell cell;
	protected Color color;
	public Terrain terrain;
	public Entity()
	{
		
	}
	public void setCell(Cell c)
	{
		cell = c;
	}
	public void render(Graphics g)
	{
		g.fillOval(cell.getX(), cell.getY(), 32, 32);
		
		
	}
	
	
	
}
