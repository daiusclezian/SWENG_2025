package it.unimi.di.sweng.lab02;

public class Game implements Bowling{

    private int[] rolls;
    private int index;

    public Game(){
        this.rolls = new int[22];
        this.index = 0;
    }

    private boolean isStrike(int i) {
        return (i < rolls.length -2) && (i%2 == 0) && (rolls[i] == 10);
    }

    private boolean isSpare(int i) {
        return (i != rolls.length -1) && (i%2 == 1) && (rolls[i] + rolls[i-1] == 10) && (rolls[i-1] != 10);
    }


    @Override
    public void roll(final int pins) {

        rolls[this.index++] = pins;
        if (pins == 10 && this.index%2 == 1 && this.index < 20) {
            index++;
        }

        //if (this.index > 19) throw new IndexOutOfBoundsException();
    }

    @Override
    public int score() {
        int sum = 0;

        for (int i = 0; i<rolls.length-2; i++){
            sum += rolls[i];
            if (isStrike(i)){
                if (isStrike(i+2)) { // altro strike successivo
                    sum += rolls[i+2] + rolls[i+4];
                } else {
                    sum += rolls[i+2] + rolls[i+3];
                }
            }

            if (isSpare(i)){
                sum += rolls[i+1];
            }
        }
        return sum;
    }
}
