/* Version1: HashSet 
*
*/
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
     * @return: The node where the cycle begins. 
     *           if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {  
        // write your code here
        if (head == null || head.next ==  null) {
            return null;
        }
        Set<ListNode> list = new HashSet<ListNode>();
        ListNode cur = head;
        while (cur != null) {
            if (list.contains(cur)){
                return cur;
            }
            list.add(cur);
            cur = cur.next;
        }
        return null;
    }
}
/* Version2: No extra Space
*
*/
