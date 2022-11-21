package se.umu.cs.apjava.bakery;

import se.umu.cs.emli.ExtraLargeCake;
import se.umu.cs.emli.SprinkledCake;
import se.umu.cs.emli.StrawberryCake;
import se.umu.cs.emli.TextedCake;

import javax.swing.*;
import java.awt.*;

public class BakeryGuiBuilder {
    void buildGui() {
        BakeryController bakeryController =new BakeryController();
        var frame=new JFrame();
        frame.setSize(400,400);
        var cakePanel=new JPanel();
        JTextArea textArea = new JTextArea();
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        var chocolateCakeButton=new JButton("Chocolate Cake");
        chocolateCakeButton.addActionListener(e->{
            bakeryController.newCake(new TextedCake(new SprinkledCake(new ExtraLargeCake(new ChocolateCake())),"hej"));
        });

        var vanillaCakeButton=new JButton("Vanilla Cake");
        vanillaCakeButton.addActionListener(e->{
            bakeryController.newCake(new VanillaCake());
        });

        var strawberryCakeButton=new JButton("Strawberry Cake");
        strawberryCakeButton.addActionListener(e->{
            bakeryController.newCake(new StrawberryCake());
        });

        var printButton=new JButton("Print Order");
        printButton.addActionListener(e->{
            String orderString= bakeryController.printOrder();
            textArea.append(orderString);
        });

        cakePanel.add(vanillaCakeButton);
        cakePanel.add(chocolateCakeButton);
        cakePanel.add(strawberryCakeButton);
        cakePanel.add(printButton);

        frame.add(cakePanel,BorderLayout.NORTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
