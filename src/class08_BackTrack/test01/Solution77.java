package class08_BackTrack.test01;

import java.util.ArrayList;
import java.util.List;

public class Solution77 {
    // 1..n 的k数 组合
    static List<List<Integer>> list = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();
    public static List<List<Integer>> combine(int n, int k) {
        process(1,n,k);
        return list;
    }

    //从index ... n中取k个数
    public static void process(int index,int n,int k){
        if(k <= 0){
            list.add(new ArrayList<>(path)); //记录当前path内容
            //记录一种结果
            return;
        }
        if( n - index + 1 < k)
            //剩下的数不足k个数时,返回上一层
            return;

        //每次取一个数
        for(int i = index; i <= n + 1 - k; i++){ //保证 n - i + 1 >= k
            path.add(i);//取值
            process(i+1,n,k-1); //递归
            path.remove(path.size() - 1); //回溯
        }

    }
    public static void main(String[] args) {
        System.out.println(combine(4,2));
    }
}
