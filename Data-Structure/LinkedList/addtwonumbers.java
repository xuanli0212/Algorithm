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
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode head = new ListNode(0);
        ListNode curt = head;
        int next = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                int sum = next + l1.val + l2.val;
                curt.next = new ListNode(sum % 10);
                next = sum / 10;
                l1 = l1.next;
                l2 = l2.next;
            }
             else if (l1 != null && l2 == null) {
                int sum = next + l1.val;
                curt.next = new ListNode(sum % 10);
                next = sum / 10;
                l1 = l1.next;
            }
            else if (l2 != null && l1 == null) {
                int sum = next + l2.val;
                curt.next = new ListNode(sum % 10);
                next = sum / 10;
                l2 = l2.next;
            }
            curt = curt.next;
        }
        if (next != 0) {
            curt.next = new ListNode(next);        
        }
        return head.next;
    }
}
