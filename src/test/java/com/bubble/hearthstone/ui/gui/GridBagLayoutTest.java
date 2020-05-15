package com.bubble.hearthstone.ui.gui;

import com.bubble.hearthstone.ui.gui.components.CustomLabel;

import static org.junit.Assert.assertNotNull;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.junit.Test;

public class GridBagLayoutTest extends JPanel {

    private static final long serialVersionUID = 1L;
    
    public GridBagLayoutTest() {
        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        this.setPreferredSize(new Dimension(500,500));
        initiate();
        // test2();
    }

    @Test
    public void dummyTest() {
        assertNotNull(this);
    }

    private void initiate() {
        final JButton btn1 = new JButton("HI");
        // final JButton btn2 = new JButton("HI");
        final CustomLabel btn2 = new CustomLabel("HI", Color.RED);
        // final JButton btn3 = new JButton("HI");
        final JTextField btn3 = new JTextField("HI");
        final JButton btn4 = new JButton("HI");
        final GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.50;
        c.gridx = 0;
        c.gridy = 0;
        this.add(btn1, c);
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 0;
        this.add(btn2, c);
        c.weightx = 0.50;
        c.gridx = 0;
        c.gridy = 1;
        this.add(btn3, c);
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 1;
        this.add(btn4, c);
    }

    public void test1() {
        final boolean shouldFill = true;
        final boolean shouldWeightX = true;
        JButton button;
        GridBagConstraints c = new GridBagConstraints();
        if (shouldFill) {
                        //natural height, maximum width
                        c.fill = GridBagConstraints.HORIZONTAL;
        }

        button = new JButton("Button 1");
        if (shouldWeightX) {
                        c.weightx = 0.5;
        }
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        this.add(button, c);

        button = new JButton("Button 2");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        this.add(button, c);

        button = new JButton("Button 3");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 0;
        this.add(button, c);

        button = new JButton("Long-Named Button 4");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 40;      //make this component tall
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 1;
        this.add(button, c);

        button = new JButton("5");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;       //reset to default
        c.weighty = 1.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        c.insets = new Insets(10,0,0,0);  //top padding
        c.gridx = 1;       //aligned with button 2
        c.gridwidth = 2;   //2 columns wide
        c.gridy = 2;       //third row
        this.add(button, c);
    }

    public void test2() {
        final boolean shouldFill = true;
        final boolean shouldWeightX = true;
        JButton button;
        GridBagConstraints c = new GridBagConstraints();
        if (shouldFill) {
                        //natural height, maximum width
                        c.fill = GridBagConstraints.HORIZONTAL;
        }

        button = new JButton("Button 1");
        if (shouldWeightX) {
                        c.weightx = 0.5;
        }
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        this.add(button, c);

        button = new JButton("Button 2");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        this.add(button, c);

        button = new JButton("Button 3");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 1;
        this.add(button, c);

        button = new JButton("Button 3");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 1;
        this.add(button, c);

        // button = new JButton("Long-Named Button 4");
        // c.fill = GridBagConstraints.HORIZONTAL;
        // c.ipady = 40;      //make this component tall
        // c.weightx = 0.0;
        // c.gridwidth = 3;
        // c.gridx = 0;
        // c.gridy = 1;
        // this.add(button, c);

        button = new JButton("5");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;       //reset to default
        c.weighty = 1.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        c.insets = new Insets(10,0,0,0);  //top padding
        c.gridx = 1;       //aligned with button 2
        c.gridwidth = 2;   //2 columns wide
        c.gridy = 2;       //third row
        this.add(button, c);
    }
}