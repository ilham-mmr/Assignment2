/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.EventObject;

/**
 *
 * @author Ilham
 */


//this class only stores the data temporarily
public class InfoEvent extends EventObject {

    private String name;
    private String animalKind;
    private String eat;
    private String move;
    private String breath;
    private int index;

    public InfoEvent(String name, String animalKind, String eat, String move, String breath, Object source) {
        super(source);
        this.name = name;
        this.animalKind = animalKind;
        this.eat = eat;
        this.move = move;
        this.breath = breath;
    }

    public InfoEvent(int index, String name, String animalKind, String eat, String move, String breath, Object source) {
        super(source);
        this.index = index;
        this.name = name;
        this.animalKind = animalKind;
        this.eat = eat;
        this.move = move;
        this.breath = breath;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public String getKindsAnimal() {
        return animalKind;
    }

    public String getEat() {
        return eat;
    }

    public String getMove() {
        return move;
    }

    public String getBreath() {
        return breath;
    }

}
