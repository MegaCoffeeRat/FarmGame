package world.terrain;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;

import core.Images;

public class Dirt extends Terrain {
	boolean soil = false;
	boolean wet = false;
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
	public void clicked()
    {
        if(!soil)
        {
            soil = true;
        }
        else if(soil && !wet)
        {
            wet = true;
        }
        setImage();
    }
	

	
}
