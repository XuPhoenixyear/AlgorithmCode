package today.test01;

import java.util.HashSet;

public class Solution3153 {
    public static long sumDigitDifferences(int[] nums) {
        //对于每一位,求各种数字出现的次数
        long sum = 0;
        int n = nums.length;
        while(nums[0] > 0){
            int[] arr = new int[10];// 0 -9
            for(int i = 0 ; i < nums.length; i++){
                //当前位的值
                arr[nums[i]%10] ++;
                nums[i] =  nums[i] / 10;
            }
            for(int i = 0 ; i < arr.length; i++){
                sum +=  (long)(n - arr[i])*arr[i];
            }
        }

        return sum >> 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,2,2,2};

        System.out.println(sumDigitDifferences(arr));
    }
}
