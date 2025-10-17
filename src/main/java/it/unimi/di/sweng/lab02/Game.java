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
            currentRoll += 2; // +2 per strike, +1 per spare
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
        for (int i = 0; i < rolls.length-2; i++) {
            Frame f = rolls[i];

            if (f.isStrike()){
                Frame next = rolls[i+1];
                sum += next.first;
                if (next.isStrike()){
                    Frame nextNext = rolls[i+2];
                    sum += nextNext.first;
                }else{
                    sum += next.second; // il primo lo avevo già aggiunto prima
                }

            } else if (f.isSpare()){
                Frame next = rolls[i+1];
                sum += next.first;

            }
            sum += f.score();
        }
        // avendo fatto il for fino al penultimo elemento, aggiungo penultimo e ultimo
        Frame lastRoll = rolls[rolls.length-2];
        Frame lastRoll2 = rolls[rolls.length-1];
        sum += lastRoll.score() + lastRoll2.score();

        // manca il caso in cui lo strike è il penultimo frame, devo aggiungere anche bonusRoll_1
        if (lastRoll.isStrike()){
            sum += bonusRoll_1;
        }

        if (bonusRoll_1 == 10){
            sum += bonusRoll_2;
        }

        // aggiungo poi i 2 tiri bonus
        return sum + bonusRoll_1 + bonusRoll_2;
        //return bonusRoll_1 + bonusRoll_2;
    }

}
