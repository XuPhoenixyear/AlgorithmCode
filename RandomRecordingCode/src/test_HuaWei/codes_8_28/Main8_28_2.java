package test_HuaWei.codes_8_28;

import java.util.*;

/* 元素消除
*
*  6 4 5 7 1 1 2 3
*  1
*
*  返回消除数最多的元素时的起点
* */
public class Main8_28_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int interval = sc.nextInt();

        int[] arr = new int[n];
        int[] rest = new int[n];
        //统计余数最多的路径，并数组中位于此路径的最小值
        //HashMap<Integer,Integer> map = new HashMap<>();
        //interval的最大值是10 ^ 5
        int[] map = new int[interval];// 0 - interval-1是余数
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
            rest[i] = arr[i] % interval; //同一路径上的余数相同
            map[rest[i]]++; //记录余数个数
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(rest));
        System.out.println(Arrays.toString(map));
        //取出余数最多的key
        int max = -1;
        HashSet<Integer> keys = new HashSet<>(); //注意可能一样多
        //先找最多的余数的个数,然后找出最多的keys
        for(int i = 0 ; i < interval; i++){
            max = Math.max(max,map[i]);
        }
        for(int i = 0 ; i < interval; i++){
            if(max == map[i])
                keys.add(i);
        }
        System.out.println(Arrays.toString(keys.toArray()));
        int min = Integer.MAX_VALUE;
        for(int val : arr){
            if(keys.contains(val % interval))
                min = Math.min(val,min);
        }
        System.out.println( min );

    }
}
