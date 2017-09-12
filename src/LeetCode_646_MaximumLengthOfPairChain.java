/**
 * Created by Gene on 9/11/17.
 */
public class LeetCode_646_MaximumLengthOfPairChain {
    //Discussion Java O(nlog(n)) Time O(1) Space 51%
    public int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs, (a,b) -> a[1] - b[1]); //(..)

        int sum = 0, n = pairs.length, i = -1;
        while (++i < n) {
            sum++;
            int curEnd = pairs[i][1];
            while (i+1 < n && pairs[i+1][0] <= curEnd) {
                i++;
            }
        }
        return sum;
    }

    /*
    //Discussion easy dp 9% TO(N^2)
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) {
            return 0;
        }

        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));

        int[] dp = new int[pairs.length];

        Arrays.fill(dp, 1);

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], pairs[i][0] > pairs[j][1]? dp[j] + 1 : dp[j]);
            }
        }
        return dp[pairs.length - 1];
    }
    */
    /*
    //Gene
    public int findLongestChain(int[][] pairs) {
        // corner
        int maxcounter = 0;
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < pairs.length; i++){
            ans.add(new ArrayList<>());
        }

        //transfer from pairs to List<List<Integer>>()
        for (int[] p: pairs){



        }


        // inorder by p[1];


        // for (int[] p:pairs){
        for (int i = 0; i < pairs.length; i++){

            // List<List<int[]>>() ans = new ArrayList<> ();
            int counter = 0;
            for (int j = i+1; j < pairs.length; j++){

                if (pairs[i][1] < pairs[j][0]){
                    pairs[i][1] = pairs[j][0];
                    counter++;
                }

            }
            if (maxcounter < counter){
                maxcounter = counter;
            }
        }
            //order by p[1];
            // if(p)
        return maxcounter;
    }
    */
}
