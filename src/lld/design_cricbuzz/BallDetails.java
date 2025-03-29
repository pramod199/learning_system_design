package lld.design_cricbuzz;

import lld.design_cricbuzz.Team.Team;
import lld.design_cricbuzz.Team.Wicket;
import lld.design_cricbuzz.Team.WicketType;
import lld.design_cricbuzz.Team.player.Player;
import lld.design_cricbuzz.score_updater.BattingScoreUpdateObserver;
import lld.design_cricbuzz.score_updater.BowlingScoreCardObserver;
import lld.design_cricbuzz.score_updater.ScoreUpdaterObserver;

import java.util.ArrayList;
import java.util.List;

public class BallDetails {
    public int ballNumber;
    public BallType ballType;
    public RunType runType;
    public Player playedBy;
    public Player bowledBy;
    public Wicket wicket;
    List<ScoreUpdaterObserver> scoreUpdaterObservers = new ArrayList<>();

    public BallDetails(int ballNumber) {
        this.ballNumber = ballNumber;
        scoreUpdaterObservers.add(new BowlingScoreCardObserver());
        scoreUpdaterObservers.add(new BattingScoreUpdateObserver());
    }

    public void startBallDelivery(Team battingTeam, Team bowlingTeam, OverDetails over) {
        playedBy = battingTeam.getStriker();
        this.bowledBy = over.bowledBy;

        //THROW BALL AND GET THE BALL TYPE, assuming here that ball type is always NORMAL
        this.ballType = BallType.NORMAL;

        if (isWicketTaken()) {
            this.runType = RunType.ZERO;
            // consider only bold
            wicket = new Wicket(WicketType.BOLD, bowledBy, over, this);
            // making only striker out for now
            battingTeam.setStriker(null);
        } else {
            this.runType = getRunType();

            if (runType == RunType.ONE || runType == RunType.THREE) {
                //swap striker and non striker
                Player temp = battingTeam.getStriker();
                battingTeam.setStriker(battingTeam.getNonStriker());
                battingTeam.setNonStriker(temp);
            }
        }
        //update player scoreboard
        notifyUpdaters(this);
    }

    private void notifyUpdaters(BallDetails ballDetails) {
        for (ScoreUpdaterObserver observer : scoreUpdaterObservers) {
            observer.update(ballDetails);
        }
    }

    private RunType getRunType() {

        double val = Math.random();
        if (val <= 0.2) {
            return RunType.ONE;
        } else if (val >= 0.3 && val <= 0.5) {
            return RunType.TWO;
        } else if (val >= 0.6 && val <= 0.8) {
            return RunType.FOUR;
        } else {
            return RunType.SIX;
        }
    }


    private boolean isWicketTaken() {
        //random function return value between 0 and 1
        if (Math.random() < 0.2) {
            return true;
        } else {
            return false;
        }
    }
}
