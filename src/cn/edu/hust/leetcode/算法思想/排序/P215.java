package cn.edu.hust.leetcode.算法思想.排序;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author kaisheng
 * @create 2020-11-08 21:21
 */
public class P215 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    public int findKthLargest3(int[] nums, int k) {
        return  0;
    }

    private int partition(int[] a, int l,int h){
        int i = l, j = h + 1;
        while (true){
            while (a[++i] < a[l] && i < h);
            while (a[--j] > a[l] && j > l);
            if (i >= j){
                break;
            }
            swap(a,i,j);
        }
        swap(a,l,j);
        return j;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


}
