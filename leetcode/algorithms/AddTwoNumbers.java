package leetcode.algorithms;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode lf = new ListNode(-1);
        getNext(l1, l2, lf, 0);
        return lf;
    }
    
    private void getNext(ListNode l1, ListNode l2, ListNode lf, int carry) {
        int sum = (getNode(l1).val + getNode(l2).val) + carry;
        carry = sum>9?1:0;
        lf.val = sum%10;

        if (l1.next == null && l2.next == null)
        {
            if(carry>0)
                lf.next = new ListNode(carry);
            return;
        }
        else{
            lf.next = new ListNode(-1);
            getNext(getNode(l1.next), getNode(l2.next), lf.next, carry);
        }
    }

    private ListNode getNode(ListNode ln)
    {
        return ln==null?new ListNode(0):ln;
    }
}
 class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	 }