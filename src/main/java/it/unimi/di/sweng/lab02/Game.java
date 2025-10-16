package it.unimi.di.sweng.lab02;

public class Game implements Bowling{

    private Frame[] rolls;
    private int currentFrame;
    private int currentRoll;

    public Game(){
        this.rolls = new Frame[10];
        this.currentFrame = 0;
        this.currentRoll = 0;
    }


    @Override
    public void roll(final int pins) {
        if (currentRoll%2 == 0){
            rolls[currentFrame] = new Frame();
            rolls[currentFrame].first = pins;
        }
        else{
            rolls[currentFrame].second = pins;
            currentFrame++;
        }
        currentRoll++;
    }

    @Override
    public int score() {
        int sum = 0;
        for (int i = 0; i < rolls.length; i++) {
            Frame f = rolls[i];
            if (f.isSpare()){
                Frame next = rolls[i+1];
                sum += next.first;
            }
            sum += f.first + f.second;
        }
        return sum;
    }

}
