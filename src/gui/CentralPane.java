/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Ilham
 */
public class CentralPane extends JPanel {

    private JTextArea jTextArea;

    public CentralPane() {
        setLayout(new CardLayout());
        jTextArea = new JTextArea();
        add(jTextArea);

    }

    public void appendText(String text) {
        jTextArea.append(text);

    }

}
