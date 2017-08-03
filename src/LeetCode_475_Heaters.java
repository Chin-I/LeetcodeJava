/**
 * Created by Gene on 7/21/17.
 */
public class LeetCode_475_Heaters {
    //Keen 82%
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int minRange;
        int i = 0;
        int j = 0;
        int ans = 0;
        // for(int i = 0; i < houses.length - 1; i++){
        while(i < houses.length){
            while( j < heaters.length -1 && houses[i]-heaters[j] > heaters[j+1]-houses[i]){ // < len-1
                // if ( Math.abs( houses[i]-heaters[j] ) > Math.abs( houses[i] - heaters[j+1] )) {
                j++;
            }
            ans = Math.max(ans, Math.abs(heaters[j]-houses[i])); //(..)
            i++; //(..)
        }
        return ans;
    }

    /*
    //Gene TLE
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int maxDis = Integer.MIN_VALUE;
        for(int i = 0; i < houses.length; i++){
            int minDis = Integer.MAX_VALUE;
            for(int j = 0; j < heaters.length; j++){
                if (minDis > Math.abs(heaters[j]-houses[i])){
                    minDis = Math.abs(heaters[j]-houses[i]);
                }
            }
            houses[i] = minDis;
        }
        for(int i = 0; i < houses.length; i++){
            if (maxDis < houses[i]){
                maxDis = houses[i];
            }
        }
        return maxDis;
    }
    */
}
