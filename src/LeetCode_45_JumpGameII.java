/**
 * Created by Gene on 5/21/17.
 */
public class LeetCode_45_JumpGameII {
    //Keen W8 -95%
    public int jump(int[] nums) {
        if (nums==null || nums.length==0){
            return 0;
        }
        int[] min = new int[nums.length];
        int curIndex=0;
        min[0]=0;
        for (int r=1;r<nums.length;r++){
            for (int l=curIndex;l<r;l++){ //l<r not l<nums.length
                if(l+nums[l] >= r ){      //>= not >
                    // min[l]=l;(..)Wrong
                    min[r] = min[l]+1;
                    curIndex=l;
                    break;
                }
            }
        }
        return min[nums.length-1];
    }
}
