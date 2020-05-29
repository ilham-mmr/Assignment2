/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import gui.InfoEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import model.Animal;
import model.AnimalData;

/**
 *
 * @author Ilham
 */
public class Controller {

    AnimalData animalData = new AnimalData();

    public void addAnimal(InfoEvent infoEvent) {
        String name = infoEvent.getName();
        String kindsOfAnimal = infoEvent.getKindsAnimal();
        String eat = infoEvent.getEat();
        String move = infoEvent.getMove();
        String breath = infoEvent.getBreath();

        Animal animal = new Animal(name, kindsOfAnimal, eat, move, breath);

        animalData.addAnimal(animal);
    }
    
    public void deleteAnimal(int index) {
        animalData.deleteAnimal(index);
    }

    public void editAnimal(InfoEvent infoEvent) {
        int index = infoEvent.getIndex();
        String name = infoEvent.getName();
        String kindsOfAnimal = infoEvent.getKindsAnimal();
        String eat = infoEvent.getEat();
        String move = infoEvent.getMove();
        String breath = infoEvent.getBreath();
        animalData.editAnimal(index, name, kindsOfAnimal, eat, move, breath);

    }

    public List<Animal> getAnimals() {
        return animalData.getAnimals();
    }

    public void saveToFile(File file) throws IOException {
        animalData.saveToFile(file);
    }

    public void loadFromFile(File file) throws IOException {
        animalData.loadFromFile(file);
    }
}
