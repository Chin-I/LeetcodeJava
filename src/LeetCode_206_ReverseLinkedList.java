/**
 * Created by Gene on 6/16/17.
 */
public class LeetCode_206_ReverseLinkedList {

    //Ben-Non-Tail-Recursive  with helper 35%  //(..)
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode dummy = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return dummy;
    }
    /*
    //Gene-Tail-Recursive with helper 35%
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){ //head.next
           return head;
        }

        ListNode dummy = null;  // Not new, but null

        // return dummy;
        return helper(dummy, head);
    }

    private ListNode helper(ListNode pre , ListNode cur){
        if (cur == null){
            return pre;
        }
        ListNode temp = cur.next;
        cur.next = pre;

        return helper(cur,temp);

    }
    */

    /*
    //Gene-Iterative  4%
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){ //head.next
           return head;
        }

        ListNode dummy = null; //new ListNode(-1);   // NO new just Null

        while (head != null){
            ListNode temp = head.next;
            head.next = dummy;
            //
            dummy = head;
            head = temp;
        }
        return dummy;
    }
    */
}
