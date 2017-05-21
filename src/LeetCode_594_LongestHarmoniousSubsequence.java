/**
 * Created by Gene on 5/21/17.
 */
public class LeetCode_594_LongestHarmoniousSubsequence {
    //Gene-Competition-1%
    public int findLHS(int[] nums) {

        HashSet<Integer> unique = new HashSet<>();
        for (int i:nums){
            unique.add(i);
        }

        // System.out.println(unique);

        int res =0;

        for (int i:unique){
            int plus=0;
            int minus=0;
            if (unique.contains(i+1) || unique.contains(i-1) ){
                for(int j=0;j<nums.length;j++){
                    if (i==nums[j] || i+1==nums[j]){
                        plus++;
                    }
                    if (i==nums[j] || i+1==nums[j]){
                        minus++;
                    }
                }

                if (plus>res){
                    res = plus;
                }
                if (minus>res){
                    res = minus;
                }
            }


            //=0;i<nums.length;i++){
            /*
            // System.out.println("i: "+i);
            // System.out.println("i: "+i+" "+nums[i]);
            int temp =0;
            boolean plusexist=false;
            int temp2=0;
            boolean minusexist=false;
            for (int j=0; j<nums.length; j++){
                // System.out.println("j: "+j+" "+nums[j]);
                if (i+1 == nums[j] ){
                    temp++;
                    // System.out.println("temp1-1: "+temp);
                    plusexist=true;
                }
                if (i == nums[j]){
                    temp++;
                    // System.out.println("temp1-2: "+temp);
                }

                if (temp+1 >res && plusexist){
                    // System.out.println("temp1-3: "+temp);
                    res = temp;
                    // System.out.println("=ans=: "+ res);
                }

                if (i-1 == nums[j] ){
                    temp2++;
                    minusexist=true;
                    // System.out.println("temp2-1: "+temp2);
                }
                if (i == nums[j]){
                    temp2++;
                    // System.out.println("temp2-2: "+temp2);
                }
                if (temp2+1 >res && minusexist){
                    // System.out.println("temp2-3: "+temp2);
                    res = temp2;
                    // System.out.println("=ans=: "+ res);
                }
            }
            // System.out.println("------------");*/
        }
        return res;

        // List<Integer> ans = new ArrayList<Integer>();
        // // ans.add(3);
        // // ans.add(4);
        // int res =0;

        // for (int i=0;i<nums.length;i++){
        //     System.out.println("i: "+i+" "+nums[i]);
        //     int temp =0;
        //     boolean plusexist=false;
        //     int temp2=0;
        //     boolean minusexist=false;
        //     for (int j=i+1; j<nums.length; j++){
        //         System.out.println("j: "+j+" "+nums[j]);
        //         if (nums[i]+1 == nums[j] ){
        //             temp++;
        //             System.out.println("temp1-1: "+temp);
        //             plusexist=true;
        //         }
        //         if (nums[i] == nums[j]){
        //             temp++;
        //             System.out.println("temp1-2: "+temp);
        //         }

        //         if (temp+1 >res && plusexist){
        //             System.out.println("temp1-3: "+temp);
        //             res = temp+1;
        //             System.out.println("=ans=: "+ res);
        //         }

        //         if (nums[i]-1 == nums[j] ){
        //             temp2++;
        //             minusexist=true;
        //             System.out.println("temp2-1: "+temp2);
        //         }
        //         if (nums[i] == nums[j]){
        //             temp2++;
        //             System.out.println("temp2-2: "+temp2);
        //         }
        //         if (temp2+1 >res && minusexist){
        //             System.out.println("temp2-3: "+temp2);
        //             res = temp2 + 1;
        //             System.out.println("=ans=: "+ res);
        //         }
        //     }
        //     System.out.println("------------");
        // }

        //     // System.out.println(i);

        // // int[] res = {1,2};//new int[1];
        // // return res;

        // return res;
    }
}
