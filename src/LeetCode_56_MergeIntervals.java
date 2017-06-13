/**
 * Created by Gene on 6/13/17.
 */
public class LeetCode_56_MergeIntervals {

    //Solution -override + keen 67%
    public List<Interval> merge(List<Interval> intervals) {


        //corner
        if (intervals == null || intervals.size() == 0){
            return intervals;
        }
        //main
        List<Interval> ans = new ArrayList<>();

        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval obj0, Interval obj1) {
                return obj0.start - obj1.start;
            }
        });

        //(..) Sort
        // Collections.sort( intervals,(o1,o2)->Integer.compare(o1.start,o2.start) );

        // Interval last = new Interval(intervals[0][0],intervals[0][1]); //(..) ?
        int lastStart = intervals.get(0).start; //(..)
        int lastEnd   = intervals.get(0).end;

        for (Interval i: intervals){
            if (i.start > lastEnd){
                // ans.put(last.start,last.end);
                ans.add( new Interval(lastStart,lastEnd));
                lastStart = i.start;
                lastEnd   = i.end;
            }else{
                lastEnd = Math.max(lastEnd,i.end);
            }
        }
        // ans.put(last.start,last.end);
        ans.add(new Interval(lastStart,lastEnd));
        return ans;
    }

    /*
    //Solution -over ride43%
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval obj0, Interval obj1) {
                return obj0.start - obj1.start;
            }
        });

        List<Interval> ret = new ArrayList<>();
        Interval prev = null;
        for (Interval inter : intervals) {
            if (  prev==null || inter.start>prev.end ) {
                ret.add(inter);
                prev = inter;
            } else if (inter.end>prev.end) {
                // Modify the element already in list
                prev.end = inter.end;
            }
        }
        return ret;
    }
    */
    /*
    //Solution 10%
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1)
            return intervals;

        // Sort by ascending starting point using an anonymous Comparator
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

        List<Interval> result = new LinkedList<Interval>();
        int start = intervals.get(0).start; //(..)
        int end = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (interval.start <= end) // Overlapping intervals, move the end if needed
                end = Math.max(end, interval.end);
            else {                     // Disjoint intervals, add the previous one and reset bounds
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        // Add the last interval
        result.add(new Interval(start, end));
        return result;
    }
    */
    /*
    // keen 0.5%
    public List<Interval> merge(List<Interval> intervals) {
        //corner
        if (intervals == null || intervals.size() == 0){
            return intervals;
        }
        //main
        List<Interval> ans = new ArrayList<>();

        //(..) Sort
        Collections.sort( intervals,(o1,o2)->Integer.compare(o1.start,o2.start) );

        // Interval last = new Interval(intervals[0][0],intervals[0][1]); //(..) ?
        int lastStart = intervals.get(0).start; //(..)
        int lastEnd   = intervals.get(0).end;

        for (Interval i: intervals){
            if (i.start > lastEnd){
                // ans.put(last.start,last.end);
                ans.add( new Interval(lastStart,lastEnd));
                lastStart = i.start;
                lastEnd   = i.end;
            }else{
                lastEnd = Math.max(lastEnd,i.end);
            }
        }
        // ans.put(last.start,last.end);
        ans.add(new Interval(lastStart,lastEnd));
        return ans;
    }
    */
}
