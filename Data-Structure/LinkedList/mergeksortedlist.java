/* Version 1: Divide & conquer. 类似于Merge sort,自底向下， 从底端逐渐分割，在左右merge。类似于merge two sorted list。
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
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        if (lists == null || lists.size() == 0) {
            return null;
        }
        int size = lists.size();
        return helper(lists, 0, size - 1);
    }
    private ListNode helper(List<ListNode> lists, int start, int end) {
        if (start == end) {
            return lists.get(start);
        }
        int mid = start + (end - start) / 2;
        
        ListNode left = helper(lists, start, mid);
        ListNode right = helper (lists, mid + 1, end);
        ListNode root = merge(left, right);
        return root;
    }
    private ListNode merge(ListNode lis1, ListNode lis2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        
        while (lis1 != null && lis2!= null) {
            if (lis1.val > lis2.val) {
                cur.next = lis2;
                lis2 = lis2.next;
            } else {
                cur.next = lis1;
                lis1 = lis1.next;
            }   
            cur = cur.next;
        }
        if (lis1 != null) {
            cur.next = lis1;
        }
        if (lis2 != null) {
            cur.next = lis2;
        }
        return dummy.next;
    }
}
/*
*Version2 : Using Priorty Queue
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
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
    */
     // New Comparator to deal with null issues and set customerized compare    method
    private Comparator<ListNode> listComparator = new Comparator<ListNode>(){
        public int compare(ListNode list1, ListNode list2) {
            return list1.val - list2.val;
        }
    };
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        if (lists == null || lists.size() == 0) {
            return null;
        }
        Queue<ListNode> heaplist = new PriorityQueue<ListNode>(lists.size(), listComparator);
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                heaplist.offer(lists.get(i));
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (heaplist.size() > 0) {
            ListNode cur = heaplist.poll();
            head.next = cur;
            head = head.next;
            if (cur.next != null) {
                heaplist.add(cur.next);
            }
        }
        return dummy.next;
    }
}
