/**
 * Created by Gene on 7/29/17.
 */
public class LeetCode_436_FindRightInterval {

    //Keen - TreeMap  T:O(N*logN);S:O(N) 50%
    public int[] findRightInterval(Interval[] intervals) {

        if (intervals == null || intervals.length == 0){
            // return (int)intervals;
            return new int[0];
        }

        int[] ans = new int[intervals.length];
        TreeMap<Integer,Integer> map = new TreeMap<>();

        for(int i = 0; i< intervals.length;i++){
            map.put(intervals[i].start,i); //put start as key, index as value;
        }

        for(int i=0;i<intervals.length;i++){
            Integer key = map.ceilingKey(intervals[i].end); //ceilingKey
            ans[i] = (key!=null) ? map.get(key): -1;
        }

        // // for (int i=0;i<intervals.length;i++){
        // //     System.out.println(i);

        // //     System.out.println(intervals[i]);
        // // }

        // for (int i=0;i<intervals.length;i++){
        //     int min = Integer.MAX_VALUE;
        //     int flag = 0;
        //     for (int j=0;j<intervals.length;j++){
        //         // if(i>j){
        //         System.out.println(" j-start >= i-end "+intervals[j].start+" >= "+intervals[i].end);
        //         if ( intervals[j].start >= intervals[i].end){
        //             System.out.println("Use "+j);
        //             min = Math.min(min,j);
        //             flag = 1;
        //         // }else{
        //         //     min = -1;
        //         }
        //     }
        //     if (flag == 0){
        //         ans[i] = -1;
        //     }else{
        //     ans[i]=min;
        //     }
        // }
        return ans;
    }



    //I.Brute Force T:O(N^2),S:O(N)
    //II.Sort+Scan T:O(N^2),S:O(N)
    //III.Using Sorting + Binary Search T:O(N*logN);S:O(N) 16%
    /*
        public Interval binary_search(Interval[] intervals, int target, int start, int end) {
        if (start >= end) {
            if (intervals[start].start >= target) {
                return intervals[start];
            }
            return null;
        }
        int mid = (start + end) / 2;
        if (intervals[mid].start < target) {
            return binary_search(intervals, target, mid + 1, end);
        } else { //(..) >=
            return binary_search(intervals, target, start, mid);
        }
    }

    public int[] findRightInterval(Interval[] intervals) {
        int[] res = new int[intervals.length];
        HashMap<Interval, Integer> hash = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            hash.put(intervals[i], i);
        }
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        for (int i = 0; i < intervals.length; i++) {
            Interval interval = binary_search(intervals, intervals[i].end, 0, intervals.length - 1);
            res[hash.get(intervals[i])] = interval == null ? -1 : hash.get(interval);
        }
        return res;
    }
    */
    /*
    //IV TreeMap 70% T:O(N*logN);S:O(N)
    public int[] findRightInterval(Interval[] intervals) {
        TreeMap<Integer, Integer> starts = new TreeMap<>();
        int res[] = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts.put(intervals[i].start, i);
        }
        for (int i = 0; i < intervals.length; i++) {
            Map.Entry<Integer, Integer> pos = starts.ceilingEntry(intervals[i].end);
            res[i] = pos == null ? -1 : pos.getValue();
        }
        return res;
    }
    */
    /*
    //V Using Two Arrays without Binary Search T:O(N*logN);S:O(N) 12%
    public int[] findRightInterval(Interval[] intervals) {
        Interval[] endIntervals = Arrays.copyOf(intervals, intervals.length);
        HashMap<Interval, Integer> hash = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            hash.put(intervals[i], i);
        }
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        Arrays.sort(endIntervals, (a, b) -> a.end - b.end);
        int j = 0;
        int[] res = new int[intervals.length];
        for (int i = 0; i < endIntervals.length; i++) {
            while (j < intervals.length && intervals[j].start < endIntervals[i].end) {
                j++;
            }
            res[hash.get(endIntervals[i])] = j == intervals.length ? -1 : hash.get(intervals[j]);
        }
        return res;
    }
    */

}
