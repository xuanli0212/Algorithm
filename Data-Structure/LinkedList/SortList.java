/*  Merge Sort Version.
*  Using Recursion to split and merge
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
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
    private ListNode middle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode merge(ListNode left, ListNode right) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (left != null && right != null) {
            if (left.val > right.val) {
                head.next = right;
                right = right.next;
            } else {
                head.next = left;
                left = left.next;
            }
            head = head.next;
        }
        if (left != null) {
            head.next = left;
        }
        if (right != null) {
            head.next = right;
        }
        return cur.next;
    }
    public ListNode sortList(ListNode head) {  
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = middle(head);
        ListNode rightList = sortList(mid.next);
        mid.next = null; 
        ListNode leftList = sortList(head);
        ListNode sorted = merge(leftList, rightList);
        return sorted;
    }
}

/* QuickSort version
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
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
    public ListNode sortList(ListNode head) {  
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        //partiton
        ListNode mid = mid(head);
        ListNode midHead = new ListNode(0);
        ListNode midTail = midHead;
        ListNode leftHead = new ListNode(0);
        ListNode leftTail = leftHead;
        ListNode rightHead = new ListNode(0);
        ListNode rightTail = rightHead;

        while (head != null) {
            if (head.val < mid.val) {
                leftTail.next = head;
                leftTail = leftTail.next;
            } else if (head.val > mid.val){
                rightTail.next = head;
                rightTail = rightTail.next;
            } else {
                midTail.next = head;
                midTail = midTail.next;
            }
            head = head.next;
        }
        
        // sort
        leftTail.next = null;
        rightTail.next = null;
        midTail.next = null;
        ListNode left = sortList(leftHead.next);
        ListNode right = sortList(rightHead.next);
        // merge
       
        ListNode newHead = new ListNode(0);
        ListNode point = newHead;
        newHead.next = left;
        newHead = tail(newHead);
        newHead.next = midHead.next;
        newHead = tail(newHead);
        newHead.next = right;
        return point.next;
        
    }
    private ListNode mid(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode tail(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        return tail;
    }
}

