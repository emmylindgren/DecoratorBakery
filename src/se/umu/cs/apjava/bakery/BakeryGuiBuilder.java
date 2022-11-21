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
        bakeryController = new BakeryController();
        var frame=new JFrame();
        frame.setMinimumSize(new Dimension(500, 500));
        textArea = new JTextArea();
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        var cakeBuilderPanel = new JPanel();
        cakeBuilderPanel.setBorder(new CompoundBorder(BorderFactory.createTitledBorder("Order cakes")
                ,new EmptyBorder(5,5,5,5)));
        cakeBuilderPanel.setLayout(new BoxLayout(cakeBuilderPanel,BoxLayout.Y_AXIS));

        cakeBuilderPanel.add(makeCakeSelectionPanel());
        cakeBuilderPanel.add(makeDecorationPanel());
        cakeBuilderPanel.add(makeOrderPanel());

        frame.add(cakeBuilderPanel,BorderLayout.NORTH);
        frame.add(makePrintPanel(),BorderLayout.PAGE_END);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /**
     * Makes cake-selection panel. Adds buttons for selecting base-cakes.
     */
    private JPanel makeCakeSelectionPanel(){
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

    /**
     * Makes decoration panel. Adds checkboxes for selecting decorations
     * and a textfield for adding text to cakes.
     */
    private JPanel makeDecorationPanel(){
        decoratorPanel = new JPanel();
        decoratorPanel.setBorder(new CompoundBorder(BorderFactory.createTitledBorder("Add extras")
                ,new EmptyBorder(5,5,5,5)));

        extraLargeCheckBox = new JCheckBox("Extra large");
        sprinkledCheckBox = new JCheckBox("With sprinkles");
        textDecoration = new JTextField();
        textDecoration.setColumns(10);

        decoratorPanel.add(extraLargeCheckBox);
        decoratorPanel.add(sprinkledCheckBox);
        decoratorPanel.add(new JLabel("Add text on cake:"));
        decoratorPanel.add(textDecoration);

        setDecoratorPanelEnable(false);
        return decoratorPanel;
    }

    /**
     * Makes order-panel. Adds buttons for adding cake to order and for
     * discarding current cake that's being made.
     */
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

        orderPanel.add(addToOrderButton);
        orderPanel.add(clearCurrentCakeButton);
        return orderPanel;
    }

    /**
     * Makes panel containing print-order-button.
     */
    public JPanel makePrintPanel(){
        JPanel printPanel = new JPanel();
        var printButton=new JButton("Print Order");
        printButton.addActionListener(e->{
            String orderString= bakeryController.printOrder();
            textArea.append(orderString);
        });

        printPanel.add(printButton);
        return printPanel;
    }

    /**
     * Sets the cake-builder panel to either active or
     * inactive. When cake-builder panel is inactive then the decorator
     * panel is inactive, but the cakeSelection panel is active.
     * Vice versa if the cake-builder panel is active.
     * @param bool saying if the cakeBuilder panel is active or not.
     */
    private void cakeBuilderActive(boolean bool){
        setDecoratorPanelEnable(bool);
        setCakeSelectionPanelEnable(!bool);
    }

    /**
     * Enables/disables the decorator-panel. Also clears info that's been
     * added to the decorator-panel.
     * @param bool saying ig the decorator-panel is active or not.
     */
    private void setDecoratorPanelEnable(boolean bool){
        for (Component component: decoratorPanel.getComponents()) {
            component.setEnabled(bool);
            if(component instanceof JCheckBox box) box.setSelected(false);
        }
        decoratorPanel.setEnabled(bool);
        textDecoration.setText("");
    }

    /**
     * Enables/disables the cakeSelection-panel. Also clears info that's been
     * added to the panel.
     * @param bool saying if the cakeSelection-panel is active or not.
     */
    private void setCakeSelectionPanelEnable(boolean bool){
        for (Component component: cakePanel.getComponents()) {
            component.setEnabled(bool);
        }
    }
}
