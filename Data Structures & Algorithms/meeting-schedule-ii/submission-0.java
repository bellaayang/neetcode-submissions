/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];

        for (int i = 0; i < intervals.size(); i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int max = 0;
        int room = 0;
        int e = 0;
        for (int s = 0; s < intervals.size(); s++) {
            if (start[s] < end[e]) {
                room++;
            } else {
                e++;
            }
            max = Math.max(max, room);
        }

        return max;

    }
}
