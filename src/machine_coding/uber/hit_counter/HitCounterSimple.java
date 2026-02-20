package machine_coding.uber.hit_counter;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/discuss/post/178662/design-a-hit-counter-by-shashibk11-mqzz/

 */
public class HitCounterSimple {
    // We can use a vector to store all the hits. These two functions are self explainatory.
    private List<Integer> hits;

    public HitCounterSimple() {
        this.hits = new ArrayList<>();
    }

//    O(1)
    void hits(int timestamp) {
        hits.add(timestamp);
    }

    // o(n)
    int getHits(int timestamp) {
        int i;
        for(i =0; i<hits.size(); i++){
            if (hits.get(i) >= timestamp - 299) {
                break;
            }
        }
        return hits.size() - i;
    }

    public static void main(String[] args) {
        HitCounterSimple ht = new HitCounterSimple();
        ht.hits(1);
        ht.hits(2);
        ht.hits(3);
        System.out.println(ht.getHits(4));
        ht.hits(300);
        System.out.println(ht.getHits(300));
        System.out.println(ht.getHits(301));

    }

}
