package se.umu.cs.emli;

import se.umu.cs.apjava.bakery.Cake;

public class TextedCake extends Cake {
    private Cake cake;
    private String text;

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
