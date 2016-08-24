public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> result = new ArrayList<List<String>>();
        if (s == null || s.isEmpty()) {
            return result;
        }
        List<String> list = new ArrayList<String>();
        helper (result, list, 0, s);
        return result;
    }
    //DFS
    private void helper(List<List<String>> result,  List<String> list, int position, String str) {
        //end
        if (position == str.length()) {
            result.add(new ArrayList<String>(list));
        }
        //注意此处是从position+1开始，因为我们需要fix position，不断增加后面的i
        for (int i = position + 1; i <= str.length(); i++) {
            if(!isPalindorme(str.substring(position, i))) {
                continue;
            }
            list.add(str.substring(position, i));
            //此处helper是从i开始,而不是position + 1，这是因为要从前一个string的下一个开始。substring的最后一个i就是下一个的开始。
            helper(result, list, i, str);
            list.remove(list.size()- 1);
        }
    }
    //check palindorme
    private boolean isPalindorme(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) !=  str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
