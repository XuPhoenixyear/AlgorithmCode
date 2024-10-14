package class04_String.test01;

import java.util.Arrays;

public class Solution344 {
    public static void reverseString(char[] s) {
        for(int left = 0,right = s.length - 1; left <= right; left++,right--){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
        System.out.println(Arrays.toString(s));
    }

    public static void main(String[] args) {
        String s = "hello";
        reverseString(s.toCharArray());
    }
}
