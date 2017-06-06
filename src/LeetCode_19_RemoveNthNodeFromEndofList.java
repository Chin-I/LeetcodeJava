/**
 * Created by Gene on 6/6/17.
 */
public class LeetCode_19_RemoveNthNodeFromEndofList {

    /*
    //Solution  15%
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start;
        ListNode fast = start;
        slow.next = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for(int i=1; i<=n+1; i++)   {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }
    */

    //Gene 6%
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null){
            return null;
        }
        // if (head.next==null && n == 1){
        //     return null;
        // }
        int count = 0;
        ListNode dummy = new ListNode(-1);
        ListNode pre = new ListNode(-1);
        ListNode cur = new ListNode(-1);

        dummy.next = head;
        pre.next = cur;
        cur = head;

        while (cur != null){
            count++;
            cur = cur.next;
        }
        int targetindex = count - n ;
        // System.out.println("targetindex: "+targetindex);
        count = 0;
        cur = dummy; //(..)
        while (count < targetindex ){
            count++;
            cur = cur.next;
        }

        if (cur != null && cur.next != null ){
            cur.next = cur.next.next;
        }
        return dummy.next;
    }

}
