/**
 * Created by Gene on 7/17/17.
 */
public class LeetCode_170_TwoSumIII_DataStructureDesign {

    //Keen 75%    More Add Less Find
    // Initialize your data structure here.
    private Map<Integer,Integer> map; //private final
    private List<Integer> list;     // private final


    public TwoSum() {
        map = new HashMap<>(); //private final
        list = new ArrayList<>();     // private final
    }

    // Add the number to an internal data structure..
    public void add(int number) {
        list.add(number);//(..)

        if (map.get(number) == null){
            map.put(number,1); //(..)
        }else{
            map.put(number,map.get(number)+1);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        for(int cur : list){
            int target = value - cur;
            Integer count = map.get(target); //(..) Integer
            // System.out.println("count: "+count);
            if (count != null ){
                if (cur != target || (cur == target) && count >=2){
                    return true;
                }
            }
        }
        return false;
    }

}
