package cn.edu.hust.leetcode.算法思想.双指针;

/**
 * @author kaisheng
 * @create 2020-11-07 20:09
 *
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 *  
 *
 * 说明：
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 *
 * 示例：
 *
 * 输入：
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出：[1,2,2,3,5,6]
 *
 */
public class P88 {

    //m 和 n 为num1和num2中实际元素个数
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int mergeIndex = m + n - 1;

        while (mergeIndex >= 0){
            if (index1 < 0){
                nums1[mergeIndex--] = nums2[index2--];
            }else if (index2 < 0){
                nums1[mergeIndex--] = nums1[index1--];
            }else if (nums1[index1] > nums2[index2]){
                nums1[mergeIndex--] = nums1[index1--];
            }else{
                nums1[mergeIndex--] = nums2[index2--];
            }
        }

    }
}
