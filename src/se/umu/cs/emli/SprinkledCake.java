package se.umu.cs.emli;

import se.umu.cs.apjava.bakery.Cake;

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
