package core;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Title {
	protected Image img;
	
	Title()
	{
		img = Images.Title;
	}
	
	void render()
	{
		img.draw(0,0);
	}

}
