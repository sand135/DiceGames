package se.iths.sandra;

import java.util.Random;

public class Die {
    private int value;
    private int sides;
    private static Random random = new Random();

    public Die(int sides){
        this.sides = sides;
        this.value = 0;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getSides() {
        return sides;
    }

    public int getValue() {
        return value;
    }

    public void roll(){

        value = random.nextInt(sides)+1;
    }

}
