package core;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Images {
	public static Image dirt;
	public static Image grass;
	public static Image gray;
	public static Image drySoil;
	public static Image wetSoil;
	public static Image water;
	
	public static SpriteSheet corn;
	public static SpriteSheet potato;
	
	
	public static Image CornSeed;
	public static Image PotatoSeed;
	
	public static Image Hoe;
	public static Image Bucket;
	
	
	
	public static void loadImages()
	{
		try
		{
			//main png's
			dirt = new Image("res/dirt.png");
			grass = new Image("res/grass.png");
			gray = new Image("res/gray.png");
			drySoil = new Image("res/drySoil.png");
			wetSoil = new Image("res/wetSoil.png");
			water = new Image("res/water.png");
			
			//crops
			corn = new SpriteSheet("res/corn.png", 32,48,0);
			potato = new SpriteSheet("res/potato.png", 32,48,0);
			
			//seeds
			CornSeed = new Image("res/cornSeed.png");
			PotatoSeed = new Image("res/potatoSeed.png");

			
			Hoe = new Image("res/hoe.png");
			Bucket = new Image("res/bucket.png");
		
			
			
			
		}
		catch(SlickException e )
		{
			e.printStackTrace();
		}
	}
	
	

}
