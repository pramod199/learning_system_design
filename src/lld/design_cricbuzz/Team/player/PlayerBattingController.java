package lld.design_cricbuzz.Team.player;

import java.util.LinkedList;
import java.util.Queue;

public class PlayerBattingController {
    Queue<Player> yetToPlay;
    Player onStriker;
    Player nonStriker;

    public PlayerBattingController(Queue<Player> playing11) {
        this.yetToPlay = new LinkedList<>(playing11);
    }

    public void getNextPlayer() throws Exception{
        if (yetToPlay.isEmpty()) {
            System.out.println("All out");
            throw new Exception("All out");
        }

        if (onStriker == null) {
            onStriker = yetToPlay.poll();
        }

        if (nonStriker == null) {
            nonStriker = yetToPlay.poll();
        }
    }

    public Player getOnStriker() {
        return onStriker;
    }

    public void setOnStriker(Player onStriker) {
        this.onStriker = onStriker;
    }

    public Player getNonStriker() {
        return nonStriker;
    }

    public void setNonStriker(Player nonStriker) {
        this.nonStriker = nonStriker;
    }
}
