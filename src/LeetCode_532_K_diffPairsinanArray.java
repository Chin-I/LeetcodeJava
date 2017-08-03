/**
 * Created by Gene on 7/20/17.
 */
public class LeetCode_532_K_diffPairsinanArray {
    /*
  //Discussion T: O(NlogN);S: O(1) 90%
  public int findPairs(int[] nums, int k) {
      int ans = 0;
      Arrays.sort(nums);
      for (int i = 0, j = 0; i < nums.length; i++) {
          for (j = Math.max(j, i + 1); j < nums.length && (long) nums[j] - nums[i] < k; j++) {
          continue ;
          }
          if (j < nums.length && (long) nums[j] - nums[i] == k){
              ans++;
          }
          while (i + 1 < nums.length && nums[i] == nums[i + 1]){
              i++;
          }

      }
      return ans;
  }
  */
        /*
        //Discussion O(N) 23%
        public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0){
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                //count how many elements in the array that appear more than twice.
                if (entry.getValue() >= 2) {
                    count++;
                }
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }

        return count;
    }
        */
    //Keen No Sort 54% O(N)
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (k<0){
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for (int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for (Map.Entry<Integer,Integer> entry: map.entrySet()){ //(..)
            if(k!=0){
                if(map.containsKey(entry.getKey() - k)){
                    count++;
                }
            }else{
                if(entry.getValue()>1){
                    count++;
                }
            }
        }
        return count;
    }
    /*
        //Keen Sort 90% O(NlogN)
    public int findPairs(int[] nums, int k) {
        //Corner Case
        if (nums == null || nums.length == 0){
            return 0;
        }

        //Main
        // k = Math.abs(k);//Clarify avoid minus
        Arrays.sort(nums); //from small to right!  so right - left > 0

        // for (int i:nums){
        //     System.out.println(i);
        // }

        int left = 0;
        int right = 1;
        int count = 0;

        while (right < nums.length){

            // if ( nums[right] - nums[left] < k ) {
            if ( left >= right || nums[right] - nums[left] < k ) { //avoid repea
                // System.out.println("left: "+ left + ";right: "+ right);
                // System.out.println("<k or balance repeat");
                right++; //(..)
                // System.out.println("left: "+ left + ";right: "+ right);
                // System.out.println(" ");

            // }else if ( nums[right] - nums[left] > k) {
            }else if ( nums[right] - nums[left] > k || left > 0 && nums[left] == nums[left-1]) { //avoid repeat

                // System.out.println("left: "+ left + ";right: "+ right);
                // System.out.println(">k or repeat");
                left++; //(..)
                // // System.out.println("left: "+ left + ";right: "+ right);
                // // System.out.println(" ");

            }else{ //    dif == k
                // System.out.println("left: "+ left + ";right: "+ right);
                // System.out.println("==k");
                // System.out.println("count:"+count);
                left++;
                count++;
                // System.out.println("left: "+ left + ";right: "+ right);
                // System.out.println(" ");
            }
        }
        return count;
    }
    */
}
