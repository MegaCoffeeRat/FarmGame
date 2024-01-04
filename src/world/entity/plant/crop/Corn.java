package world.entity.plant.crop;

import org.newdawn.slick.Color;

import core.Images;

public class Corn extends Crop {
	
	public Corn()
	{
		maturity = 6;
		sheet = Images.corn;
		setImage();
		value = 7;

	}
    
}
