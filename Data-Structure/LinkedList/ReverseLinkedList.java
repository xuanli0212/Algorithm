
/**
 * Algorithm Question: Reverse Linked List
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
 
 // Version 1 : Moving Head One by One using iterative method
public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    
    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        // 
        while (head != null ){
          ListNode tmp = head.next;
          head.next = pre;// change the direction here
          pre = head; // move forward, make head as previous one
          head = tmp;  // move forward, make next as head 
        }
        return pre; //Pay Attention here: You should return pre, not head, because in the last step, where pre point to tail, head actually point to null, so that they can stop the while condition
    }
}

//Version 2:  Moving pointer and finally set head
public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    
    public ListNode reverse(ListNode head) {
        //define two pointer current and previous. Move one by one
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        //in the final step, point head to pre
        head = pre;
        return pre;
    }
}

