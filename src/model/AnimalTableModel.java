/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ilham
 */
public class AnimalTableModel extends AbstractTableModel {

    private List<Animal> database;
    private String[] colTitles = {"ID", "Name", "Kinds Of Animal", "Eat", "Move", "Breath"};

    public void setData(List<Animal> database) {
        this.database = database;
    }

    public AnimalTableModel() {

    }

    @Override
    public int getRowCount() {
        return database.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Animal animal = database.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return animal.getId();
            case 1:
                return animal.getName();
            case 2:
                return animal.getKindsOfAnimal();
            case 3:
                return animal.getEat();
            case 4:
                return animal.getMove();
            case 5:
                return animal.getBreath();

        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return colTitles[column];
    }

}
