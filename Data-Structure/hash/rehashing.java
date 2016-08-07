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
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        // get size and count if it is size >=capacity/10
        if (hashTable == null || hashTable.length == 0) {
            return hashTable;
        }
        int size = 0;
        int length = hashTable.length;
        for (int i = 0; i < length; i++) {
            if (hashTable[i] != null) {
                ListNode cur = hashTable[i];
                while (cur!= null) {
                    cur = cur.next;
                    size ++;
                }
            } 
        }
        if (size >= length / 10) {
            int newCapacity = 2 * length;
            ListNode[] newTable = new ListNode[newCapacity];
            for (int i = 0; i < length; i++) {
                
                if (hashTable[i] != null) {
                    ListNode cur = hashTable[i];
                    while (cur != null) {
                        int newIndex = (cur.val % newCapacity + newCapacity) % newCapacity;
                        if (newTable[newIndex] == null) {
                            newTable[newIndex] = new ListNode(cur.val);
                        } else {
                            ListNode head = newTable[newIndex];
                            while (head.next != null) {
                                head = head.next;
                            }
                            head.next = new ListNode(cur.val);
                        }
                        cur = cur.next;
                    }
                }  
            }
            return newTable;
        } else {
            return hashTable;
        }
    }
};
