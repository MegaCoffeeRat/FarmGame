package item;

import java.util.ArrayList;

public class ItemBar {
	public ArrayList<Item> items = new ArrayList<Item>(); 

	public ItemBar()
	{
		items.add(new PotatoSeed());
		items.add(new PotatoSeed());
	
		items.add(new CornSeed());
		items.add(new CornSeed());
		
	}
	
	
}
