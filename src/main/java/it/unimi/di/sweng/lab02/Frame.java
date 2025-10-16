package it.unimi.di.sweng.lab02;

public class Frame {
    int first;
    int second;

    public Frame(){
        this.first = 0;
        this.second = 0;
    }

    int score(){
        return this.first + this.second;
    }

    boolean isStrike(){
        return first == 10;
    }

    boolean isSpare(){
        return (this.first + this.second == 10) && (this.first != 10);
    }
}
