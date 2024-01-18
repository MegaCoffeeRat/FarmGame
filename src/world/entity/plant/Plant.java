package world.entity.plant;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SpriteSheet;

import world.Cell;
import world.entity.Entity;

abstract public class Plant extends Entity {
	protected int daysGrown;
	protected int maturity;
	protected SpriteSheet sheet;
    public Plant()
    {
    	
    }
    
    public boolean isMature()
    {
    	if(daysGrown >= maturity)
    	{
    		focus = true;
    		return true;
    		
    	}
    	return false;
    }
    
    public float percentMaturity()
    {
		return (float) daysGrown/ (float) maturity;
    }
    
    
    public void render(Graphics g)
    {
    	int w = Cell.getWidth();
    	int h = Cell.getHeight();
    	
    	super.render(g);

    }
    
    public void setImage()
    {
    	if(daysGrown == 0)
    	{
    		image = sheet.getSubImage(0, 0);
    	}
    	else if(percentMaturity() < .5)
    	{
    		image = sheet.getSubImage(1,0);
    	}
    	else if(percentMaturity() < 1)
    	{
    		image = sheet.getSubImage(2,0);
    	}
    	else
    	{
    		image = sheet.getSubImage(3, 0);
    	}
    	
    }
    
    
    
}
