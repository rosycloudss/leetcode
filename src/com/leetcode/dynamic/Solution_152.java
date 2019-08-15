package com.leetcode.dynamic;

/**
 * 152. 乘积最大子序列
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * <p>
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class Solution_152 {
    //    /**
//     * 超时
//     * @param nums
//     * @return
//     */
//    public int maxProduct(int[] nums) {
//        int max = nums[0];
//        int length = nums.length;
//        int[][] temp = new int[length][length];
//        for (int i = 0; i < length; i++) {
//            temp[i][i] = nums[i];
//            if (temp[i][i] > max) {
//                max = temp[i][i];
//            }
//        }
//        for (int i = 0; i < length - 1; i++) {
//            for (int j = i+1; j < length; j++) {
//                temp[i][j] = temp[i][j - 1] * nums[j];
//                if (temp[i][j] > max) {
//                    max = temp[i][j];
//                }
//            }
//        }
//        return max;
//    }

    /**
     * 由于在数组中存在负数，会导致最大的变最小，最小的变最大，因此要维护一个最小值和一个最大值
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);
            max = Math.max(max,imax);
        }
        return max;

    }

}
