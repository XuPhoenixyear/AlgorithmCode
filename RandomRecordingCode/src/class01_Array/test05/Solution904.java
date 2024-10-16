package class01_Array.test05;

import java.util.HashSet;

public class Solution904 {
    public static int totalFruit(int[] fruits) {
        int max = 0;
        int type1 = fruits[0];
        int type2 = -1;
        int idx1 = 0;
        int left = 0;
        for(int i = 0; i < fruits.length; i++){
            int cur = fruits[i];
            if(cur != type1){
                if(cur != type2 && type2 != -1){
                    max = Math.max(max,i - left);
                    left = idx1;
                }
                //cur = type2 | type2 = -1
                type2 =  type1;
                type1 = cur;
                idx1 = i;
            }
        }
        return Math.max(max,fruits.length  - left);
    }



    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,2,2,2,3,5,5,5,5,5,5,5,5,5};
        System.out.println(totalFruit(arr));
    }
}
