package item;

import core.Images;
import world.entity.plant.crop.Corn;
import world.entity.plant.crop.Crop;

public class CornSeed extends CropSeed {

	CornSeed()
	{
		img = Images.CornSeed;
	}
	
	public Crop makeCrop()
	{
		return new Corn();
	}
}
