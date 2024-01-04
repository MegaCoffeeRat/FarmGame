package world.entity.plant.crop;

import org.newdawn.slick.Color;

import core.Images;
import world.terrain.Dirt;




public class Potato extends Crop{
	
	public Potato()
	{
		maturity = 10;
		sheet = Images.potato;
		setImage();
		value = 5;
	}
    
}
