// PineTree class
package world.entity.plant.tree;

import world.terrain.Terrain;
import core.Images;

public class PineTree extends Tree {

    private boolean fullyGrown;

    public PineTree(int maturity, boolean fullyGrown) {
        super(maturity);
        this.fullyGrown = fullyGrown;
        maturity = 5; // Adjust this value based on your requirements
        setSheet();
        value = (10); // Adjust the value based on your requirements
        image = Images.pineTree;
        setHealth();
    }

    private void setSheet() {
        // Implement logic to set the sheet based on maturity or growth stage
        // Example: sheet = fullyGrown ? Images.fullyGrownPineTreeSheet : Images.growingPineTreeSheet;
    }

    @Override
    public void nextDay() {
        super.nextDay();
        // Additional logic for PineTree's next day (if needed)
    }

    @Override
    public boolean isValid(Terrain t) {
        // Additional logic for PineTree's valid terrain (if needed)
        return super.isValid(t);
    }

    @Override
    public void clicked() {
        // Additional logic for PineTree's clicked action (if needed)
        super.clicked();
    }
}
