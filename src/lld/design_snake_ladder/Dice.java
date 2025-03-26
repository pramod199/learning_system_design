package lld.design_snake_ladder;

public class Dice {
    int diceCount; // we can have more than 1 dice, specified while initialising game

    int min = 1;
    int max = 6;

    public Dice(int diceCount) {
        this.diceCount = diceCount;
    }

    public int rollDice(){
        int totalSum = 0;
        int diceUsed = 0;

        while(diceUsed < diceCount){
            totalSum += (int)(Math.random() * (max - min + 1) + min);
            diceUsed++;
        }
        return totalSum;
    }
}
