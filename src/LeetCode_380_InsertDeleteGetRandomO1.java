/**
 * Created by Gene on 7/18/17.
 */
public class LeetCode_380_InsertDeleteGetRandomO1 {

    import java.util.Random;

        private HashMap<Integer, Integer> keyMap = null;
        private HashMap<Integer, Integer> valueMap = null;
        int count;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            keyMap = new HashMap<Integer, Integer>();
            valueMap = new HashMap<Integer, Integer>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(keyMap.containsKey(val)) {
                return false;
            } else {
                keyMap.put(val, count);
                valueMap.put(count, val);
                count = keyMap.size();
                return true;
            }
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if(!keyMap.containsKey(val)) {
                return false;
            } else {
                int valueKey = keyMap.get(val);
                keyMap.remove(val);
                if(valueKey != valueMap.size() - 1) {
                    valueMap.put(valueKey, valueMap.get(valueMap.size() - 1));
                    keyMap.put(valueMap.get(valueMap.size() - 1), valueKey);
                    valueMap.remove(valueMap.size() - 1);
                } else {
                    valueMap.remove(valueKey);
                }
                count = keyMap.size();
                return true;
            }
        }

        /** Get a random element from the set. */
        public int getRandom() {
            Random random = new Random();
            int n = random.nextInt(keyMap.size());
            return valueMap.get(n);
        }

/*

    //Keen 33%
    // Map<Integer,Integer> (val,idx)
    // Initialize your data structure here.
    private Map<Integer,Integer> map;
    private List<Integer> list;
    private Random ran;

    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        this.ran = new Random(); //(..) this
    }

    // Inserts a value to the set. Returns true if the set did not already contain the specified element.
    public boolean insert(int val) {
        Integer idx = map.get(val) ;
        if ( idx != null){
            return false;
        }

        map.put(val,list.size());//(..)
        list.add( val );
        return true;
    }

    // Removes a value from the set. Returns true if the set contained the specified element.
    public boolean remove(int val) {
        Integer idx = map.get(val);
        if (idx == null){
            return false;
        }

        if (idx != list.size() -1 ){
            // int last = list.size(); //(..)
            int last = list.get( list.size() - 1);//value
            System.out.println("last: "+last);
            list.set(idx, last); //(pos, value)
            // map.put(val,last)
            map.put(last, idx);//(val,pos)
        }
        //(..)
        map.remove(val);
        list.remove(list.size()-1);
        return true;
    }

    // Get a random element from the set.
    public int getRandom() {
        // return Random(list.size()); //(..)
        return list.get(ran.nextInt(list.size()));
    }

*/
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
