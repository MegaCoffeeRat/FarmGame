 package item;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import core.Game;

public class ItemBar {
    private static ItemBar instance;

	public ArrayList<Item> items = new ArrayList<Item>(); 
	public int selectedIndex = -1;
	public int MAX_ITEMS = 10;
	public ItemBar()
	{
		items.add(new Hoe());
		items.add(new Bucket());
		
		
	}
	
	
	  public static ItemBar getInstance() {
	        if (instance == null) {
	            instance = new ItemBar();
	        }
	        return instance;
	    }

	    // Getter for items
	    public ArrayList<Item> getItems() {
	        return items;
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
	public boolean hasSpace()
	{
		return items.size() < MAX_ITEMS;
	}
	
	public void addItem(Item item) {
        if (hasSpace()) {
            items.add(item);
        }
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
	
	public void cleanup()
	{
		for(int i = 0; i < items.size(); i++)
		{
			if(items.get(i).IsExpired()){
				{
					if(selectedIndex == i)
					{
						selectedIndex = -1;
						setCursor();
					}
					items.remove(i);
					i--;
				}
			}
		}
	}


	
	
	
}
