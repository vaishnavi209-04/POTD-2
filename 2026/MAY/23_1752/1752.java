class Solution {
    public boolean check(int[] nums) {
         int count = 0; // To count the number of "drops"
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // Compare current element with the next element (considering circular array)
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }

            // If there is more than one drop, return false
            if (count > 1) {
                return false;
            }
        }

        return true;
    }
}