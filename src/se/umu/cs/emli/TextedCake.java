package se.umu.cs.emli;

import se.umu.cs.apjava.bakery.Cake;

/**
 * Decorator for Class Cake to add text to the cake.
 * The text is added to the cake description and the cost for an extra large cake is 1 extra.
 * @author Emmy Lindgren, id19eln.
 */
public class TextedCake extends Cake {
    private final Cake cake;
    private final String text;
    public TextedCake(Cake cake, String text){
        this.cake = cake;
        this.text = text;
    }
    @Override
    public String getDescription() {
        return cake.getDescription() + " with text: " + "\"" + text + "\"";
    }
    @Override
    public int getCost() {
        return cake.getCost() + 1;
    }

}
