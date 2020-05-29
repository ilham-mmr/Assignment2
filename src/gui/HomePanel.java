/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Ilham
 */
public class HomePanel extends JPanel {

    private JLabel welcomeLabel;

    public HomePanel() {
        setLayout(new BorderLayout());
        welcomeLabel = new JLabel("WELCOME TO THE APP");
        add(welcomeLabel, BorderLayout.CENTER);

    }

}
