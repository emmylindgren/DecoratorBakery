package se.umu.cs.apjava.bakery;

import se.umu.cs.emli.ExtraLargeCake;
import se.umu.cs.emli.SprinkledCake;
import se.umu.cs.emli.TextedCake;

public class BakeryController {
    private Order currentOrder=new Order();
    private Cake currentCake;

    String printOrder() {
        StringBuilder stringBuilder=new StringBuilder();
        currentOrder.printOrder(stringBuilder);
        currentOrder=new Order();
        return stringBuilder.toString();
    }

    public void finishOrder() {
        if (currentCake!=null) {
            currentOrder.addCake(currentCake);
        }
        currentCake = null;
    }

    public void clearOrder(){
        currentCake = null;
    }

    public void addSprinkles(){
        currentCake = new SprinkledCake(currentCake);
    }

    public void extraLarge(){
        currentCake = new ExtraLargeCake(currentCake);
    }

    public void addText(String text){
        currentCake = new TextedCake(currentCake,text);
    }

    public void newCake(Cake cake) {
        if (currentCake!=null) {
            currentOrder.addCake(currentCake);
        }
        currentCake=cake;
    }
}