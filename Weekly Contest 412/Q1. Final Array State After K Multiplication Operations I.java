problem link -> [ https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i/ ]
class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        for (int i = 0; i < k; i++) {
            // Find the minimum value and its index
            int minIndex = 0;
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            // Multiply the minimum value by the multiplier
            nums[minIndex] *= multiplier;
        }
        return nums;
    }
}
