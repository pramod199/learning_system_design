package lld.design_cricbuzz.Team;

import lld.design_cricbuzz.BallDetails;
import lld.design_cricbuzz.OverDetails;
import lld.design_cricbuzz.Team.player.Player;

public class Wicket {
    public WicketType wicketType;
    public Player takenBy;
    OverDetails over;
    BallDetails ball;


    public Wicket(WicketType wicketType, Player takenBy, OverDetails over, BallDetails ball) {
        this.wicketType = wicketType;
        this.takenBy = takenBy;
        this.over = over;
        this.ball = ball;
    }
}
