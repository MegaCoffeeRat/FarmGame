package item;

import core.Images;
import world.entity.plant.crop.Corn;
import world.entity.plant.crop.Crop;

public class CornSeed extends CropSeed {

	public CornSeed() {
		img = Images.CornSeed;
		setName("Corn");
		setCost(4);
	}

	public Crop makeCrop() {
		return new Corn();
	}
}
