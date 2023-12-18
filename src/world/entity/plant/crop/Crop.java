package world.entity.plant.crop;

import world.entity.plant.Plant;
import world.terrain.Dirt;
import world.terrain.Terrain;

public abstract class Crop extends Plant {

	public Crop()
	{
		
	}
	
	public boolean isValid(Terrain t)
	{
		return t instanceof Dirt && ((Dirt) t).isSoil();
	}
	
	public void nextDay()
	{
		Dirt d = (Dirt) cell.getTerrain();
		
		if(d.isSoil() && d.isWet())
		{
			daysGrown++;
		}
	}
}
