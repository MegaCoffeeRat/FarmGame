package core;

import java.awt.Menu;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Main extends StateBasedGame 
{
	public final static int FRAMES_PER_SECOND = 60;
	private static AppGameContainer appgc;
	
	
	
	public static final int TITLE_ID = 0;
    public static final int GAME_ID  = 1;
    public static final int SHOP_ID = 2;
  
    
  
    private BasicGameState game;
    private BasicGameState titleState;
    private BasicGameState Shop;
	public Main(String name) 
	{
		super(name);
		
		
		game = new Game(GAME_ID);
		titleState = new Title(TITLE_ID);
		
		Shop = new Shop(SHOP_ID);
		
	}

	public static int getScreenWidth()
	{
		return appgc.getScreenWidth();
	}
	
	public static int getScreenHeight()
	{
		return appgc.getScreenHeight();
	}
	

	public void initStatesList(GameContainer gc) throws SlickException 
	{
		addState(titleState);
		addState(game);
		addState(Shop);
	
	}

	public static void main(String[] args) 
	{
		try 
		{
			appgc = new AppGameContainer(new Main("My First Project"));
			System.setProperty("org.lwjgl.opengl.Window.undecorated", "true");
		
			appgc.setDisplayMode(appgc.getScreenWidth(), appgc.getScreenHeight(), false);
			appgc.setTargetFrameRate(FRAMES_PER_SECOND);
			appgc.start();
			appgc.setVSync(true);

		} 
		catch (SlickException e) 
		{
			e.printStackTrace();
		}

	}
}