package lld.design_cricbuzz.Team;

import lld.design_cricbuzz.Team.player.Player;
import lld.design_cricbuzz.Team.player.PlayerBattingController;
import lld.design_cricbuzz.Team.player.PlayerBowlingController;

import java.util.List;
import java.util.Queue;

public class Team {
    public String teamName;
    public Queue<Player> playing11;
    public List<Player> bench;
    public PlayerBattingController battingController;
    public PlayerBowlingController bowlingController;
    public boolean isWinner;

    public Team(String teamName, Queue<Player> playing11, List<Player> bench, List<Player> bowlers) {
        this.teamName = teamName;
        this.playing11 = playing11;
        this.bench = bench;
        battingController = new PlayerBattingController(playing11);
        bowlingController = new PlayerBowlingController(bowlers);
    }

    public void chooseNextBatsMan() throws Exception {
        battingController.getNextPlayer();
    }

    public void chooseNextBowler(int maxOverCountPerBowler){
        bowlingController.getNextBowler(maxOverCountPerBowler);
    }


    public Player getStriker() {
        return battingController.getOnStriker();
    }

    public void setStriker(Player player) {
        battingController.setOnStriker(player);
    }

    public Player getNonStriker() {
        return battingController.getNonStriker();
    }

    public void setNonStriker(Player player) {
        battingController.setNonStriker(player);
    }

    public int getTotalRuns() {
        int totalRun = 0;
        for (Player player : playing11) {
            totalRun += player.battingScoreCard.totalRuns;
        }
        return totalRun;
    }

    public Player getCurrentBowler() {
        return bowlingController.getCurrentBowler();
    }


    public void printBattingScoreCard(){

        for(Player playerDetails : playing11){
            playerDetails.printBattingScoreCard();
        }
    }

    public void printBowlingScoreCard(){

        for(Player playerDetails : playing11){
            if(playerDetails.bowlingScoreCard.totalOversCount > 0) {
                playerDetails.printBowlingScoreCard();
            }
        }
    }



}
