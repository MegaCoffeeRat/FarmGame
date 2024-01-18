package world.entity.rock;

import core.Game;
import core.Images;
import world.entity.Entity;
import world.terrain.Terrain;

public class Rock extends Entity{
	
	
	public Rock()
	{
		focus = true;
		image = Images.Rock;
		value = 1;
		maxHealth = 5;
		curHealth = 5;
		
	}

	@Override
	public void nextDay() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(Terrain t) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void clicked() {
        // When clicked...

        // If the player has enough Stamina...
        if (Game.hasStamina(1)) {
            // The player expends stamina.
            Game.expendStamina(1);

            // A rock loses health.
            curHealth--;

            // If it is out of health...
            if (curHealth <= 0) {
                // Remove it from the cell
                cell.removeEntity();

                // Set the rock as expired
                expired = true;

                // Player gains money equal to its value
                Game.gainMoney(value);
            }
        }
    }

}
