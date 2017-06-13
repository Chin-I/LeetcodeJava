/**
 * Created by Gene on 6/8/17.
 */
public class LeetCode_203_RemoveLinkedListElements {
    //Ben 66% (one dummy and cur)
    public ListNode removeElements(ListNode head, int val) {

        // if (head == null){
        //     return null;
        // }

        ListNode dummy = new ListNode(-1);
        // ListNode cur = head;
        // ListNode pre = new ListNode(-1);
        // pre.next = cur;
        dummy.next = head;
        // cur = dummy;
        ListNode cur = dummy;//new ListNode();
        while (cur != null && cur.next != null){ //cur.next != null
            if (cur.next.val == val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
