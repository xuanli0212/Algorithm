public class Solution {
    /**
     * @param str a string
     * @return all permutations
     */
    public List<String> stringPermutation2(String str) {
        // Write your code here
        List<String> result = new ArrayList<String>();
        if (str == null) {
            return result;
        }
        char[] source = str.toCharArray();
        Arrays.sort(source);
        StringBuilder list = new StringBuilder(str.length());
        int[] visited = new int[str.length()];
        helper(result, source, list, visited);
        return result;
    }
    private void helper(List<String>result, char[] source, StringBuilder list, int[] visited) {
        if (source.length == list.length()) {
            result.add(list.toString());
        }
        for (int i = 0; i < source.length; i++) {
            if (visited[i] == 1 || (i > 0 && visited[i - 1] == 1 && source[i - 1] == source[i])) {
                continue;
            }
            list.append(source[i]);
            visited[i] = 1;
            helper(result, source, list, visited);
            list.deleteCharAt(list.length() - 1);
            visited[i] = 0;
        }
    }
   
}
