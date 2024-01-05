package item;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import core.Main;
import world.Cell;

abstract public class Item {
	protected Image img;
	
	public Item()
	{
		
	}
	
	
	public void render(Graphics g, int index)
	{
		int x = (index * 96) + 48;
		int y = (Main.getScreenHeight() - Cell.bar) + 32;
		
		img.draw(x,y, 64, 64);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
