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
     * @param head: The head of linked list.
     * @return: void
     */
    public void reorderList(ListNode head) {  
        // write your code here
        if (head == null || head.next == null) {
            return;
        }
        ListNode mid = findMiddle(head);
        ListNode newList = reverse (mid.next);
         mid.next = null;
        merge(head, newList);
    }
    private ListNode findMiddle(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
    private ListNode merge(ListNode oldList, ListNode newList) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (oldList != null && newList != null) {
            cur.next = oldList;
            oldList = oldList.next;
            cur = cur.next;
            
            cur.next = newList;
            newList = newList.next;
            cur = cur.next;
        }
        if (newList != null) {
            cur.next = newList;
        } else {
            cur.next = oldList;
        }
        return dummy.next;
    }
}
