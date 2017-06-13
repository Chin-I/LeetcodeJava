/**
 * Created by Gene on 6/8/17.
 */
public class LeetCode_141_LinkedListCycle {
    // Gene+Ben7%
    public boolean hasCycle(ListNode head) {

        if (head == null){
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast){
                return true;
            }
        }
        return false;
    }
}
