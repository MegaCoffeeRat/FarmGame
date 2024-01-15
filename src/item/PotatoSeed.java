package item;

import core.Images;
import world.entity.plant.crop.Corn;
import world.entity.plant.crop.Crop;
import world.entity.plant.crop.Potato;

public class PotatoSeed extends CropSeed{
	
	
	public PotatoSeed()
	{
		img = Images.PotatoSeed;
		setName("Potato");
		setCost(4);
	}
	
	
	public Crop makeCrop()
	{
		return new Potato();
	}

}
