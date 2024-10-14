package class01_Array.test03;

import java.util.Arrays;

/**
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * */
public class Solution283 {
    public static void moveZeroes(int[] nums) {
        int slow = 0;
        for(int fast = 0; fast < nums.length; fast++){
            if(nums[fast] != 0){
                nums[slow++] = nums[fast];
            }
        }
        while(slow < nums.length){
            nums[slow++] = 0;
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,3,12};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}
