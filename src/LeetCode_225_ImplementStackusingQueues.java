/**
 * Created by Gene on 6/1/17.
 */
public class LeetCode_225_ImplementStackusingQueues {


    //Solution 94%-> one queue push O(N);pop O(1)
    private Queue<Integer> queue = new LinkedList<Integer>();//94%

    // Queue<Integer> queue;//77%

    // public MyStack()
    // {
    //     this.queue=new LinkedList<Integer>();
    // }

    // Push element x onto stack.
    public void push(int x)
    {
        queue.add(x);
        for(int i=0;i<queue.size()-1;i++)
        {
            queue.add(queue.poll());
        }
        return;
    }

    // Removes the element on top of the stack.
    public int pop()
    {
        return queue.poll();
        // return ;
    }

    // Get the top element.
    public int top()
    {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty()
    {
        return queue.isEmpty();
    }


//////////////////////////////////////////////////
    // // Solution 94% -Two Queue push O(n);pop O(1)
    // private Queue<Integer> q1 = new LinkedList<>(); //96%
    // private Queue<Integer> q2 = new LinkedList<>();
    // private int top;
    // // Queue <Integer> q1;//44%
    // // Queue <Integer> q2;

    // // public MyStack()
    // // {
    // //     this.q1 = new LinkedList<Integer>();
    // //     this.q2 = new LinkedList<Integer>();
    // // }

    // public void push(int x){
    //     q2.add(x);
    //     top = x;
    //     while( !q1.isEmpty()){
    //         q2.add(q1.remove());
    //     }
    //     Queue<Integer> temp = q1;
    //     q1 = q2;
    //     q2 = temp;
    //     return;
    // }

    // public int pop(){
    //     return q1.remove();
    // }

    // // Get the top element.
    // public int top() {
    //     return q1.peek();
    // }

    // // Return whether the stack is empty.
    // public boolean empty() {
    //     return q1.isEmpty();
    // }



// ////////////////////////////////////////////////

// //     // Solution-Two Queue 77% push O(1),popO(n)
//     private Queue<Integer> q1 = new LinkedList<>();//93%
//     private Queue<Integer> q2 = new LinkedList<>();
//     private int top;

//     // Queue <Integer> q1;  //48%
//     // Queue <Integer> q2;

//     // public MyStack()
//     // {
//     //     this.q1 = new LinkedList<Integer>();
//     //     this.q2 = new LinkedList<Integer>();
//     // }


//     public void push(int x){
//         q1.add(x);
//         top = x;
//     }

//     public int pop(){
//         while (q1.size() > 1){
//             top = q1.remove();
//             q2.add(top);
//         }
//         top = q1.remove();
//         Queue<Integer> temp = q1;
//         q1 = q2;
//         q2 = temp;
//         return top;
//     }

//     // Get the top element.
//     public int top()
//     {
//         while (q1.size() > 0){
//             top = q1.remove();
//             q2.add(top);
//         }
//         Queue<Integer> temp = q1;
//         q1 = q2;
//         q2 = temp;
//         return top;
//     }

//     // Return whether the stack is empty.
//     public boolean empty()
//     {
//         return q1.isEmpty();
//     }

}
