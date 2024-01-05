package item;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import core.Fonts;
import core.Main;
import world.Cell;

abstract public class Item {
	protected Image img;
	
	public Item()
	{
		
	}
	
	
	public void render(Graphics g, int index, int selectedIndex)
	{
		int x = (index * 96) + 48;
		int y = (Main.getScreenHeight() - Cell.bar) + 32;
		
		img.draw(x,y, 64, 64);
		g.setFont(Fonts.big);
		g.setColor(Color.white);
		g.drawString("" + (index +1),x+ 27 ,y -32);	
		
		if(index == selectedIndex)
		{
			g.drawRect(x, y, 64, 64);
		}
	}
	
	public Image getImage()
	{return img;}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
