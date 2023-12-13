package core;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Images {
	public static Image dirt;
	public static Image grass;
	public static Image gray;
	public static Image drySoil;
	public static Image wetSoil;
	public static Image water;
	
	
	public static void loadImages()
	{
		try
		{
			dirt = new Image("res/dirt.png");
			grass = new Image("res/grass.png");
			gray = new Image("res/gray.png");
			drySoil = new Image("res/drySoil.png");
			wetSoil = new Image("res/wetSoil.png");
			water = new Image("res/water.png");
		}
		catch(SlickException e )
		{
			e.printStackTrace();
		}
	}
	
	

}
