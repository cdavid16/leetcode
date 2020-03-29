package leetcode.algorithms;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        int current_value = -1;
        ListNode merged=null;
        while(l1 != null || l2 != null){
            int l1val = l1!=null?l1.val:Integer.MAX_VALUE;
            int l2val = l2!=null?l2.val:Integer.MAX_VALUE;
            if(l1val<=l2val){
                current_value = l1val;
                l1 = l1.next;
            }
            else{
                current_value = l2val;
                l2 = l2.next;
            }

            if(merged==null){
                merged = new ListNode(current_value);
            }
            else{
                setNext(merged, current_value);
            }
        }
        return merged;
    }

    public void setNext(ListNode n1, int added){
        if(n1.next == null){
            n1.next = new ListNode(added);
            return;
        }


        setNext(n1.next, added);
    }

}
