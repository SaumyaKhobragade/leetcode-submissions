class Solution {
    public static int countInRange(int[] nums, int num, int si, int ei) {
        int count = 0;
        for (int i = si; i <= ei; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    public static int majorityElement(int[] nums, int si, int ei) {
        if (si == ei) {
            return nums[si];
        }

        int mid = si + (ei - si) / 2;
        int left = majorityElement(nums, si, mid);
        int right = majorityElement(nums, mid + 1, ei);

        if (left == right) {
            return left;
        }

        int leftCount = countInRange(nums, left, si, ei);
        int rightCount = countInRange(nums, right, si, ei);

        return leftCount > rightCount ? left : right;
    }

    public int majorityElement(int[] nums) {
        return majorityElement(nums, 0, nums.length-1);
    }
}