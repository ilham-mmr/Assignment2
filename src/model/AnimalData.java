/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Ilham
 */

//this is the animal data
public class AnimalData {

    private List<Animal> animals;

    public AnimalData() {
        animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void deleteAnimal(int index) {
        animals.remove(index);
    }
    
    public void editAnimal(int index, String name, String kindsOfanimal, String eat, String move, String breath) {
        Animal animal = animals.get(index);
        animal.setName(name);
        animal.setKindsOfAnimal(kindsOfanimal);
        animal.setEat(eat);
        animal.setMove(move);
        animal.setBreath(breath);
    }

    public void saveToFile(File file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        Animal[] myAnimal = animals.toArray(new Animal[animals.size()]);

        oos.writeObject(myAnimal);

        oos.close();

    }

    public void loadFromFile(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        try {
            Animal[] myAnimals = (Animal[]) ois.readObject();
            animals.clear();
            animals.addAll(Arrays.asList(myAnimals));
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        ois.close();

    }

}
