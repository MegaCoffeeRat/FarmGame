package core;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import item.ItemBar;
import world.Cell;
import world.World;

public class Game extends BasicGameState {
	private int id;
	private World world;
	public static int barSpace;
	private static int money = 100;
	private static ItemBar itemBar;
	public static GameContainer gc;
	public static int lifeTimeScore;

	private static int curStamina;
	private static int maxStamina;
	public static final int BASE_STAMINA = 100;

	public static int lifetimeEarnings = 0;

	private StateBasedGame sbg;

	public static int days;

	public Game(int id) {
		this.id = id;
	}

	public int getID() {
		return id;
	}

	public static ItemBar getItems() {
		if (itemBar == null) {
			itemBar = new ItemBar();
		}
		return itemBar;
	}

	public static ItemBar getItemBar() {
		if (itemBar == null) {
			itemBar = ItemBar.getInstance();
		}
		return itemBar;
	}

	public static boolean hasStamina(int amount) {
		return curStamina >= amount;
	}

	public static float getPercentStamina() {
		return (float) curStamina / maxStamina;
	}

	public static void expendStamina(int amount) {
		if (hasStamina(amount) == true) {
			curStamina -= amount;
		}
	}

	public void resetStamina() {
		curStamina = maxStamina;
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		this.gc = gc;
		this.sbg = sbg;
		maxStamina = BASE_STAMINA;
		curStamina = BASE_STAMINA;

		Fonts.loadFonts();
		Images.loadImages();

		gc.setShowFPS(false);
		world = new World();
		itemBar = new ItemBar();

	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		// This is updates your game's logic every frame. NO DRAWING.

	}

	public static int getMoney() {
		return money;
	}

	public static int getCurrentDay() {
		return days;
	}

	public static void renderScore(Graphics g) {
//		g.setFont(Fonts.big);
		g.setColor(Color.yellow);
		g.drawString("Score: " + lifeTimeScore, Main.getScreenWidth() - (Main.getScreenWidth() / 7),
				Main.getScreenHeight() - (Main.getScreenHeight() / 9));

	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// This code renders shapes and images every frame.

		int x = gc.getInput().getMouseX();
		int y = gc.getInput().getMouseY();

		world.render(g, x, y);
		renderMoney(g);
		world.cleanup();
		itemBar.render(g);
		renderStamina(g);
		renderDays(g);
		renderScore(g);

		System.out.println(curStamina);

	}

	public void renderDays(Graphics g) {
		g.setFont(Fonts.big);
		g.setColor(Color.black);
		g.drawString("Days:  " + World.days, Main.getScreenWidth() - (Main.getScreenWidth() / 8),
				Main.getScreenHeight() / 10);
	}

	public void renderMoney(Graphics g) {
		g.setFont(Fonts.big);
		g.setColor(Color.black);
		g.drawString("$ " + money, 20, 50);
		g.setColor(Color.white);
		g.drawString("$ " + money, 20, 50);
	}

	public void renderStamina(Graphics g) {
		g.setColor(new Color(0, 0, 100));
		g.fillRect(0, Cell.getHeight() * World.HEIGHT, Main.getScreenWidth(), 10);

		g.setColor(new Color(1 - getPercentStamina(), getPercentStamina(), 0));
		g.fillRect(0, Cell.getHeight() * World.HEIGHT, Main.getScreenWidth() * getPercentStamina(), 10);

	}

	public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException {
		// This code happens when you enter a gameState.
	}

	public void leave(GameContainer gc, StateBasedGame sbg) {
		// This code happens when you leave a gameState.
	}

	public void keyPressed(int key, char c) {
		// This code happens every time the user presses a key
		if (key == Input.KEY_SPACE) {
			world.nextDay();
			resetStamina();
		} else if (key == Input.KEY_E) {
			// Switch to Shop state
			sbg.enterState(Main.SHOP_ID);

			// Tell items to clear selection and set cursor
			itemBar.clearSelection();
			itemBar.setCursor();
		}
		itemBar.keyPressed(key, c);
	}

	public void mousePressed(int button, int x, int y) {

//		int mouseX = gc.getInput().getMouseX();
//		int mouseY = gc.getInput().getMouseY();
		// This code happens every time the user presses the mouse
		world.mousePressed(button, x, y, itemBar.getSelectedItem());
		world.cleanup();
		itemBar.cleanup();
	}

	public static void gainMoney(int amount) {
		money += amount;
		lifeTimeScore += amount;
	}

	public static void spendMoney(int amount) {
		money -= amount;
	}

	public static boolean hasMoney(int amount) {
		return (money > 0);
	}

}
