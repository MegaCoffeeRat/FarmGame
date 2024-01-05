package item;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import core.Game;

public class ItemBar {
	public ArrayList<Item> items = new ArrayList<Item>(); 
	public int selectedIndex = -1;
	public ItemBar()
	{
		items.add(new PotatoSeed());
		items.add(new PotatoSeed());
		items.add(new CornSeed());
		items.add(new CornSeed());
		
	}
	
	public boolean hasSelectedItem()
	{
		return selectedIndex >= 0 && selectedIndex < items.size();
	}
	
	public Item getSelectedItem()
	{
		if(hasSelectedItem()) return items.get(selectedIndex);	
		else return null;
	}
	public void clearSelection()
	{
		selectedIndex = -1;
	}

	
	
	public void render(Graphics g)
	{
		 for(int i = 0; i<items.size(); i++)
		 
		 {
			 items.get(i).render(g, i, selectedIndex);
		 }
	}
	
	
	public void keyPressed(int key, char c)
	{

		int temp = key -2;

		if(temp >= 0 && temp < items.size())
		{
			if(temp == selectedIndex)
			{
				selectedIndex = -1;
			} else
			{
				selectedIndex = temp;
			}
			setCursor();
		}
		
	}
	
	public void setCursor()
	{
		if(!hasSelectedItem())
		{
			Game.gc.setDefaultMouseCursor();
		}
		else
		{
			try
			{
				Image i = getSelectedItem().getImage().getScaledCopy(32, 32);
				Game.gc.setMouseCursor(i, 16, 16);
			}
			catch (SlickException e)
			{
				e.printStackTrace();
			} 
		}
	}
	
}
