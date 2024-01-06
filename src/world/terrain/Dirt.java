package world.terrain;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;

import core.Game;
import core.Images;
import item.Bucket;
import item.CropSeed;
import item.Hoe;
import item.Item;
import item.ItemBar;
import world.World;
import world.entity.plant.crop.Crop;

public class Dirt extends Terrain {
	boolean soil = false;
	boolean wet = false;
	private ItemBar itembar;
	public Dirt(boolean soil, boolean wet)
	{
		this.soil = soil;
		this.wet = wet;
		setImage();
	}
	public void setImage()
	{
		if(soil && wet)
		{
			img = Images.wetSoil;
		}
		else if(soil)
		{
			img = Images.drySoil;
		}
		else
		{
			img = Images.dirt;
		}
	}
	@Override
	public void nextDay() {
		if(wet)
		{
			wet = false;
			setImage();
		}
		else
		{
			setImage();
		}
	}
	@Override
	public void clicked(Item item)
	{
		if(soil && !cell.hasEntity() && item instanceof CropSeed)
		{
			Crop c = ((CropSeed) item).makeCrop();
			World.addEntity(c, cell.getX(), cell.getY());
			item.expire();
			Game.expendStamina(2);
		}
		if(!soil && item instanceof Hoe)
		{
			soil = true;
			Game.expendStamina(5);
		}
		else if(soil && !wet && item instanceof Bucket)
		{
			wet = true;
			Game.expendStamina(5);
		}
		setImage();
	}
	
	
	
	public boolean isSoil()
	{
		return soil;
	}
	public boolean isWet()
	{
		return wet;
	}
	
	

	
}
