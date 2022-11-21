package se.umu.cs.emli;

import se.umu.cs.apjava.bakery.Cake;

/**
 * Decorator for Class Cake to make an extra large cake.
 * The text "extra large" is added to the cake description and
 * the cost for an extra large cake is 5 extra.
 */
public class ExtraLargeCake extends Cake {
    private final Cake cake;
    public ExtraLargeCake(Cake cake){
        this.cake = cake;
    }
    @Override
    public String getDescription() {
        return cake.getDescription() + " extra large";
    }
    @Override
    public int getCost() {
        return cake.getCost() + 5;
    }
}
