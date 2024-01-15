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
    private ItemBar itemBar;
    
    
    private int xPosition = 50; // Adjust as needed
    private int startYPosition = 100; // Adjust as needed
    private int yPosition;
    
    private ArrayList<Item> shopItems = new ArrayList<>();

    public Shop(int id) {
    	this.id = id;
    	
    	shopItems.add(new Bucket());
    	shopItems.add(new Hoe());
    	shopItems.add(new CornSeed());
    	
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
        
        
       
        
        
        for (int i = 0; i < shopItems.size(); i++) {
            Item item = shopItems.get(i);

            // Reset yPosition for each item
            yPosition = startYPosition + i * 20;

            // Display index + 1, item name, and item cost
            g.setColor(Color.white);
            g.drawString((i + 1) + ". " + item.getName() + " - $" + item.getCost(), xPosition, yPosition);
        }
        renderDays(g);
        renderMoney(g);
        Game.getItems().render(g);
        
        
    }
    
    public void renderDays(Graphics g) {
        g.setFont(Fonts.big);
        g.setColor(Color.white);
        
        // Use the accessor to get the current day from Game class
        g.drawString("Days: " + World.days(), 100, 50);
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
        return 2; // You can return a unique ID for this state
    }
    
    public void keyPressed(int key, char c)
    {
        // This code happens every time the user presses a key
    	if(key == Input.KEY_E) {
    	sbg.enterState(Main.GAME_ID);
    	}
    	
    	
    	if (key >= Input.KEY_1 && key <= Input.KEY_9) {
            // Calculate the index based on the key's position in items
            int index = key - Input.KEY_1;

            // Check if the index is within the bounds of your ArrayList
            if (index >= 0 && index < shopItems.size()) {
                Item selectedItem = shopItems.get(index);

                // Check if the player has enough money and has space in the item bar
                if (Game.getMoney() >= selectedItem.getCost() && Game.getItems().hasSpace()) {
                    // Create a copy of the original item by calling buildItem
                    Item copiedItem = buildItem(selectedItem.getClass());

                    // Call buyItem() with the copied item as the parameter
                    buy(copiedItem);
                }
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
    
    public void buy(Item item) {
    	ItemBar itemBar = Game.getItems();

        // Check if there is space in the ItemBar
        if (itemBar.hasSpace()) {
            // Check if the player has enough money to buy the item
            if (Game.getMoney() >= item.getCost()) {
                // Spend the player's money based on the item's cost
                Game.spendMoney(item.getCost());

                // Add the item to the ItemBar
                itemBar.addItem(item);
            } else {
                // Handle not enough money logic (e.g., display a message)
                System.out.println("Not enough money to buy " + item.getName());
            }
        } else {
            // Handle no space in ItemBar logic (e.g., display a message)
            System.out.println("ItemBar is full, cannot add more items.");
        }
    }
    
    
    
    
    
}
