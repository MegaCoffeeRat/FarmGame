package world.entity.plant;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import world.Cell;
import world.entity.Entity;

abstract public class Plant extends Entity {
	protected int daysGrown;
	protected int maturity;
    public Plant()
    {
    	
    }
    
    public boolean isMature()
    {
    	if(daysGrown >= maturity)
    	{
    		return true;
    	}
    	return false;
    }
    
    public float percentMaturity()
    {
    	return (float) daysGrown/maturity;
    }
    
    
    public void render(Graphics g)
    {
    	int w = Cell.getWidth();
    	int h = Cell.getHeight();
    	
    	super.render(g);
    	g.drawString("Grown: " + daysGrown, cell.getX(), cell.getY());
    	
    	
    	if(isMature())
    	{
    		g.setColor(Color.black);
    		g.setLineWidth(4);
    		g.drawOval(cell.getX()*w, cell.getY()*h, w, h);
    		g.resetLineWidth();
    	}
    	
    	
    }
}
