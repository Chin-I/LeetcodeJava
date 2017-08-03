/**
 * Created by Gene on 7/24/17.
 */
public class LeetCode_134_GasStation {
    //Keen O(N) 60%
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //corner
        if (gas == null || cost == null){
            return -1;
        }

//         if (gas.length == 0 || cost.length == 0){
//             return -1
//         }
        //main
        int beg = gas.length-1; //(..)
        int end = 0;            //(..)
        int sum = gas[beg] - cost[beg];

        while (end < beg){
            if (sum < 0){
                sum += gas[--beg] - cost[beg];
            }else{
                sum += gas[end] - cost[end++];
            }
        }
        return sum>=0 ? beg : -1;
    }
    /*
    //Gene Fail - how traversal?
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //corner case
        int ans;
        if ( gas == null || gas.length == 0){
            return 0;
        }
        Deque<Integer> que = new ArrayDeque<>();
        int len = gas.length;

        //main
        for (int i = 0; i < len; i++){
            int count = 0;
            int sum = 0;

            while (count < len){
                sum = sum + que.offerFirst(gas[i]-cost[i]);
                count++;

                if (sum < 0){
                    break;
                }
            }

            if (sum >= 0){
                    return i;
            }
        }
        return -1;
        // return ans;
    }
    */
}
