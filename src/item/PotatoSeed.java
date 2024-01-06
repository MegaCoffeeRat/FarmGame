package item;

import core.Images;
import world.entity.plant.crop.Corn;
import world.entity.plant.crop.Crop;
import world.entity.plant.crop.Potato;

public class PotatoSeed extends CropSeed{
	
	
	PotatoSeed()
	{
		img = Images.PotatoSeed;
	}
	
	
	public Crop makeCrop()
	{
		return new Potato();
	}

}
