/**
 * Created by Gene on 5/27/17.
 */
public class LeetCode_599_MinimumIndexSumofTwoLists {
    //Solution T:O(M+N) S:O(M+N)

    //list.indexOf("banana");
    //Arrays.asList(list1).indexOf(i);

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer> map = new HashMap<>();

        // for (String s: list1){
        for (int i=0; i<list1.length; i++){
            map.put(list1[i],i);
        }

        int minSum = Integer.MAX_VALUE;
        List<String> ans = new LinkedList<>(); //new

        // for (String s:list2){
        for (int i=0; i<list2.length;i++){
            // if (map.get() )
            Integer j = map.get( list2[i] );  //(..) j from list1
            if (j != null){
                if (i+j < minSum){
                    minSum = i+j;
                    ans = new LinkedList<>();
                    ans.add(list2[i]);//list2[i]
                }
                else if(i+j == minSum){
                    ans.add(list2[i]);  //list2[i]
                }
            }
        }
        return ans.toArray( new String[ ans.size() ] ); //(..) String[]
    }

}
