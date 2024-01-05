package core;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import item.ItemBar;
import world.World;

public class Game extends BasicGameState 
{	
	private int id;
	private World world;
	public static int barSpace;
	private static int money;
	private ItemBar itemBar;
	public static GameContainer gc;
	
	
	
	

	

	public Game(int id) 
	{
		this.id = id;
	}
	
	public int getID() 
	{
		return id;		
	}
	
	
	
	
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException 
	{
		this.gc = gc;

		
		Fonts.loadFonts();
		Images.loadImages();

		gc.setShowFPS(false);
		world = new World();
		itemBar = new ItemBar();
		
		
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{	
		// This is updates your game's logic every frame.  NO DRAWING.


		
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException 
	{
		// This code renders shapes and images every frame.
		world.render(g);
		renderMoney(g);
		world.cleanup();	
		itemBar.render(g);
	}
	public void renderMoney(Graphics g)
	{
		g.setFont(Fonts.big);
		g.setColor(Color.black);
		g.drawString("$ " + money, 20, 50);
		g.setColor(Color.white);
		g.drawString("$ " + money, 20, 50);
	}
	
	public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException 
	{
		// This code happens when you enter a gameState.  
	}

	public void leave(GameContainer gc, StateBasedGame sbg) 
	{
		// This code happens when you leave a gameState. 
	}

	public void keyPressed(int key, char c)
	{
		// This code happens every time the user presses a key
		if(key == Input.KEY_SPACE)
		{
			world.nextDay();
		}
		itemBar.keyPressed(key, c);
	}
	
	public void mousePressed(int button, int x, int y)
	{
		// This code happens every time the user presses the mouse
		world.mousePressed(button, x, y);
		world.cleanup();
		

	}
	
	
	
	
	public static void gainMoney(int amount)
	{
		money += amount;
	}
	public static void spendMoney(int amount)
	{
		money -= amount;
	}
	public static boolean hasMoney(int amount)
	{
		return (money > 0);
	}
	
	


}
