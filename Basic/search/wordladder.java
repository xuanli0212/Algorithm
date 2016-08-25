public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        //BFS
        if (start.equals(end)) {
            return 1;
        }
        if (dict == null || dict.size() == 0) {
            return 0;
        }
        int distance = 1;
        dict.add(start);
        dict.add(end);
        Queue<String> queue = new LinkedList<String>();
        HashSet<String> set = new HashSet<String>();
        queue.offer(start);
        set.add(start);
        while (!queue.isEmpty()) {
            distance++;
            //注意这里要提前得到queue的size
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                ArrayList<String> nextLevel = getNextWord(cur, dict);
                for (String str : nextLevel) {
                    if (set.contains(str)) {
                        continue;
                    }
                    //注意这里要用equals
                    if (str.equals(end)) {
                        return distance;
                    } 
                    queue.offer(str);
                    set.add(str);
                }
            }
        }
        return 0;
    }
    //get next level words
    private ArrayList<String> getNextWord(String str, Set<String> dict) {
        ArrayList<String> result = new ArrayList<String>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < str.length(); i++) {
                if (c == str.charAt(i)) {
                    continue;
                }
                char[] charArray = str.toCharArray();
                charArray[i] = c;
                String newWord = new String(charArray);
                if (dict.contains(newWord)) {
                    result.add(newWord);
                }
            }
        } 
        return result;
    }
}
