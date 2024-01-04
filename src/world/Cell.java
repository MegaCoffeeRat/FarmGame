package world;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import core.Main;
import world.entity.Entity;
import world.entity.plant.crop.Crop;
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
	

	public void removeEntity()
	{
		if(entity != null)
		{
			entity.setCell(null);
			entity = null;
		}
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
		if(entity !=null && entity instanceof Crop && ((Crop) entity).isMature())
		{
			g.setColor(Color.white);
			g.setLineWidth(2);
			g.drawRect(getX()*getWidth(), getY()*getHeight(), getWidth()-4, getHeight()-4);
			g.resetLineWidth();
		}
	}
	public void clicked()
	{
		
		
		if(entity!=null && entity.isFocus())
		{
			entity.clicked();
		}
		else {
		terrain.clicked();
		}
	}
	
	public Entity getEntity()
	{
		return entity;
	}
	public void setEntity(Entity e)
	{
		entity = e;
		entity.setCell(this);
	}

	
// garbage method	
//	public void click_entity()
//	{
//		if(entity != null)
//		{
//			entity.clicked();
//		}
//	}


}
