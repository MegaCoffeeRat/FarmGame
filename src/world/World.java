package world;

import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Graphics;

import world.entity.Entity;
import world.entity.plant.crop.Corn;
import world.entity.plant.crop.Potato;
import world.terrain.Dirt;
import world.terrain.Grass;
import world.terrain.Terrain;
import world.terrain.Water;

public class World {
	public static final int WIDTH = 30;
	public static final int HEIGHT = 15;
	
	private static Cell[][] cells;
	ArrayList<Entity> entities = new ArrayList<Entity>();

	
	public World()
	{
		cells = new Cell [WIDTH][HEIGHT];
		for(int i = 0; i<WIDTH; i++)
		{
			for(int j = 0; j<HEIGHT; j++)
			{
				cells[i][j] = new Cell(i, j);
			}
		}
		readFile();	
		
		addEntity(new Corn(), 4,0);
		addEntity(new Potato(), 0,1);
	}
	
	
	
	public boolean inBounds(int x, int y)
    {
        return x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT;
    }
	
	
	public void mousePressed(int button, int x, int y)
	{
		 x = x / Cell.getWidth();
		 y = y / Cell.getHeight();
		if(inBounds(x / Cell.getWidth() ,y / Cell.getHeight())) 
		{
			cells[x][y].clicked();
		}
	}
	public void setTerrain(Cell cell, char code)
	{
		 if(code == '.')
         {
             cell.setTerrain(new Grass());
         }
         else if(code == ',')
         {
             cell.setTerrain(new Dirt(false, false));
         }
         else if(code == '[')
        	 {
        			 cell.setTerrain(new Dirt(true, false));
        	 }
         else if(code == '~')
         {
        	 cell.setTerrain(new Water());
         }
	}
	
	
	public void nextDay()
	{
		for(int i = 0; i <entities.size(); i++)
		{
			entities.get(i).nextDay();
		}
		for(int j = 0; j < HEIGHT; j++) {
			for(int i = 0; i < WIDTH; i++)
			{
			cells[i][j].nextDay();
			}
		}
		
	}	
	
	public void readFile()
	{
		try
		{
			File mapFile = new File("maps/map1.txt");
			Scanner scan = new Scanner(mapFile);
			
			for(int j = 0; j < HEIGHT; j++)
			{
				String row = scan.nextLine();
				
				for(int i = 0; i < WIDTH; i++)
				{
					char input = row.charAt(i);
					setTerrain(cells[i][j], input);
				}
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Cannot Find File!");
		}
	}
	
	public void render(Graphics g)
	{
		for(int i = 0; i<WIDTH; i++)
		{
			for(int j = 0; j<HEIGHT; j++)
			{
				cells[i][j].render(g);
			}
		}
		for(Entity e : entities)
		{
			((world.entity.Entity) e).render(g);
		}
	}
	
	public void addEntity(Entity e, int x, int y)
	{
		if(e.isValid(cells[x][y].getTerrain()))
		{
			entities.add(e);
			cells[x][y].setEntity(e);
		}
	}
	
	
	
		
		
		
}
