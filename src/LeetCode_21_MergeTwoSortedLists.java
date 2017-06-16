/**
 * Created by Gene on 6/15/17.
 */
public class LeetCode_21_MergeTwoSortedLists {
    //Solution 70% Iterative
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode returnNode = new ListNode(-1);
        ListNode headNode = returnNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                returnNode.next = l1;
                l1 = l1.next;
            } else {
                returnNode.next = l2;
                l2 = l2.next;
            }
            returnNode = returnNode.next;
        }
        if (l1 == null) {
            returnNode.next = l2;
        } else if (l2 == null) {
            returnNode.next = l1;
        }
        return headNode.next;
    }
        /*
    //Solution Recursive 37%

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode mergeHead;
        if(l1.val < l2.val){
            mergeHead = l1;
            mergeHead.next = mergeTwoLists(l1.next, l2);
        }
        else{
            mergeHead = l2;
            mergeHead.next = mergeTwoLists(l1, l2.next);
        }
        return mergeHead;
    }
    */

    /*
    //Solution 37% Iterative
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode result = new ListNode(0);
        ListNode prev = result;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        if (l1 != null) {
            prev.next = l1;
        }
        if (l2 != null) {
            prev.next = l2;
        }
        return result.next;
    }
    */
    /*
    //Solution 26%
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val < l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else{
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
    }
    */

    /*
    //Gene 1%
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // while(l1 != null){
        //     System.out.print(l1.val);
        //     l1 = l1.next;
        // }

        // System.out.println("");

        // while(l2 != null){
        //     System.out.print(l2.val);
        //     l2 = l2.next;
        // }


        // if (l1 == null && l2 == null){
        //     System.out.println("null1");
        //     return null;
        // }
        if (l1 == null){ // No Size or ...length
            // System.out.println("null2");

            return l2;
        }
        if (l2 == null){
            // System.out.println("null3");
            return l1;
        }//?

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy; //?

        while (l1 != null || l2 != null ){
            // System.out.println("l1: "+l1.val+" l2: "+l2.val);
            if (l1.val < l2.val){//?
                cur.next = l1;
                cur = cur.next;
                System.out.println("!"+cur.val);
                l1 = l1.next;

                if (l1 == null){
                    break;
                }
            }else{
                cur.next = l2;
                cur = cur.next;
                // System.out.println("!!"+cur.val);
                l2 = l2.next;
                if (l2 == null){
                    break;
                }
            }
        }

        // System.out.println("");
        if (l1 != null){
            cur.next = l1;
            // System.out.println("end1 "+l1.val);
        }else if ( l2 != null){
            cur.next = l2;
            // System.out.println("end2 "+l2.val);
        }

        return dummy.next;
    }
    */
}
