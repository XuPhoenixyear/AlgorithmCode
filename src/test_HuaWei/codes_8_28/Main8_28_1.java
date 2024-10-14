package test_HuaWei.codes_8_28;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class Main8_28_1 {
    /*  老鼠串门
    *
    *   1 2 3 2 3 4 5
    *   3 2 5 4 3 2 1
    *
    * */


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ins = sc.nextLine(); //输入一组序列
        String[] in = ins.split(" ");
        //System.out.println(Arrays.toString(in));
        int n = in.length;
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(in[i]);
        }
        Stack<Integer> hole = new Stack<>(); //老鼠洞
        HashSet<Integer> set = new HashSet<>(); //记录老鼠是否入洞

        for(int i = 0 ; i < n; i++){
            //如果老鼠还没入洞,直接入栈
            if(!set.contains(arr[i])){
                hole.push(arr[i]);
                set.add(arr[i]);
            }else{
                //如果老鼠入过洞,证明出现了重复,老鼠需要出来又进去,但是前面的都要出洞才行
                while(hole.peek() != arr[i]){
                    int temp = hole.pop();
                    System.out.print( temp + " "); //前面的出洞
                    set.remove(temp);
                }
                //栈顶已经是该老鼠,这只老鼠也是出洞后入洞,栈不变,打印即可
                System.out.print(hole.peek() + " ");
            }
        }
        //后面没有老鼠了,洞里的老鼠挨个出来
        while(!hole.isEmpty()){
            System.out.print(hole.pop() + " ");
        }

    }
}
