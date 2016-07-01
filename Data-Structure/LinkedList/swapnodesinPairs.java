/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @return a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        // Write your code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
       
        while (head.next != null && head.next.next != null) {
            ListNode cur = head.next;
            ListNode post = head.next.next;
            head.next = post;
            cur.next = post.next;
            post.next = cur;

            head = cur;
           
        }
        return dummy.next;
    }
}
