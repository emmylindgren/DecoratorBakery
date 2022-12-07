package se.umu.cs.emli;

import se.umu.cs.apjava.bakery.Cake;

/**
 *  Implementation of Class Cake to make a Strawberry cake.
 *  The text "Strawberry cake" is set to the cake description and
 *  the cost for a strawberry cake is double the cake price.
 *  @author Emmy Lindgren, id19eln.
 */
public class StrawberryCake extends Cake {
    @Override
    public String getDescription() {
        return "Strawberry cake";
    }
    @Override
    public int getCost() {
        return 2 * super.getCost();
    }
}
