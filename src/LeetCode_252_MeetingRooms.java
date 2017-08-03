/**
 * Created by Gene on 7/30/17.
 */
public class LeetCode_252_MeetingRooms {

    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() { //(..)
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i].end > intervals[i + 1].start) {
                return false;
            }
        }
        return true;
    }

    /*
    //Solution 33%
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0){
            return true;
        }

        // for (Interval interval: intervals){
        Arrays.sort(intervals,(a,b) -> a.start - b.start);
        // }

        for (int i = 1; i<intervals.length; i++){

            if (intervals[i].start < intervals[i-1].end ){
                return false;
            }

        }
        return true;
    }
    */
}
