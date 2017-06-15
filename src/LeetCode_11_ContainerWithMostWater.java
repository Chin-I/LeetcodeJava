/**
 * Created by Gene on 6/14/17.
 */
public class LeetCode_11_ContainerWithMostWater {

    //Ben 61% T:O(N); S:O(1)
    public int maxArea(int[] height) {
        //corner
        if (height == null || height.length == 0){
            return 0;
        }

        //main
        int len = height.length;
        int l = 0;
        int r = height.length-1;
        int area = 0;
        while (l < r){  // l only < r ?
            if (height[l] <= height[r]){
                // if ( (r-l) * Math.min(height[l],height[r]) > area){ //33%
                // area = (r-l) * Math.min(height[l],height[r]);
                // }
                area = Math.max((r-l)*height[l],area);
                l ++;
            }
            if (height[l] >= height[r]){
                // if ( (r-l)*Math.min(height[l],height[r]) > area){ //33%
                //     area = (r-l)*Math.min(height[l],height[r]);
                // }
                area = Math.max((r-l)*height[r],area);
                r--;
            }
        }
        return area;
    }

    /*
    // Brute Force TLE
    public int maxArea(int[] height) {
        int maxarea = 0;
        for (int i = 0; i < height.length; i++)
            for (int j = i + 1; j < height.length; j++)
                maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
        return maxarea;
    }
    */
}
