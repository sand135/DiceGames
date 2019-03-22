package se.iths.sandra;

import java.util.ArrayList;


public class Player {

    private String name;
    private int score;
    ArrayList<Die> dieList = new ArrayList<Die>();
    private Die dice;







    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int roll(){
        dice.roll();
        int newValue = dice.getValue();
        return newValue;
    }

    public void rollDice() {
        for (int i = 0; i < dieList.size(); i++) {
            dieList.get(i).roll();
            System.out.println(dieList.get(i).getValue());
        }
    }

    public int getDieValue() {
        int valueOfDices = 0;
        for (int i = 0; i < dieList.size(); i++) {
            int a = dieList.get(i).getValue();
            valueOfDices = valueOfDices + a;
        }
        return valueOfDices;
    }

    public int increasePlayerScore() {

        return score++;
    }
    public int increasePlayerScore(int score) {
        return this.score += score;
    }

    public void addDie(int sides) {
        dieList.add(new Die(sides));
    }

    public void addDie(){
        this.dice=new Die(6);
    }

    @Override
    public String toString() {
        return name + ", poäng: " + score;
    }



}
