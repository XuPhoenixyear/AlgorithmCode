package class03_Hash.test03;

import java.util.HashSet;

public class Solution202 {
    public static boolean isHappy(int n) {
        //哈希表记录每次出现的值
        HashSet<Integer> set = new HashSet<>();
        while(n != 1 && !set.contains(n)){
            System.out.println(n);
            set.add(n);

        }

        return n == 1;
    }
    public static void main(String[] args) {
        System.out.println(isHappy(15));
    }
}
