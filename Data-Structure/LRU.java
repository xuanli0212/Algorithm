public class Solution {
    Map<Integer, Node> map = new HashMap<Integer, Node>();
    int listCapacity;
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
     
    // @param capacity, an integer
    public Solution(int capacity) {
        // write your code here
        listCapacity = capacity;
        head.next = tail;
        head.pre = null;
        tail.pre = head;
        tail.next = null;
    }

    // @return an integer
    public int get(int key) {
        // write your code here
        if(!map.containsKey(key)) {
            return -1;
        }
        // check hashmap to find current
        Node cur = map.get(key);
        //remove current node 
        cur.pre.next = cur.next;
        cur.next.pre = cur.pre;
        
        // move the current node to tail
        addToTail(cur);
        return cur.val;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // write your code here
        // if the key is already present, update value
        if (get(key) != -1) {
            map.get(key).val = value;
            return;
        }
        // if reach the limit of capacity, remove head
        Node cur = new Node(key, value);
        if (map.size() == listCapacity) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.pre = head;
        }
        // add cur to tail
        map.put(cur.key, cur);
        addToTail(cur);
        
    }
    private void addToTail(Node cur) {
        cur.pre = tail.pre;
        tail.pre.next = cur;
        cur.next = tail;
        tail.pre = cur;
    }
}
class Node {
    public int key;
    public int val;
    public Node next;
    public Node pre;
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
 
}
