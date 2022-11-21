package se.umu.cs.apjava.bakery;

import se.umu.cs.emli.StrawberryCake;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BakeryGuiBuilder {
    BakeryController bakeryController;
    JTextArea textArea;
    JPanel decoratorPanel;
    JPanel cakePanel;

    JCheckBox extraLargeCheckBox;
    JCheckBox sprinkledCheckBox;
    JTextField textDecoration;

    void buildGui() {
        bakeryController =new BakeryController();
        var frame=new JFrame();
        frame.setMinimumSize(new Dimension(500, 500));

        textArea = new JTextArea();
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        var cakePanel = new JPanel();
        cakePanel.setBorder(new CompoundBorder(BorderFactory.createTitledBorder("Order cakes")
                ,new EmptyBorder(5,5,5,5)));
        cakePanel.setLayout(new BoxLayout(cakePanel,BoxLayout.Y_AXIS));
        cakePanel.add(makeCakePanel());
        cakePanel.add(makeDecorationPanel());
        cakePanel.add(makeOrderPanel());

        frame.add(cakePanel,BorderLayout.NORTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private JPanel makeCakePanel(){

        cakePanel=new JPanel();
        cakePanel.setBorder(new CompoundBorder(BorderFactory.createTitledBorder("Choose type of cake")
                ,new EmptyBorder(5,5,5,5)));

        var chocolateCakeButton=new JButton("Chocolate Cake");
        chocolateCakeButton.addActionListener(e->{
            bakeryController.newCake(new ChocolateCake());
            cakeBuilderActive(true);
            chocolateCakeButton.setEnabled(true);
        });

        var vanillaCakeButton=new JButton("Vanilla Cake");
        vanillaCakeButton.addActionListener(e->{
            bakeryController.newCake(new VanillaCake());
            cakeBuilderActive(true);
            vanillaCakeButton.setEnabled(true);
        });

        var strawberryCakeButton=new JButton("Strawberry Cake");
        strawberryCakeButton.addActionListener(e->{
            bakeryController.newCake(new StrawberryCake());
            cakeBuilderActive(true);
            strawberryCakeButton.setEnabled(true);
        });

        cakePanel.add(vanillaCakeButton);
        cakePanel.add(chocolateCakeButton);
        cakePanel.add(strawberryCakeButton);

        return cakePanel;
    }

    private JPanel makeDecorationPanel(){
        decoratorPanel = new JPanel();
        decoratorPanel.setBorder(new CompoundBorder(BorderFactory.createTitledBorder("Add extras")
                ,new EmptyBorder(5,5,5,5)));

        extraLargeCheckBox = new JCheckBox("Extra large");
        sprinkledCheckBox = new JCheckBox("With sprinkles");
        textDecoration = new JTextField();

        decoratorPanel.add(extraLargeCheckBox);
        decoratorPanel.add(sprinkledCheckBox);
        decoratorPanel.add(textDecoration,BorderLayout.LINE_END);

        setDecoratorPanelEnable(false);

        return decoratorPanel;
    }

    private JPanel makeOrderPanel(){
        JPanel orderPanel = new JPanel();

        var clearCurrentCakeButton =new JButton("Clear current cake");
        clearCurrentCakeButton.addActionListener(e->{
            bakeryController.clearOrder();
            cakeBuilderActive(false);
        });

        var addToOrderButton=new JButton("Add cake to order");
        addToOrderButton.addActionListener(e -> {
            if(extraLargeCheckBox.isSelected()) bakeryController.extraLarge();
            if(sprinkledCheckBox.isSelected()) bakeryController.addSprinkles();
            if(!textDecoration.getText().isEmpty()) bakeryController.addText(textDecoration.getText());

            bakeryController.finishOrder();
            cakeBuilderActive(false);
        });

        var printButton=new JButton("Print Order");
        printButton.addActionListener(e->{
            String orderString= bakeryController.printOrder();
            textArea.append(orderString);
        });

        orderPanel.add(clearCurrentCakeButton);
        orderPanel.add(addToOrderButton);
        orderPanel.add(printButton);

        return orderPanel;
    }

    private void cakeBuilderActive(boolean bool){
        setDecoratorPanelEnable(bool);
        setCakePanelEnable(!bool);
    }
    
    private void setDecoratorPanelEnable(boolean bool){
        for (Component component: decoratorPanel.getComponents()) {
            component.setEnabled(bool);
            if(component instanceof JCheckBox box) box.setSelected(false);
        }
        decoratorPanel.setEnabled(bool);
    }

    private void setCakePanelEnable(boolean bool){
        for (Component component: cakePanel.getComponents()) {
            component.setEnabled(bool);
        }
    }

}
