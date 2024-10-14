package class01_Array.test04;

import java.util.Arrays;

/**
 *
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 * */

public class Solution977 {
    public static int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] arr = new int[nums.length];
        int i = nums.length - 1;
        while(left < right){
            int l = Math.abs(nums[left]);
            int r = Math.abs(nums[right]);
            arr[i--] = l < r ? r * r : l * l;
            if(l < r) right--;
            else left++;
        }
        arr[i] = nums[left] * nums[left];
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{-4,-2,1,3,10};
        System.out.println(Arrays.toString(sortedSquares(arr)));
    }
}
