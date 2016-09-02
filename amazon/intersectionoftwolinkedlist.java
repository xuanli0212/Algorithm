/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode curA = headA;
        ListNode curB = headB;
        ListNode lastA = null;
        ListNode lastB = null;
        while (curA != curB) {
            if (curA.next == null){
                lastA = curA;
            }
            if (curB.next == null) {
                lastB = curB;
            }
            if (lastA != lastB && lastA != null && lastB != null) {
                return null;
            }
            curA = curA.next == null ? headB : curA.next;
            curB = curB.next == null ? headA : curB.next;
            
        }
        return curA;
        
    }
}
