/**
 * Created by Gene on 6/15/17.
 */
public class LeetCode_232_ImplementQueueusingStacks {



//Solution 85% One Stack
/*
class MyQueue {
    Stack<Integer> queue = new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        Stack<Integer> temp = new Stack<Integer>();
        while(!queue.empty()){
            temp.push(queue.pop());
        }
        queue.push(x);
        while(!temp.empty()){
            queue.push(temp.pop());
        }
    }

    // Removes the element from in front of queue.
    public int pop() {
        return queue.pop();
    }

    // Get the front element.
    public int peek() {
        return queue.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return queue.empty();
    }

}
*/

//Gene Two Stack 65% -Push O(1);Pop AmortizedO(1)

    public class MyQueue {
        //Use two stack for one queue!
        Deque<Integer> stack1 ;
        Deque<Integer> stack2 ;
        // int front;
        private int front;

        public MyQueue() {
            stack1 = new ArrayDeque<>();
            stack2 = new ArrayDeque<>();
        }

        public void push(int x) {
            if (stack1.isEmpty()){ //ans
                front = x;   //ans
            }                //ans
            stack1.addLast(x);
            System.out.println("stack1 after push "+stack1);

        }

        public int pop() {

            if (stack2.isEmpty()){    //only one time reverse!
                while(!stack1.isEmpty()){
                    stack2.addLast(stack1.removeLast());
                }
            }
            System.out.println("stack2 ready pop "+stack2);
            int temp = stack2.removeLast();
            System.out.println("stack2 actually pop "+temp);

            return temp;//stack2.removeLast();
        }

        public int peek() {
            if (!stack2.isEmpty()){
                return stack2.peekLast();
            }
            return front;
        }

        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

}
