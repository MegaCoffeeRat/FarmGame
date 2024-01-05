package item;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;

public class ItemBar {
	public ArrayList<Item> items = new ArrayList<Item>(); 

	public ItemBar()
	{
		items.add(new PotatoSeed());
		items.add(new PotatoSeed());
		items.add(new CornSeed());
		items.add(new CornSeed());
		
	}
	
	
	public void render(Graphics g)
	{
		 for(int i = 0; i<items.size(); i++)
		 
		 {
			 items.get(i).render(g, -1);
		 }
	}
	
	
}
