/**
 * Created by Gene on 6/14/17.
 */
public class LeetCode_155_MinStack {

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */

    //Solution OneStack + Deque 45%
    long min;
    Deque<Long> stack;

    public MinStack(){
        stack = new ArrayDeque<>();
    }

    public void push(int x) {
        if (stack.isEmpty()){
            stack.addLast(0L); //push(0L)
            min = x;
        }else{
            stack.addLast(x-min);//Could be negative if min value needs to change
            if (x<min) {
                min=x;
            }
        }
    }

    public void pop() {
        if (stack.isEmpty()){
            return;
        }
        long pop = stack.removeLast();
        if (pop<0){
            min = min - pop;//If negative, increase the min value
        }
    }

    public int top() {
        long top = stack.peekLast();
        if (top > 0){
            return (int)(top + min);
        }else{
            return (int)(min);
        }
    }

    public int getMin() {
        return (int)min;
    }

    /*
    //Solution - one stack 95%
    long min;
    Stack<Long> stack;

    public MinStack(){
        stack=new Stack<>();
    }
    public void push(int x) {
        if (stack.isEmpty()){
            stack.push(0L);
            min=x;
        }else{
            stack.push(x-min);//Could be negative if min value needs to change
            if (x<min) {
                min=x;
            }
        }
    }
    public void pop() {
        if (stack.isEmpty()){
             return;
        }
        long pop=stack.pop();
        if (pop<0){
            min=min-pop;//If negative, increase the min value
        }
    }

    public int top() {
        long top = stack.peek();
        if (top>0){
            return (int)(top+min);
        }else{
           return (int)(min);
        }
    }

    public int getMin() {
        return (int)min;
    }
    */

    /*
    //Ben 10%
        Deque<Integer> stack ;
        Deque<Integer> minstack   ;

    public MinStack() {
        stack = new ArrayDeque<>();
        minstack   = new ArrayDeque<>();
        // int min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        stack.addLast(x);
        // stackstack.offerLast(x);
        // if (x < min){
            // min = x;
        if(minstack.isEmpty()){
            minstack.addLast(x);
            // minstack.offerLast(min);
        }else{
            minstack.addLast(minstack.peekLast() < x ? minstack.peekLast(): x);
            // minstack.offerLast(min);
        }
    }

    public void pop() {
        //  stackstack.pollLast();
        stack.removeLast();
        //  minstack.pollLast();
        minstack.removeLast();
    }

    public int top() {
        return stack.peekLast();
        // stackstack.get();
        //// minstack.get();
    }

    public int getMin() {
        return minstack.peekLast();
    }
    */
}
