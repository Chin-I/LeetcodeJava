/**
 * Created by Gene on 6/6/17.
 */
public class LeetCode_605_CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        //corner case
        if (flowerbed.length == 1){
            if (flowerbed[0] == 0 ){
                return true;
            }else if (flowerbed[0] == 1 && n == 0){
                return true;
            }
            else if (flowerbed[0] == 1 && n == 1 ){
                return false;
            }
        }

        //main
        if (flowerbed[0] == 0 && flowerbed[1] == 0){
            count++;
            flowerbed[0] = 1;
        }


        for (int i=1; i<flowerbed.length-1;i++){

            if (flowerbed[i-1] == 0 && flowerbed[i] == 0 && flowerbed[i+1] == 0){
                count ++;
                // System.ou
                flowerbed[i] = 1;
                // System.out.println(i);
                // for (int j: flowerbed){
                // System.out.print(j);
                // }
                // System.out.println("");
            }
        }

        if (flowerbed[flowerbed.length-2] == 0 && flowerbed[flowerbed.length-1] == 0){
            count++;
            flowerbed[flowerbed.length-1] = 1;
        }

        if (n <= count){
            // System.out.println("count: "+count);
            return true;
        }
        return false;
    }
}
