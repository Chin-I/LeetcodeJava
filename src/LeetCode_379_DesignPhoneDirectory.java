/**
 * Created by Gene on 7/17/17.
 */
public class LeetCode_379_DesignPhoneDirectory {
    //Solution BitSet - 98%
    private BitSet bitset;
    private int max; // max limit allowed
    private int smallestFreeIndex; // current smallest index of the free bit

    public PhoneDirectory(int maxNumbers) {
        this.bitset = new BitSet(maxNumbers);
        this.max = maxNumbers;
    }

    public int get() {
        // handle bitset fully allocated
        if(smallestFreeIndex == max) {
            return -1;
        }
        int num = smallestFreeIndex;
        bitset.set(smallestFreeIndex);
        //Only scan for the next free bit, from the previously known smallest free index
        smallestFreeIndex = bitset.nextClearBit(smallestFreeIndex);//(..)
        return num;
    }

    public boolean check(int number) {
        return bitset.get(number) == false;
    }

    public void release(int number) {
        //handle release of unallocated ones
        if(bitset.get(number) == false)
            return;
        bitset.clear(number);
        if(number < smallestFreeIndex) {
            smallestFreeIndex = number;
        }
    }

    /*
    //Keen 73%
    private Set<Integer> set;

    public PhoneDirectory(int maxNumbers) {
        this.set = new LinkedHashSet<>();

        for (int i = 0; i < maxNumbers; i++){
            set.add(i);
        }
    }

//     Provide a number which is not assigned to anyone.
//     @return - Return an available number. Return -1 if none is available.
    public int get() {

        if (set.isEmpty()){
            return -1;
        }
        Iterator itr = set.iterator(); //(..)   .iterator()
        int val = (int)itr.next();     //(..)   .next()
        set.remove(val);
        return val;
    }

    // Check if a number is available or not.
    public boolean check(int number) {
        return set.contains(number);
    }

    // Recycle or release a number.
    public void release(int number) {
        set.add(number);
    }
    */
}
