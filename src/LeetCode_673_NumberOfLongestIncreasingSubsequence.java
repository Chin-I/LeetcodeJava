/**
 * Created by Gene on 9/11/17.
 */
public class LeetCode_673_NumberOfLongestIncreasingSubsequence {
    //Discussion  39ms
    //Java with explanation, easy to understand
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] maxLens = new int[nums.length];// length of longest increasing sequence start from i
        int[] counts = new int[nums.length]; // number of length of longest increasing sequence start from i
        int maxLen = 1; // length of longest increasing subsequnce
        maxLens[nums.length-1] = 1;
        counts[nums.length-1] = 1;

        for(int i = nums.length -2; i>=0; i--){
            //Backward iteration, i is used as the first character
            int curMax = 1;
            int count = 1;
            for(int j = i+1; j < nums.length; j++) {//j is used as the second character
                if(nums[i] < nums[j]){//increasing number
                    if (curMax == maxLens[j]+1)//means have another way to reach the same max length increasing sequence
                        count += counts[j];  //Important: not ++
                    else if (curMax < maxLens[j]+1){
                        count = counts[j];
                        curMax = maxLens[j]+1;
                    }
                }
            }

            maxLens[i] = curMax;
            counts[i] = count;
            maxLen = Math.max(maxLen, curMax);

        }
        for (int i = 0; i < nums.length; i++){
            System.out.println("maxLens[i]");
            System.out.print(Integer.toString(maxLens[i])+" ");

        }

        for (int i = 0; i < nums.length; i++){
            System.out.println("counts[i]");
            System.out.print(Integer.toString(counts[i])+" ");

        }

        int count = 0;
        for(int i = 0; i< maxLens.length; i++){//check each possible start position
            if (maxLens[i] == maxLen)
                count += counts[i];
        }
        return count;
    }


    /*
    //Discussion 40ms [Java/C++] Simple dp solution with explanation
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;

        int[] dp = new int[n];
        int[] next = new int[n];
        dp[n - 1] = 1; next[n - 1] = 1;
        int len = 1;
        for (int i = n - 2; i >= 0; i--) {
            int max = 0, cnt = 0;
            for (int j = i + 1; j < n; j++){
                if (nums[j] > nums[i]){
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            len = Math.max(len, dp[i]);
            if (dp[i] == 1) next[i] = 1;
            else {
                for(int j = i + 1; j < n; ++j){
                    if(nums[j] > nums[i] && dp[j] == max){
                        next[i] += next[j];
                    }
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (dp[i] == len){
                res += next[i];
            }
        }
        return res;
    }
    */

    /*
//Discussion #41ms
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, res = 0, max_len = 0;
        int[] len =  new int[n], cnt = new int[n];
        for(int i = 0; i<n; i++){
            len[i] = cnt[i] = 1; //initial!

            for(int j = 0; j <i ; j++){
                if(nums[i] > nums[j]){
                    if(len[i] == len[j] + 1){
                        //?//means have another way to reach the same max length increasing sequence
                        cnt[i] += cnt[j];
                    }
                    if(len[i] < len[j] + 1){ //stop increase
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }

            if(max_len == len[i]){
                res += cnt[i];
            }
            if(max_len < len[i]){
                max_len = len[i];
                res = cnt[i];
            }
        }

        return res;
    }
    */

    /*
    public int findNumberOfLIS(int[] nums) {
        int max = 0;
        int counter = 0;

        //corner
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return 1;
        }

        //Always increase
        int corner = 1;
        for (int i = 0; i < nums.length-1; i++){
            if (nums[i] < nums[i+1]){
                corner++;
            }
            if (corner == nums.length){
                return 1;
            }
        }

        // if (nums.length == 2){
        //     if(nums[0]<nums[1]){
        //         return 1;
        //     }else{
        //         return 2;
        //     }
        // }

        //step1 set
        int[] dp = new int[nums.length];
        List<List<String>> sol = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            sol.add(new ArrayList<>());
        }
        //step 2 initial
        dp[0] = 1;
        sol.get(0).add(Integer.toString(nums[0]));
        for (int i = 1; i < nums.length; i++){
            for (int j = 0; j < i; j++){
                if (nums[j] < nums[i]){
                    int temp = dp[j]+1;
                    // sol.get()
                    for (String l:sol.get(j)){
                    // sol.get(i).add( sol.get(j)+Integer.toString(nums[i]) );
                        sol.get(i).add( l + Integer.toString(nums[i]) );
                    }
                    dp[i] = temp;
                }else{
                    dp[i] = dp[j];

                    for (String l:sol.get(j)){

                        // sol.get(i).add( sol.get(j)+Integer.toString(nums[i]) );
                        if (sol.get(i).isEmpty()){
                            sol.get(i).add( l  );
                        }
                    }

                    //.add( Integer.toString(nums[j])  );

                    // for (String l:sol.get(j)){
                    // sol.get(i).add( sol.get(j)+Integer.toString(nums[i]) );
                        // sol.get(i).add( l  );
                    // }
                }
                // for (List<String> k:sol){
                //     System.out.println(k);
                // }
                // System.out.println("");
            }
        }

        for (int i: dp){
            System.out.print(i);
        }
        System.out.println("");

        // dp[i]
         for (List<String> i:sol){
             System.out.println(i);
         }
        //{1,3,5,4,7} //end!
        // [1]
        // [13]
        // [15, 135]
        // [14, 134]
        // [17, 137, 157, 1357, 147, 1347]
        // System.out.println(sol.get(dp[nums.length-1]).size());
        System.out.println("");
        for (List<String> list:sol){
            for (String s:list){
                if (s.length() == dp[nums.length - 1]){
                    counter++;
                }
                // System.out.println("");
            }
            // System.out.println(s);
        }
        return counter;
    }
//     }*/
}
