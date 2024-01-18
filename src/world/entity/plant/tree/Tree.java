// Tree class
package world.entity.plant.tree;

import core.Game;
import world.entity.Entity;
import world.terrain.Grass;
import world.terrain.Terrain;

abstract public class Tree extends Entity {

    protected int daysGrown;

    public Tree(int daysGrown) {
        this.daysGrown = daysGrown;
        setHealth();
        focus = true;
    }

    // Method to set health based on daysGrown
    protected void setHealth() {
        maxHealth = 5 + daysGrown; // Adjust this formula based on your requirements
        curHealth = maxHealth;
    }

    @Override
    public void nextDay() {
        // When a tree grows, it heals all damage done to it on previous days
        curHealth = maxHealth;
    }

    @Override
    public boolean isValid(Terrain t) {
        // Trees only consider grass to be valid terrain
        return t instanceof Grass;
    }

    @Override
    public void clicked() {
        // When clicked...

        // If the player has enough Stamina...
        if (Game.hasStamina(1)) {
            // The player expends stamina.
            Game.expendStamina(1);

            // A tree loses health.
            curHealth--;

            // If it is out of health...
            if (curHealth <= 0) {
                // Remove it
                cell.removeEntity();

                // The player gains money equal to its value times its maximum health
                Game.gainMoney(value * maxHealth);
            }
        }
    }
}
