/* Version 1: HashMap Version
*
*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if (head == null) {
            return head;
        }
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode cur = head;
        RandomListNode newList = dummy;
        
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode    , RandomListNode>();
        while (cur != null) {
            RandomListNode tmp = new RandomListNode(cur.label);
            newList.next = tmp;
            map.put(cur, tmp);
            cur = cur.next;
            newList = newList.next;
        }
        cur = head;
        newList = dummy.next;
        
        while (cur != null) {
            if (cur.random != null) {
                newList.random = map.get(cur.random);
            }
            cur = cur.next;
            newList = newList.next;
        }
        return dummy.next;
    }
}
/* Version 2 
*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if (head == null) {
            return head;
        }
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode cur = head;
        //copy next
        while (cur != null) {
            RandomListNode temp = new RandomListNode(cur.label);
            temp.next = cur.next;
            cur.next = temp;
            cur = cur.next.next;
        }
        //copy random
        cur = head;
        while (cur != null) {
            RandomListNode newTemp  = cur.next;
            if (cur.random != null) {
                RandomListNode point = cur.random;
                newTemp.random = point.next;
            }
            cur = cur.next.next;
            
        }
        //split the two list
        cur = head;
        RandomListNode newList = dummy;
        while (cur != null) {
            RandomListNode newTemp  = cur.next;
            newList.next = newTemp;
            cur.next = newTemp.next;
            cur = cur.next;
            newList = newList.next;
            
        } 
        return dummy.next;
        
        
    }
    
}
