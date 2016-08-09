public class Solution {
    private Queue<Integer> minHeap;
    private int maxSize;
    
    public Solution(int k) {
        // initialize your data structure here.
        minHeap = new PriorityQueue<Integer>();
        maxSize = k;
    }
    public void add(int num) {
        // Write your code here
        if (minHeap.size() < maxSize) {
            minHeap.offer(num);
        } else if (minHeap.peek() < num) {
            minHeap.poll();
            minHeap.offer(num);
        }
    }

    public List<Integer> topk() {
        // Write your code here
        Iterator it = minHeap.iterator();
        List<Integer> result = new ArrayList<Integer>();
        
        while (it.hasNext()) {
            result.add((Integer)it.next());
        }
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }
};
