package lld.design_cricbuzz.score_updater;

import lld.design_cricbuzz.BallDetails;

public interface ScoreUpdaterObserver {
    public void update(BallDetails ballDetails);
}
