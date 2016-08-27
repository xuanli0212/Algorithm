public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return a list of lists of string
      */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here 
        List<List<String>> result = new ArrayList<List<String>>();
        if (dict == null) {
            return result;
        }
        dict.add(start);
        dict.add(end);
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        Map<String, Integer> distance = new HashMap<String, Integer>();
       
        bfs(map, start, end, dict, distance);
        List<String> path = new ArrayList<String>();
        //path.add(end);
        dfs(result, map, end, start, distance, path);
        return result;
        
    }
    //BFS, get the distance of the map by level order. and also remember the previous node before.
    private void bfs(Map<String, List<String>> map, String start, String end, Set<String> dict, Map<String,Integer> distance) {
       Queue<String> queue = new LinkedList<String>();
       queue.add(start);
       distance.put(start, 0);
       for (String index: dict) {
           map.put(index, new ArrayList<String>());
       }
       while (!queue.isEmpty()) {
            String cur = queue.poll();
            ArrayList<String> list = getNextWord(cur, dict);
            for (String nextWord : list) {
                //注意这一步：如果下面这一行出现在continue之后，会导致另一个list应该有的最后一个数没有加进去而导致list。比如1hit hot lot 2hit lit lot（这个lot会无法进入list中）
                map.get(nextWord).add(cur);
                if (distance.containsKey(nextWord)) {
                    continue;
                }
                queue.offer(nextWord);
                distance.put(nextWord, distance.get(cur) + 1);
            }
       }
    }
    // DFS to get all the solutions with shortest path.
    private void dfs(List<List<String>> result, Map<String, List<String>> map, String curt, String start, Map<String,Integer> distance, List<String> path) {
        if (curt.equals(start)) {
            //注意这一步，因为是从下到上，所以list需要翻转
            path.add(curt);
            Collections.reverse(path);
            result.add(new ArrayList<String>(path));
            //注意这一步里，每次加，翻转，加入result之后都要再转回来和减掉
            Collections.reverse(path);
            path.remove(path.size() - 1);
        } else {
            for (String preWord : map.get(curt)) {
                //注意这一步的判断条件，必须是在distance于当前差1的
                if (distance.containsKey(preWord) && (distance.get(preWord) + 1 == distance.get(curt))) {
                    path.add(curt);
                    dfs(result, map, preWord, start, distance, path);
                    path.remove(path.size() - 1);
                } 
            }
        }
        //注意这一步
        //path.remove(path.size() - 1);
    }
    private ArrayList<String> getNextWord(String str, Set<String> dict) {
        ArrayList<String> result = new ArrayList<String>();
        
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < str.length(); i++) {
                if (c == str.charAt(i)) {
                    continue;
                }
                char[] charArray = str.toCharArray();
                charArray[i] = c;
                String newString = String.copyValueOf(charArray);
                if (dict.contains(newString)) {
                    result.add(newString);
                }
            }
        }
        return result;
    }
}
