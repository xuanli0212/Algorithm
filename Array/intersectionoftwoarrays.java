/* Method 1: Use Hash Set
*  Time complexity: O(N) (for each for loop), Space Complexity is O(2M), two extra hash set
*/
public class Solution {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // Write your code here
        if (nums1.length == 0 || nums2.length == 0 || nums1 == null || nums2 == null) {
            return new int[0];
        }
        HashSet<Integer> list1 = new HashSet<Integer>();
        HashSet<Integer> result = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            list1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (list1.contains(nums2[i]) && !result.contains(nums2[i])) {
                result.add(nums2[i]);
            }
        }
        int size = result.size();
        int[] res = new int[size];
        int index = 0;
        for (Integer nums : result) {
            res[index] = nums;
            index++;
        }
        return res;
    }
}
/* Method 2: Use Sort and Merge
*
*/

public class Solution {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // Write your code here
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0,j = 0;
        int size1 = nums1.length;
        int size2 = nums2.length;
        int[] temp = size1 > size2 ? new int[size2] : new int[size1];
        int index = 0;
        
        while (i < size1 && j < size2) {
            if (nums1[i] == nums2[j]) {
                if (index == 0 || temp[index - 1] != nums1[i]) {
                    temp[index] = nums1[i];
                    index++;
                }
                i++;
                j++;
            }else if (nums1[i] > nums2[j]) {
                j++;
            }else {
                i++;
            }
        }
        int[] result = new int[index];
        for (int k = 0;k < index; k++) {
            result[k] = temp[k];
        }
        return result;
    }
}
