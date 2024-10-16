package class01_Array.test03;

import java.util.Arrays;
/**
 *
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。元素的顺序可能发生改变。
 * 然后返回 nums 中与 val 不同的元素的数量。
 *
 * 假设 nums 中不等于 val 的元素数量为 k，要通过此题，您需要执行以下操作：
 * 更改 nums 数组，使 nums 的前 k 个元素包含不等于 val 的元素。nums 的其余元素和 nums 的大小并不重要。
 * 返回 k。
 *
 * */

public class Solution27 {

    public static int removeElement(int[] nums, int val) {
        int slow = 0;
        for(int fast = 0; fast< nums.length; fast++){
            if(nums[fast] != val){
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,2,3};
        int k = removeElement(arr,3);
        System.out.println(Arrays.toString(arr)+":"+ k);
    }
}
