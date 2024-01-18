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
	
	public static Image Title;
	public static Image scaledTitle;
	
	
	public static Image Shop;
	public static Image Rock;
	
	public static Image pineTree;
	
	
	
	public static void loadImages()
	{
		try
		{
			//main png's
			dirt = new Image("res/images/terrain/dirt.png");
			grass = new Image("res/images/terrain/grass.png");
			gray = new Image("res/images/terrain/gray.png");
			drySoil = new Image("res/images/terrain/drySoil.png");
			wetSoil = new Image("res/images/terrain/wetSoil.png");
			water = new Image("res/images/terrain/water.png");
			
			//crops
			corn = new SpriteSheet("res/images/crops/corn.png", 32,48,0);
			potato = new SpriteSheet("res/images/crops/potato.png", 32,48,0);
			
			//seeds
			CornSeed = new Image("res/images/items/cornSeed.png");
			PotatoSeed = new Image("res/images/items/potatoSeed.png");

			
			Hoe = new Image("res/images/items/hoe.png");
			Bucket = new Image("res/images/items/bucketFull.png");
			
//			Title = new Image("res/TitleSreen.png");
			
			
			Rock = new Image("res/images/nature/rock.png");
			
			pineTree = new Image ("res/images/nature/Tree.png");
			
			
			
			
			
		
		
			
			
			
		}
		catch(SlickException e )
		{
			e.printStackTrace();
		}
	}
	
	

}
