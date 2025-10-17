package it.unimi.di.sweng.lab02;

public class Game implements Bowling{

    private Frame[] rolls;
    private int currentFrame;
    private int currentRoll;
    private int bonusRoll_1;
    private int bonusRoll_2;

    public Game(){
        this.rolls = new Frame[10];
        this.currentFrame = 0;
        this.currentRoll = 0;
        this.bonusRoll_1 = 0;
        this.bonusRoll_2 = 0;
    }


    @Override
    public void roll(final int pins) {

        // caso in cui sei andato oltre l'ultimo frame e l'ultimo frame è uno strike
        if (currentFrame == 10 && rolls[rolls.length-1].isStrike()){
            this.bonusRoll_1 = pins;
            currentFrame++;
            currentRoll++; // questo per ora non serve
            return;
        }

        if (currentFrame == 11 && rolls[rolls.length-1].isStrike()){
            this.bonusRoll_2 = pins;
            return;
        }

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
        for (int i = 0; i < rolls.length-1; i++) {
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
        // avendo fatto il for fino al penultimo elemento, aggiungo l'ultimo
        Frame lastRoll = rolls[rolls.length-1];
        sum += lastRoll.first + lastRoll.second;
        return sum + bonusRoll_1 + bonusRoll_2;
    }

}
