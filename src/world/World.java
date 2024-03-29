package world;

import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Graphics;

import core.Main;
import item.Item;
import world.entity.Entity;
import world.entity.plant.crop.Corn;
import world.entity.plant.crop.Potato;
import world.entity.plant.tree.PineTree;
import world.entity.rock.Rock;
import world.terrain.Dirt;
import world.terrain.Grass;
import world.terrain.Terrain;
import world.terrain.Water;

public class World {
	public static final int WIDTH = 30;
	public static final int HEIGHT = 15;

	public static int days = 1;

	private static Cell[][] cells;
	static ArrayList<Entity> entities = new ArrayList<Entity>();

	public World() {
		cells = new Cell[WIDTH][HEIGHT];
		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < HEIGHT; j++) {
				cells[i][j] = new Cell(i, j);
			}
		}
		readFile();

	}

	public static boolean inBounds(int x, int y) {
		return x >= 0 && x < Main.getScreenWidth() && y >= 0 && y < HEIGHT * Cell.getHeight();
	}

	public void mousePressed(int button, int x, int y, Item item) {
		x = x / Cell.getWidth();
		y = y / Cell.getHeight();

		if (inBounds(x, y)) {
			cells[x][y].clicked(item);
		}
	}

	public void setTerrain(Cell cell, char code) {
		if (code == '.') {
			cell.setTerrain(new Grass());
		} else if (code == ',') {
			cell.setTerrain(new Dirt(false, false));
		} else if (code == '[') {
			cell.setTerrain(new Dirt(true, false));
		} else if (code == '~') {
			cell.setTerrain(new Water());
		}

	}

	public void nextDay() {
		days = days + 1;
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).nextDay();
		}
		for (int j = 0; j < HEIGHT; j++) {
			for (int i = 0; i < WIDTH; i++) {
				cells[i][j].nextDay();

			}
		}

	}

	public static int days() {
		return days;
	}

	public void cleanup() {
		for (int i = entities.size() - 1; i >= 0; i--) {
			if (entities.get(i).isExpired()) {
				entities.remove(i);
			}
		}
	}

	public void readFile() {
		try {
			File mapFile = new File("maps/map1.txt");
			Scanner scan = new Scanner(mapFile);

			for (int j = 0; j < HEIGHT; j++) {
				String row = scan.nextLine();

				for (int i = 0; i < WIDTH; i++) {
					char input = row.charAt(i);
					setTerrain(cells[i][j], input);

					if (input == 'r') {
						// If found, add a Rock entity to that cell
						addEntity(new Rock(), i, j);
					}

					if (input == 't') {
						// If found, set the terrain to grass
						setTerrain(cells[i][j], '.');

						// Add a PineTree entity to that cell with full maturity
						addEntity(new PineTree(5, true), i, j);
					} else {
						// Set the terrain based on the character in the map file
						setTerrain(cells[i][j], input);
					}
				}

			}
		} catch (FileNotFoundException e) {
			System.out.println("Cannot Find File!");
		}
	}

	public void render(Graphics g, int mouseX, int mouseY) {
		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < HEIGHT; j++) {
				cells[i][j].render(g, mouseX, mouseY); // Pass mouse coordinates to the render method
			}
		}
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(g);
		}
	}

	public static void addEntity(Entity e, int x, int y) {
		if (e.isValid(cells[x][y].getTerrain())) {
			entities.add(e);
			cells[x][y].setEntity(e);
		}
	}

}
