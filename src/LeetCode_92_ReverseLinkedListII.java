/**
 * Created by Gene on 6/13/17.
 */
public class LeetCode_92_ReverseLinkedListII {
            /*
        //Solution - Two PASS 2%
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if (head==null || head.next==null){
                return head;
            }

            ListNode preHead=new ListNode(0);
            preHead.next=head;

            ListNode pre=preHead;
            ListNode current=head;
            ListNode end=head;

            int countM=1;
            int countN=1;
            // find M point and N point
            while (countM<m || countN<n ){
                if (countM<m){
                    pre=pre.next;
                    current=current.next;
                    countM++;
                }

                if (countN<n){
                    end=end.next;
                    countN++;
                }
            }

            // reverse from M point to N Point
            reverse(pre, end.next);
            return preHead.next;

        }

        private void reverse(ListNode pre, ListNode endNext){
            ListNode cur=pre.next;

            while (cur.next!=endNext){

                ListNode next=cur.next;
                ListNode temp=pre.next;
                pre.next=next;
                cur.next=next.next;

                next.next=temp;

            }
        }
    */
    /*
        //Solution -One-Pass 18%  <m ;==m ; >m
        public ListNode reverseBetween(ListNode head, int m, int n) {
    	ListNode dummyhead = new ListNode(0);
    	dummyhead.next = head;
    	ListNode sublisthead = new ListNode(0);
    	ListNode sublisttail = new ListNode(0);
    	int count = 1;
    	ListNode pre_cur = dummyhead, cur = head;
    	while(count <=n){
    		ListNode temp = cur.next;
    		if (count < m)
    			pre_cur = cur;
    		else if (count == m){
    			sublisttail = cur;
    			sublisthead.next = cur;
    		}else if (count > m){
    			cur.next = sublisthead.next;
    			sublisthead.next = cur;
    		}
    		cur = temp;
    		++count;
    	}
    	pre_cur.next = sublisthead.next;
    	sublisttail.next = cur;
    	return dummyhead.next;
    }
    */

    // Keen-OnePass 18%
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
        dummy.next = head;
        ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
        for(int i = 0; i<m-1; i++) pre = pre.next;

        ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
        ListNode then = start.next; // a pointer to a node that will be reversed

        // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
        // dummy-> 1 -> 2 -> 3 -> 4 -> 5

        for(int i=0; i<n-m; i++)
        {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
        // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)

        return dummy.next;

    }
}
