package world.entity;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import world.Cell;
import world.terrain.Dirt;
import world.terrain.Terrain;

public abstract class Entity {

	protected Image image;
	protected Cell cell;
	protected int value;
	protected boolean expired;
	protected boolean focus;
	protected int curHealth;
	protected int maxHealth;
	protected int damageTimer;
	protected boolean damaged;
	protected final int DAMAGE_EFFECT_DURATION = 100;

	public void takeDamage(int amount) {
		curHealth -= amount;

		// Set damageTimer to zero
		damageTimer = 0;

		// Set damaged to true
		damaged = true;

		if (curHealth < 0) {
			curHealth = 0;
		}
	}

	public Entity() {

	}

	public abstract void nextDay();

	public abstract boolean isValid(Terrain t);

	public boolean isFocus() {
		return focus;
	}

	public void render(Graphics g) {
		int w = Cell.getWidth();
		int h = Cell.getHeight();
		image.draw(cell.getX() * w, cell.getY() * h - h / 2, w, h * 1.5f);

		damageTimer++;
		if (damaged && damageTimer < DAMAGE_EFFECT_DURATION) {
			image.setImageColor(1, .6f, .4f);
		} else {
			image.setImageColor(1, 1, 1);
		}
	}

	public void setCell(Cell c) {
		cell = c;
	}

	public int getValue() {
		return value;
	}

	public boolean isExpired() {
		return expired;
	}

	abstract public void clicked();

}
