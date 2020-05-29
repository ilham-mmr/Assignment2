/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import model.Animal;
import model.AnimalTableModel;

/**
 *
 * @author Ilham
 */
public class AnimalTablePanel extends JPanel {

    private JTable table;
    private AnimalTableModel tableModel;
    private JPopupMenu popupMenu;
    private InfoEventListener infoEventListener;
    

    private AnimalTableListener animalTableListener;

    public AnimalTablePanel() {
        tableModel = new AnimalTableModel();
        table = new JTable(tableModel);

        popupMenu = new JPopupMenu();
        JMenuItem removeItem = new JMenuItem("Delete row");
        JMenuItem updateItem = new JMenuItem("Update row");

        popupMenu.add(removeItem);
        popupMenu.add(updateItem);
        
        //add pop up menu listener when table is right clicked
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                table.getSelectionModel().setSelectionInterval(row, row);
                if (e.getButton() == MouseEvent.BUTTON3) {
                    popupMenu.show(table, e.getX(), e.getY());
                }

            }

        });
        
        // remove item from table through pop up menu
        removeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (animalTableListener != null) {
                    animalTableListener.rowDeleted(row);
                }

            }
        });
        
        // update item from table through pop up menu
        updateItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int row = table.getSelectedRow();
                String name = JOptionPane.showInputDialog(null, "Enter name: ", "Edit Animal", JOptionPane.QUESTION_MESSAGE);

                String[] options = {"Mammal", "Oviparious"};
                JComboBox myComboBox = new JComboBox(options);
                myComboBox.setSelectedIndex(1);
                JOptionPane.showMessageDialog(null, myComboBox, "Edit Animal", JOptionPane.QUESTION_MESSAGE);

                String kindsOfAnimals = myComboBox.getSelectedItem().toString();
                String eat = JOptionPane.showInputDialog(null, "Enter what the animal eats: ", "Edit Animal", JOptionPane.QUESTION_MESSAGE);
                String move = JOptionPane.showInputDialog(null, "Enter how the animal moves: ", "Edit Animal", JOptionPane.QUESTION_MESSAGE);
                String breath = JOptionPane.showInputDialog(null, "Enter what organ(s) that the animal breathes with: ", "Edit Animal", JOptionPane.QUESTION_MESSAGE);

                InfoEvent infoEvent = new InfoEvent(row, name, kindsOfAnimals, eat, move, breath, this);
                if (infoEventListener != null) {
                    infoEventListener.infoEventHappened(infoEvent);

                }

            }
        });

       
        setLayout(new BorderLayout());

        add(new JScrollPane(table), BorderLayout.CENTER);

    }

    public void setData(List<Animal> database) {
        tableModel.setData(database);
    }

    public void refresh() {
        tableModel.fireTableDataChanged();
    }

    public AnimalTableModel getAnimalTableModel() {
        return this.tableModel;
    }

    public void getModel(String[] data) {

    }

    public void setAnimalTableListener(AnimalTableListener listener) {
        this.animalTableListener = listener;
    }

    public void setEditEventListener(InfoEventListener listener) {
        this.infoEventListener = listener;
    }

}
