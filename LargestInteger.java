import java.util.HashMap;

class Solution {
    public int largestInteger(int[] nums, int k) {
        HashMap<Integer, Integer> subarrayCount = new HashMap<>();

        // Sliding window to check subarrays of size k
        for (int i = 0; i <= nums.length - k; i++) {
            HashMap<Integer, Integer> windowCount = new HashMap<>();

            // Count elements in the current window
            for (int j = i; j < i + k; j++) {
                windowCount.put(nums[j], windowCount.getOrDefault(nums[j], 0) + 1);
            }

            // Mark elements that appear in exactly one subarray
            for (int key : windowCount.keySet()) {
                subarrayCount.put(key, subarrayCount.getOrDefault(key, 0) + 1);
            }
        }

        int result = -1;

        // Find the largest number that appears in exactly one subarray
        for (int key : subarrayCount.keySet()) {
            if (subarrayCount.get(key) == 1) {
                result = Math.max(result, key);
            }
        }

        return result;
    }
}
