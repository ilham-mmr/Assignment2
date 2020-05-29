/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Controller.Controller;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Ilham
 */
public class MainFrame extends JFrame {

    private LeftPane leftPane;
    private AnimalTablePanel tablePane;
    private Controller controller;
    private JFileChooser fileChooser;
    JCheckBoxMenuItem hideLeftPanelItem;

    public MainFrame() {
        super("Animalie");

        setLayout(new BorderLayout());

        leftPane = new LeftPane();
        tablePane = new AnimalTablePanel();
        controller = new Controller();
        tablePane.setData(controller.getAnimals());

        fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Animal File(.anml)", "anml");
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.setAcceptAllFileFilterUsed(false);

        setJMenuBar(createMenuBar());

        add(leftPane, BorderLayout.WEST);
        add(tablePane, BorderLayout.CENTER);
        
        
        //add animals from left panel
        leftPane.setInfoListener(new InfoEventListener() {
            public void infoEventHappened(InfoEvent event) {

                controller.addAnimal(event);
                tablePane.refresh();

            }
        });
        
        //delete animals from table
        tablePane.setAnimalTableListener(new AnimalTableListener() {
            public void rowDeleted(int row) {
                controller.deleteAnimal(row);
                tablePane.refresh();
            }
        });
        
        //edit animals from table
        tablePane.setEditEventListener(new InfoEventListener() {
            @Override
            public void infoEventHappened(InfoEvent event) {
                controller.editAnimal(event);
                tablePane.refresh();
            }
        });

        setMinimumSize(new Dimension(500, 400));
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exportItem = new JMenuItem("Export");
        JMenuItem importItem = new JMenuItem("Import");
        JMenuItem exitItem = new JMenuItem("Exit");

        JMenu windowMenu = new JMenu("Window");
        hideLeftPanelItem = new JCheckBoxMenuItem("left panel");
        hideLeftPanelItem.setSelected(true);
        
        JMenu aboutMenu = new JMenu("About");

        fileMenu.add(exportItem);
        fileMenu.add(importItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);

        windowMenu.add(hideLeftPanelItem);
        menuBar.add(windowMenu);
        
        menuBar.add(aboutMenu);

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                int action = JOptionPane.showConfirmDialog(MainFrame.this, "Do you really want to exit the app?", "confirm Exit", JOptionPane.OK_CANCEL_OPTION);

                if (action == JOptionPane.OK_OPTION) {
                    System.exit(0);
                }

            }
        });

        exportItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
                    System.out.println(fileChooser.getSelectedFile());
                    try {

                        controller.saveToFile(fileChooser.getSelectedFile());
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(MainFrame.this, "Could not save data to file", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        importItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
                    System.out.println(fileChooser.getSelectedFile());
                    try {
                        controller.loadFromFile(fileChooser.getSelectedFile());
                        tablePane.refresh();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(MainFrame.this, "Could not load data from file", "Error", JOptionPane.ERROR);
                    }
                }
            }
        });

        hideLeftPanelItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean selected = hideLeftPanelItem.isSelected();

                leftPane.setVisible(selected);

            }
        });
        
        aboutMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Created by Ilham \nInstagram : ilham_mmr \nilham.mmr@gmail.com", 
                        "About", JOptionPane.INFORMATION_MESSAGE);
            }
            
        });

        return menuBar;
    }
}
