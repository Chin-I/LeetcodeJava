/**
 * Created by Gene on 7/24/17.
 */
public class LeetCode_84_LargestRectangleinHistogram {

    /*
    //Solution 55%
    public int largestRectangleArea(int[] heights) {
        Stack < Integer > stack = new Stack < > ();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            stack.push(i);
        }
        int lastIndex = stack.peek();
        while (stack.peek() != -1)
            maxarea = Math.max(maxarea, heights[stack.pop()] * (lastIndex - stack.peek()));
        return maxarea;
    }
    */


    //Mem-1
    public int largestRectangleArea(int[] heights) {
        //corner
        if (heights == null || heights.length == 0){
            return 0;
        }
        //main
        int max = Integer.MIN_VALUE;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0 ; i <= heights.length; i++){ // <=

            int curVal = i == heights.length ? 0: heights[i]; //Exception

            while( !stack.isEmpty() && heights[stack.peekLast()] >= curVal){ //heights[stack.peekLast()]   >=

                int height = heights[stack.pollLast()];
                int left = stack.isEmpty() ? 0: stack.peekLast() + 1 ; //stack.isEmpty()  // stack.peekLask() +1
                int right = i ;
                max = Math.max(max,(right - left)*height);
            }
            stack.offerLast(i);
        }
        return max;
    }


/*
    //keen 91%   O(N)
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0){
            return 0;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int leftIndex = 0, rightIndex = 0;
        int max = 0;
        // from left to right if increase
        for(int i = 0; i <= heights.length; i++){  // <= important

            int curVal = i == heights.length ? 0 : heights[i];

            while( !stack.isEmpty() && heights[stack.peekLast()] >= curVal ){ // find Left;
                int height = heights[stack.pollLast()];
                leftIndex = stack.isEmpty()? 0 : stack.peekLast() + 1;  // cause poll before
                // System.out.println("leftIndex: " + leftIndex);
                rightIndex = i;
                // System.out.println("rightIndex: " + i);
                // System.out.println("area: "+height * (rightIndex - leftIndex ) );
                max = Math.max( max, height * (rightIndex - leftIndex ));
                // System.out.println("max: "+ max);
            }
        // System.out.println("== inputIndex: "+i+"==");

        stack.offerLast(i);  //find Right;
        }
        return max;
    }
*/
}
