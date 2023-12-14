package world;

import org.newdawn.slick.Graphics;

import core.Main;
import world.entity.Entity;
import world.terrain.Dirt;
import world.terrain.Terrain;

public class Cell {
	private int x;
	private int y;
	private static int bar;
	private Terrain terrain;
	private Entity entity;

	
	public Cell(int x, int y)
	{
		bar = 128;
		this.x = x;
		this.y = y;
		setTerrain(new Dirt(false, false));
	}
	
	public boolean hasEntity()
	{
		return entity != null;
	}
	
	
	public void nextDay()
	{
		terrain.nextDay();
	}
	
	public void setTerrain(Terrain t)
	{
		terrain = t;
		terrain.setCell(this);
	}
	
	public static int getWidth() {
		return Main.getScreenWidth() / World.WIDTH;
	}
	
	public static int getHeight() {
		return (Main.getScreenHeight() -bar) / World.HEIGHT;
	}
	
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	
	public Terrain getTerrain()
	{
		return terrain;
	}
	
	public void render(Graphics g)
	{
		terrain.render(g);
	}
	public void clicked()
	{
		terrain.clicked();
	}
	
	public void getEntity()
	{
		
	}
	public void setEntity(Entity e)
	{
		
	}


}
