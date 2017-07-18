/**
 * Created by Gene on 7/17/17.
 */
public class LeetCode_346_MovingAveragefromDataStream {
    //Keen 70%
    /** Initialize your data structure here. */
    private Deque<Integer> queue;
    private int sum;
    private int size;

    public MovingAverage(int size) {
        this.queue = new ArrayDeque<>();
        this.sum = 0;
        this.size = size;
    }

    public double next(int val) {
        if (queue.size() == size){
            int last = queue.pollFirst();
            sum -= last;
        }
        queue.offerLast(val);
        sum += val;
        return sum/1.0/queue.size();

    }
}
