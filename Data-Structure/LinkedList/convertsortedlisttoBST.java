/** Version 1: Time Complexity (NlogN)
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    private ListNode findMid(ListNode head) {

 
        ListNode fast = head.next;
        ListNode slow = head;
        ListNode preSlow = slow;
        
        while (fast != null && fast.next != null) {
            preSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return preSlow;
    }
    public TreeNode sortedListToBST(ListNode head) {  
        // write your code here
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode preMid = findMid(head);
        ListNode mid = preMid.next;
        TreeNode root = new TreeNode(mid.val);
        preMid.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }
   
}

/* Version 2: O(N) time complexity 
*
*/
