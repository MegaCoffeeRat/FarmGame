package item;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import core.Fonts;
import core.Main;
import world.Cell;

abstract public class Item {
	protected Image img; 
	public boolean expired;
	
	String name;
	int cost;
	
	public Item()
	{
		
	}
	
	public String getName()
	{return name;}
	
	public int getCost()
	{return cost;}
	
	public void setName(String name)
	{this.name = name;}
	
	public void setCost(int cost)
	{this.cost = cost;}
	
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
	
	
	
	public boolean IsExpired()
	{
		return expired;
	}
	
	public void expire()
	{
		expired = true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
