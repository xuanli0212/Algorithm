/**
 * Definition for ListNode
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
     * @param ListNode head is the head of the linked list 
     * @param m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
        ListNode pre = new ListNode(0);
        pre.next = head;
        head = pre;
        
        for (int i = 1; i < m; i++) {
            if ( head != null) {
                head = head.next;
            }else return null;
        }
        
        ListNode preM = head;
        ListNode Mnode = head.next;
        ListNode Nnode = Mnode;
        ListNode postN = Mnode.next;

        for (int i = m; i < n; i++) {
            if( postN != null) {
                ListNode temp = postN.next;
                postN.next = Nnode;
                Nnode = postN;
                postN = temp;
            }else return null;
        }
        Mnode.next=postN;
        preM.next = Nnode;
        
        return pre.next;
        
    }
}
