/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        if(head == null || head.next  == null) return false;
        ListNode slow = head;
        ListNode fast = head.next.next;
        // else return false;
        
        while( fast != null && fast.next!= null)
        {
            if(slow == fast) break;
            slow = slow.next;
            fast = fast.next.next;

        }
        // System.out.println(fast.val +" "+slow.val);
        if( fast!= null && slow == fast) return true;
        return false;
        
    }
}