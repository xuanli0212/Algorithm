//Solution1: Use fast pointer

public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) return;
	    int fast = 0;
	    int slow = 0;
	    while(fast < nums.length) {
	        if (nums[fast] != 0) {
	            nums[slow++] = nums[fast];
	        }
	        fast++;
	    }
	    while(slow < nums.length) {
	        nums[slow++] = 0;
	    }
        
    }
}

//Solution2: Use slow pointer

public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int fast = 0;
        int slow = 0;
        while (slow < nums.length) {
            if (fast < nums.length) {
                if (nums[fast] != 0) {
                    nums[slow++] = nums[fast];
                }
                fast++;
            } else {
                nums[slow++] = 0;
            }
        }
    }
}
