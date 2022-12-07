package se.umu.cs.emli;

import se.umu.cs.apjava.bakery.Cake;

/**
 * Decorator for Class Cake to add sprinkles to cake.
 * The text "with sprinkles" is added to the cake description and
 * the cost for an extra large cake is 2 extra.
 * @author Emmy Lindgren, id19eln.
 */

public class SprinkledCake extends Cake {
    Cake cake;
    public SprinkledCake(Cake cake){
        this.cake = cake;
    }
    @Override
    public String getDescription() {
        return cake.getDescription() + " with sprinkles";
    }
    @Override
    public int getCost() {
        return cake.getCost() + 2;
    }
}
