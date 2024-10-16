package class01_Array.test05;

/**
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其总和大于等于 target 的长度最小的子数组
 * [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * */
public class Solution209 {
    //滑动窗口
    public static int minSubArrayLen(int target, int[] nums) {
        int min = nums.length + 1;
        int sum = 0;
        int left = 0;
        for(int i = 0 ; i < nums.length; i++){
            sum += nums[i];
            while(sum >= target){
                min = Math.min(min,i - left + 1);
                sum -= nums[left++];
            }

        }

        return min == nums.length + 1 ? 0 : min;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,2,4,3};
        int t = 7;
        System.out.println(minSubArrayLen(t,arr));
    }
}
