problem link -> [ https://leetcode.com/problems/find-the-power-of-k-size-subarrays-i ]
class Solution {
    public int[] resultsArray(int[] nums, int k) {
      int n = nums.length;
        int[] results = new int[n - k + 1];
        
        for (int i = 0; i <= n - k; i++) {
            int max = nums[i];
            boolean isSorted = true;
            boolean areConsecutive = true;
            
            for (int j = i; j < i + k; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                }
                if (j > i) {
                    if (nums[j] < nums[j - 1]) {
                        isSorted = false;
                    }
                    if (nums[j] != nums[j - 1] + 1) {
                        areConsecutive = false;
                    }
                }
            }
            
            if (isSorted && areConsecutive) {
                results[i] = max;
            } else {
                results[i] = -1;
            }
        }
        
        return results;

    }
}
