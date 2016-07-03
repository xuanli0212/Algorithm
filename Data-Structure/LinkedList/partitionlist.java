/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode 
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        if (head == null) {
            return head;
        }
        ListNode leftdummy = new ListNode(0);
        ListNode rightdummy = new ListNode(0);
        ListNode left = leftdummy;
        ListNode right = rightdummy;
        while (head!=null) {
            if (head.val >= x) {
                right.next = head;
                right = right.next;
            }else {
                left.next = head;
                left = left.next;
            }
            head = head.next;
        }
        right.next = head;
        left.next = rightdummy.next;
        
        return leftdummy.next;
    }
}
