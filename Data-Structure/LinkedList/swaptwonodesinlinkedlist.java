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
     * @oaram v1 an integer
     * @param v2 an integer
     * @return a new head of singly-linked list
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        // Write your code here
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        ListNode cur = head.next;
        ListNode pre = head;
        ListNode preM = null; 
        ListNode preN = null;
        ListNode M = null;
        ListNode N = null;
        while (cur != null) {
            if (M != null && N != null) {
                break;
            }
            if (cur.val == v1) {
                M = cur;
                preM = pre;
            } else if (cur.val == v2) {
                N = cur;
                preN = pre;
            } 
            pre = pre.next;
            cur = cur.next;
        }
        //out of index
        if (M == null || N == null) {
            return dummy.next;
        }
        ListNode postN = N.next;
        ListNode postM = M.next;
        //Avoid Loops
        if (preN == M) {
            preM.next = N;
            N.next = M;
            M.next = postN;
        } else if (preM == N) {
            preN.next = M;
            M.next = N;
            N.next = postM;
        } else {
            preM.next = N;
            N.next = postM;
            preN.next = M;
            M.next = postN;
        }
        return dummy.next;
    }
}
