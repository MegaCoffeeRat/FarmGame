package core;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Shop extends BasicGameState {
    
    private Image Shop;
    private int id;
    private StateBasedGame sbg;

    public Shop(int id) {
    	this.id = id;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        Shop = new Image("/res/ShoppeScreen.png").getScaledCopy(Main.getScreenWidth(), Main.getScreenHeight());
        this.sbg = sbg;
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        // Draw the title image at the center of the screen
        Shop.draw((Main.getScreenWidth() - Shop.getWidth()) / 2, (Main.getScreenHeight() - Shop.getHeight()) / 2);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        // You can add update logic here if needed
    }

    @Override
    public int getID() {
        return 2; // You can return a unique ID for this state
    }
    
    public void keyPressed(int key, char c)
    {
        // This code happens every time the user presses a key
    	sbg.enterState(Main.GAME_ID);

        
    }
}
