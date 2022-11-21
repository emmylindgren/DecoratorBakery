package se.umu.cs.emli;

import se.umu.cs.apjava.bakery.Cake;

public class StrawberryCake extends Cake {
    @Override
    public String getDescription() {
        return "Strawberry cake";
    }
    @Override
    public int getCost() {
        return 2*super.getCost();
    }
}
