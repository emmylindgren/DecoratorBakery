package se.umu.cs.apjava.bakery;

/**
 * Cake bake class.
 */
public abstract class Cake {
    private final int CAKE_COST = 10;

    public int getCost() {
        return CAKE_COST;
    }

    public abstract String getDescription();
}
