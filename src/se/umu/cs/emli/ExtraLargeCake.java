package se.umu.cs.emli;

import se.umu.cs.apjava.bakery.Cake;

public class ExtraLargeCake extends Cake {
    private Cake cake;

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
