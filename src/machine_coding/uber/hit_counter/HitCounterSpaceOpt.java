package machine_coding.uber.hit_counter;

import java.util.LinkedList;
import java.util.Queue;

public class HitCounterSpaceOpt {
    private Queue<Integer> hits = new LinkedList<>();

    void hits(int timestamp) {
        hits.add(timestamp);
    }

    int getHits(int timestamp) {
        while (!hits.isEmpty() && timestamp-hits.peek() >= 300){
            hits.poll();
        }
        return hits.size();
    }

    public static void main(String[] args) {
        HitCounterSpaceOpt ht = new HitCounterSpaceOpt();
        ht.hits(1);
        ht.hits(2);
        ht.hits(3);
        System.out.println(ht.getHits(4));
        ht.hits(300);
        System.out.println(ht.getHits(300));
        System.out.println(ht.getHits(301));

    }
}
