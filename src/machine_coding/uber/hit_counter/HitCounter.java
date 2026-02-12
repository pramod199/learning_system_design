package machine_coding.uber.hit_counter;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/discuss/post/178662/design-a-hit-counter-by-shashibk11-mqzz/
https://algo.monster/liteproblems/362

 */
public class HitCounter {
    private List<Integer> timestamps = new ArrayList<>();

    public HitCounter() {
    }

    // O(1)
    public void hit(int timestamp) {
        timestamps.add(timestamp);
    }

    public int getHits(int timestamp) {
        // Find the index of the first timestamp that is within the 300-second window
        // We search for the leftmost position where timestamp >= (currentTime - 299)
        int leftBoundaryIndex = findLowerBound(timestamp - 300 + 1);

        // All elements from leftBoundaryIndex to the end are within the 300-second windowi\
        int ans = timestamps.size() - leftBoundaryIndex;
        System.out.println(ans);
        return ans;
    }

    private int findLowerBound(int target) {
        int left = 0;
        int right = timestamps.size() - 1;
        int ans = timestamps.size();
        while (left <= right) {
            int mid = (left + right) / 2;
            if (timestamps.get(mid) >= target) {
                ans = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        HitCounter counter = new HitCounter();
        counter.hit(1);
        counter.hit(2);
        counter.hit(4);
        counter.getHits(2);
        counter.getHits(5);

        counter.hit(300);
        counter.getHits(300);

//        counter.hit(301);
        counter.getHits(301);


    }

}
