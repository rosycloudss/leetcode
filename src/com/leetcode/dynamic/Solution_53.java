package com.leetcode.dynamic;

/**
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class Solution_53 {
    /**
     * 声明 sum 记录 0~i 连续子数组的最大和
     * 声明 max 记录 连续子数组的最大和
     * sum 和max 初始化为 nums[0]
     * 每次比较 0~i-1 的连续子数组最大和 和 nums[i] 的和 与nums[i] 的大小，并把最大的赋值个 sum
     * 取 sum 和 max中的最大值给max
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            if (max < sum) {
                max = sum;
            }
        }
        return max;
    }
}
