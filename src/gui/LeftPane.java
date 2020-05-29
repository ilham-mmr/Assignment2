/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Ilham
 */
public class LeftPane extends JPanel {

    private InfoEventListener infoEventListener;

    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel eatLabel;
    private JTextField eatField;
    private JLabel moveLabel;
    private JTextField moveField;
    private JLabel breathLabel;
    private JTextField breathField;

    private JLabel kindsOfAnimalLabel;
    private JRadioButton mammalRadio;
    private JRadioButton ovipariousRadio;
    private ButtonGroup kindsOfAnimalGroup;

    private JButton submitButton;
    private JButton clearButton;

    

    public LeftPane() {
        Dimension dim = getPreferredSize();
        dim.width = 350;
        setPreferredSize(dim);

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("icon/name.png"));
        nameLabel = new JLabel("Name", imageIcon, 2);
        nameField = new JTextField("Cat", 10);
        nameField.setToolTipText("Enter animal name here!");

        imageIcon = new ImageIcon(getClass().getResource("icon/eat.png"));
        eatLabel = new JLabel("Eat: ", imageIcon, 2);
        eatField = new JTextField("Fish", 10);
        eatField.setToolTipText("Enter what the animal eats!");

        imageIcon = new ImageIcon(getClass().getResource("icon/move.png"));
        moveLabel = new JLabel("Move: ", imageIcon, 2);
        moveField = new JTextField("Walk", 10);
        moveField.setToolTipText("Enter how the animal walks");

        imageIcon = new ImageIcon(getClass().getResource("icon/breath.png"));
        breathLabel = new JLabel("Breath: ", imageIcon, 2);
        breathField = new JTextField("Lungs", 10);
        breathField.setToolTipText("Enter what organ(s) that the animal breathes with!");

        imageIcon = new ImageIcon(getClass().getResource("icon/animalKind.png"));
        kindsOfAnimalLabel = new JLabel("Kinds Of Animal: ", imageIcon, 2);
        mammalRadio = new JRadioButton("Mammal");
        mammalRadio.setSelected(true);

        ovipariousRadio = new JRadioButton("Oviparious");
        kindsOfAnimalGroup = new ButtonGroup();
        kindsOfAnimalGroup.add(mammalRadio);
        kindsOfAnimalGroup.add(ovipariousRadio);

        submitButton = new JButton("Submit");

        clearButton = new JButton("Clear");

        mammalRadio.setActionCommand("Mammal");
        ovipariousRadio.setActionCommand("Oviparous");
        
        
        nameField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                nameField.setText("");

            }

            public void focusLost(FocusEvent e) {
                // nothing
            }
        });

        eatField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                eatField.setText("");
            }

            public void focusLost(FocusEvent e) {
                // nothing
            }
        });

        moveField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                moveField.setText("");
            }

            public void focusLost(FocusEvent e) {
                // nothing
            }
        });

        breathField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                breathField.setText("");
            }

            public void focusLost(FocusEvent e) {
                // nothing
            }
        });
        
        //when submit button clicked all the data get raised to the mainframe to decide
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = nameField.getText();
                String animalKind = kindsOfAnimalGroup.getSelection().getActionCommand();
                String eat = eatField.getText();
                String move = moveField.getText();
                String breath = breathField.getText();

                if (name.isEmpty() || animalKind.isEmpty() || eat.isEmpty() || move.isEmpty() || breath.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in the form properly!");
                } else {

                    InfoEvent event = new InfoEvent(name, animalKind, eat, move, breath, this);

                    if (infoEventListener != null) {
                        infoEventListener.infoEventHappened(event);
                    }
                    JOptionPane.showMessageDialog(null, "You have submitted the data succesfully", 
                        "Info", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });
        
        // clear up the textfields and radio button
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameField.setText("");
                kindsOfAnimalGroup.clearSelection();
                eatField.setText("");
                moveField.setText("");
                breathField.setText("");
                
                 JOptionPane.showMessageDialog(null, "form has been succesfully cleared up", 
                        "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        //set border style for leftpanel
        Border innerborder = BorderFactory.createTitledBorder(null, "Add Animal", TitledBorder.CENTER, TitledBorder.TOP);
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerborder));

        layoutInit();

    }

    public void layoutInit() {
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        //------------First Row------------
        gc.weightx = 1;
        gc.weighty = 0.1;
        
        // add namelabel
        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(nameLabel, gc);

        //add nameField
        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        add(nameField, gc);

        //------------Second Row------------
        //add kinds of animal label
        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(kindsOfAnimalLabel, gc);

        //add mammal radio
        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(mammalRadio, gc);
        
        //add oviparious radio
        gc.gridx = 2;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(ovipariousRadio, gc);

        //------------Third Row------------
        gc.weightx = 1;
        gc.weighty = 0.1;
        // add eat label
        gc.gridx = 0;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(eatLabel, gc);

        //add eat field
        gc.gridx = 1;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_START;
        add(eatField, gc);

       //------------Fourth Row------------

        gc.weightx = 1;
        gc.weighty = 0.1;
        // add move label
        gc.gridx = 0;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(moveLabel, gc);

        //add move field
        gc.gridx = 1;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        add(moveField, gc);

        //------------Fifth Row------------
        gc.weightx = 1;
        gc.weighty = 0.1;
        // add breath label
        gc.gridx = 0;
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(breathLabel, gc);

        //add breath field
        gc.gridx = 1;
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.LINE_START;
        add(breathField, gc);

        //------------Last Row------------
        gc.weightx = 1;
        gc.weighty = 0.1;
        // add submit button
        gc.gridx = 0;
        gc.gridy = 5;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(submitButton, gc);
        
        // add clear button
        gc.gridx = 1;
        gc.gridy = 5;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(clearButton, gc);

    }
    
    
    public void setInfoListener(InfoEventListener eventListener) {
        this.infoEventListener = eventListener;
    }

}
