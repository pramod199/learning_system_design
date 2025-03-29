package lld.design_cricbuzz.Team.player;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PlayerBowlingController {
    Deque<Player> bowlersList;
    Map<Player, Integer> bowlerVsOverCount;
    Player currentBowler;

    public PlayerBowlingController(List<Player> bowlersList) {
        this.bowlersList = new LinkedList<>(bowlersList);
        this.bowlerVsOverCount = new HashMap<>();
        for (Player bowler : bowlersList) {
            bowlerVsOverCount.put(bowler, 0);
        }
    }

    public void getNextBowler(int maxOverCountPerBowler) {

        Player playerDetails = bowlersList.poll();
        if (bowlerVsOverCount.get(playerDetails) + 1 == maxOverCountPerBowler) {
            currentBowler = playerDetails;
        } else {
            currentBowler = playerDetails;
            bowlersList.addLast(playerDetails); // bowler went to last of the queue
            bowlerVsOverCount.put(playerDetails, bowlerVsOverCount.get(playerDetails) + 1);
        }
    }

    public Player getCurrentBowler() {
        return currentBowler;
    }

}
