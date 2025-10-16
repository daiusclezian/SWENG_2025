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
            if (pins == 10){
                currentRoll++;
                currentFrame++;
            }
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

            if (f.isStrike()){
                Frame next = rolls[i+1];
                sum += next.first + next.second;
                //Frame nextNext = rolls[i+2];
                //sum += nextNext.first;
            } else if (f.isSpare()){
                Frame next = rolls[i+1];
                sum += next.first;

            }
            sum += f.first + f.second;
        }
        return sum;
    }

}
