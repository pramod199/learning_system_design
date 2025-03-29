package lld.design_cricbuzz.score_updater;

import lld.design_cricbuzz.BallDetails;
import lld.design_cricbuzz.BallType;
import lld.design_cricbuzz.RunType;

public class BowlingScoreCardObserver implements ScoreUpdaterObserver {
    @Override
    public void update(BallDetails ballDetails) {
        if (ballDetails.ballNumber == 6 && ballDetails.ballType == BallType.NORMAL) {
            ballDetails.bowledBy.bowlingScoreCard.totalOversCount++;
        }
        if (RunType.ONE == ballDetails.runType) {
            ballDetails.bowledBy.bowlingScoreCard.totalRunsGiven += 1;
        } else if (RunType.TWO == ballDetails.runType) {
            ballDetails.bowledBy.bowlingScoreCard.totalRunsGiven += 2;
        } else if (RunType.THREE == ballDetails.runType) {
            ballDetails.bowledBy.bowlingScoreCard.totalRunsGiven += 3;
        } else if (RunType.FOUR == ballDetails.runType) {
            ballDetails.bowledBy.bowlingScoreCard.totalRunsGiven += 4;
        } else if (RunType.SIX == ballDetails.runType) {
            ballDetails.bowledBy.bowlingScoreCard.totalRunsGiven += 6;
        }

        if (ballDetails.wicket != null) {
            ballDetails.bowledBy.bowlingScoreCard.totalWicketsTaken++;
        }

        if (ballDetails.ballType == BallType.WIDEBALL) {
            ballDetails.bowledBy.bowlingScoreCard.wideBallCount++;
        } else if (ballDetails.ballType == BallType.NO_BALL) {
            ballDetails.bowledBy.bowlingScoreCard.noBallCount++;
        }

    }
}
