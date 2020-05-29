/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Ilham
 */
public class StartUp extends JFrame {

    private JButton exitButton;
    private JButton homeButton;
    private JButton aboutButton;
    private ImageIcon imageIcon;
    
    

    public StartUp() {
        super("Animalie");

        imageIcon = new ImageIcon(getClass().getResource("icon/exit.png"));

        exitButton = new JButton("EXIT", imageIcon);
        imageIcon = new ImageIcon(getClass().getResource("icon/home.png"));
        homeButton = new JButton("HOME", imageIcon);
        imageIcon = new ImageIcon(getClass().getResource("icon/about.png"));
        aboutButton = new JButton("About",imageIcon);
     

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        
      

        //------------First Row------------
        gc.weightx = 1;
        gc.weighty = 0.1;
        
        // add home button
        gc.gridx = 0;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_END;
         gc.insets = new Insets(0, 0, 0, 40);
        add(homeButton, gc);
        
        gc.weightx = 1;
        gc.weighty = 1;

        //add add about button
        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
         gc.insets = new Insets(0, 0, 0, 40);
        add(aboutButton, gc);
        
     
    
        // go to mainframe when home button clicked
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new MainFrame().setVisible(true);
                dispose();

            }
        });
        
        // show about dialog when about button clicked
        aboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Created by Ilham \nInstagram : ilham_mmr \nilham.mmr@gmail.com", 
                        "About", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        setMinimumSize(new Dimension(500, 400));
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
