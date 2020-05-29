/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Ilham
 */

//This class is to store animal objects
public class Animal implements Serializable {

    private static int count;

    private String id;
    private String name;
    private String kindsOfAnimal;
    private String eat;
    private String move;
    private String breath;

    public Animal(String name, String kindsOfAnimal, String eat, String move, String breath) {
        this.name = name;
        this.kindsOfAnimal = kindsOfAnimal;
        this.eat = eat;
        this.move = move;
        this.breath = breath;
        this.id = "ANML" + count;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Animal.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKindsOfAnimal() {
        return kindsOfAnimal;
    }

    public void setKindsOfAnimal(String kindsOfAnimal) {
        this.kindsOfAnimal = kindsOfAnimal;
    }

    public String getEat() {
        return eat;
    }

    public void setEat(String eat) {
        this.eat = eat;
    }

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }

    public String getBreath() {
        return breath;
    }

    public void setBreath(String breath) {
        this.breath = breath;
    }

}
