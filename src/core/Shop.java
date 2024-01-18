package core;

import java.util.ArrayList;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import item.Bucket;
import item.CornSeed;
import item.Hoe;
import item.Item;
import item.ItemBar;
import item.PotatoSeed;
import world.World;




public class Shop extends BasicGameState {
    
    private Image Shop;
    private int id;
    private StateBasedGame sbg;
    int selectedIndex = -1;
    
    
    private int xPosition = 50; // Adjust as needed
    private int startYPosition = 100; // Adjust as needed
    private int yPosition;
    
    private ArrayList<Item> shopItems = new ArrayList<>();

    public Shop(int id) {
    	this.id = id;
    	
    	
    	shopItems.add(new PotatoSeed());
    	shopItems.add(new CornSeed());
    	shopItems.add(new PotatoSeed());
    	shopItems.add(new PotatoSeed());
    	
    	
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        Shop = new Image("/res/images/background/shopScreen.png").getScaledCopy(Main.getScreenWidth(), Main.getScreenHeight());
        this.sbg = sbg;
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        // Draw the title image at the center of the screen
        Shop.draw((Main.getScreenWidth() - Shop.getWidth()) / 2, (Main.getScreenHeight() - Shop.getHeight()) / 2);
        renderDays(g);
        renderMoney(g);
        renderWares(g);
        Game.getItems().render(g);
        Game.renderScore(g);
    }
    
    public void renderDays(Graphics g) {

		g.setFont(Fonts.big);
		g.setColor(Color.white);
		g.drawString("Days:  " + World.days, Main.getScreenWidth() - (Main.getScreenWidth()/8), Main.getScreenHeight()/10 );
    }

    public void renderMoney(Graphics g) {
        g.setFont(Fonts.big);
        g.setColor(Color.white);
        g.drawString("$ " + Game.getMoney(), 20, 50);
        g.setColor(Color.white);
        g.drawString("$ " + Game.getMoney(), 20, 50);
    }
    
    

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        // You can add update logic here if needed
    }

    @Override
    public int getID() {
        return 2;
    }
    
    public void keyPressed(int key, char c)
    {
         int index = key - Input.KEY_1;

        if(key == Input.KEY_E) {
            sbg.enterState(Main.GAME_ID);
        }

        if(index >= 0 && index < shopItems.size())
        {
            if(index == selectedIndex)
            {
                selectedIndex = -1;
            } else
            {
                selectedIndex = index;
            }
        }

        if(index > 0 && index <= shopItems.size())
        {

            if(Game.hasMoney(shopItems.get(index - 1).getCost()) && Game.getItems().hasSpace())
            {
                Item original = shopItems.get(index);
                Item newitem = buildItem(original.getClass());
                buy(newitem);
            }
        }
    }
    	
    
        
    
    public Item buildItem(Class<? extends Item> clazz)
    {
    	Item i = null;
    	try
    	{
    		i = clazz.getDeclaredConstructor().newInstance();
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
    	return i;
    }
    
    public void buy(Item i) {
        if (Game.hasMoney(i.getCost())) {
            Game.spendMoney(i.getCost());
            Game.getItems().addItem(i);
        }
    }
    
    
    public void renderWares(Graphics g)
    {
    	 for (int i = 0; i < shopItems.size(); i++) {
             Item item = shopItems.get(i);

             // Reset yPosition for each item
             yPosition = startYPosition + i * 40 + 10;

             g.setColor(Color.white);
             g.drawString((i + 1) + ". " + item.getName() + " - $" + item.getCost(), 50, yPosition);
             
         } 
    }
    
    
    
    
}
