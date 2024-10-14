package class01_Array.test07;

import java.util.Scanner;

public class KamaCoder58 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        long[] sum = new long[n];
        for(int i = 0 ; i < n; i ++){
            arr[i] = sc.nextInt();
            sum[i] = i == 0 ? arr[i] : sum[i-1] + arr[i];
        }
        while(sc.hasNext()){
            int left = sc.nextInt();
            int right = sc.nextInt();
            System.out.println( (left == 0 ? sum[right] : sum[right] - sum[left - 1]) );
        }
        sc.close(); // 记得释放内存
    }
}
