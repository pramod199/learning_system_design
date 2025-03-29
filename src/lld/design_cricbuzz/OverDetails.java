package lld.design_cricbuzz;

import lld.design_cricbuzz.Team.Team;
import lld.design_cricbuzz.Team.player.Player;

import java.util.ArrayList;
import java.util.List;

public class OverDetails {
    public int overNumber;
    List<BallDetails> balls;
    int extraBallsCount;
    Player bowledBy;

    public OverDetails(int overNumber, Player bowledBy) {
        this.overNumber = overNumber;
        this.bowledBy = bowledBy;
        balls = new ArrayList<>();
        extraBallsCount = 0;
    }

    public boolean startOver(Team battingTeam, Team bowlingTeam, int runsToWin) throws Exception {

        int ballCount = 1;
        while (ballCount <= 6) {

            BallDetails ball = new BallDetails(ballCount);
            ball.startBallDelivery(battingTeam, bowlingTeam, this);
            this.balls.add(ball);

            if (ball.ballType == BallType.NORMAL) {
                ballCount++;
                if (ball.wicket != null) {
                    battingTeam.chooseNextBatsMan();
                }

                if (runsToWin != -1 && battingTeam.getTotalRuns() >= runsToWin) {
                    battingTeam.isWinner = true;
                    return true;
                }

            } else {
                extraBallsCount++;
            }
        }

        return false;
    }
}

