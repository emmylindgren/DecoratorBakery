package se.umu.cs.apjava.bakery;

import se.umu.cs.emli.StrawberryCake;

import javax.swing.*;
import java.awt.*;

public class BakeryGuiBuilder {
    void buildGui() {
        BakeryViewModel bakeryViewModel=new BakeryViewModel();
        var frame=new JFrame();
        frame.setSize(400,400);
        var cakePanel=new JPanel();
        JTextArea textArea = new JTextArea();
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        var chocolateCakeButton=new JButton("Chocolate Cake");
        chocolateCakeButton.addActionListener(e->{
            bakeryViewModel.newCake(new ChocolateCake());
        });

        var vanillaCakeButton=new JButton("Vanilla Cake");
        vanillaCakeButton.addActionListener(e->{
            bakeryViewModel.newCake(new VanillaCake());
        });

        var strawberryCakeButton=new JButton("Strawberry Cake");
        strawberryCakeButton.addActionListener(e->{
            bakeryViewModel.newCake(new StrawberryCake());
        });

        var printButton=new JButton("Print Order");
        printButton.addActionListener(e->{
            String orderString=bakeryViewModel.printOrder();
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
