public class Solution {
    /**
     * @param words an array of string
     * @param k an integer
     * @return an array of string
     */
    public String[] topKFrequentWords(String[] words, int k) {
        // Write your code here
        if (words == null || words.length == 0 || k == 0) {
            return new String[0];
        }
        //generate word counts list
        Map<String, Integer> map = new HashMap<String,Integer>();
        for (String word: words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        Comparator<Pair> pairComparator = new Comparator<Pair>(){
            public int compare (Pair a, Pair b) {
                if (a.count != b.count) {
                    return a.count - b.count;
                } else {
                    return b.word.compareTo(a.word);
                }
            }
        };
        // put word counts into heap of size K. Maintain the heap. 
        PriorityQueue<Pair> heap = new PriorityQueue<Pair>(k, pairComparator);
        for (String word : map.keySet()) {
            Pair minQ = heap.peek();
            Pair cur = new Pair(word, map.get(word));
            if (heap.size() < k) {
                heap.offer(cur);
            } else if (pairComparator.compare(cur, minQ) > 0) {
                    heap.poll();
                    heap.offer(cur);
            }
        }
        String[] result = new String[k];
        for (int i = 0; i < k; i++) {
            result[k - 1 - i] = heap.poll().word;
        }
        return result;
    }
    class Pair {
        public String word;
        public int count;
        public Pair(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}
