package world.terrain;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import core.Images;
import world.Cell;

abstract public class Terrain {
	protected Cell cell;
	protected Image img;
	
	public Terrain()
	{
		img = Images.gray;
	}
	public void setCell(Cell c)
	{
		cell = c;
	}
	public void render(Graphics g)
	{
		int w = Cell.getWidth();
		int h = Cell.getHeight();
		
		img.draw(cell.getX()*w, cell.getY()*h, w, h);
	}
	
	
	abstract public void nextDay();
	abstract public void clicked();

}
