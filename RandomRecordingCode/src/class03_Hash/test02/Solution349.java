package class03_Hash.test02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution349 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        int[] arr = new int[1001];
        int count = 0;
        for(int num1: nums1){
            arr[num1] = 1;
        }
        for(int num2: nums2){
            if(arr[num2] == 1){
                arr[num2] = 2;
                count++;
            }
        }

        int[] res = new int[count];

        for(int i = 0,j = 0; i < arr.length; i++){
            if(arr[i] == 2)
                res[j++] = i;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr1 = new int[]{4,9,5};
        int[] arr2 = new int[]{9,4,9,8,4,5};
        System.out.println(Arrays.toString(intersection(arr1,arr2)));
    }
}
