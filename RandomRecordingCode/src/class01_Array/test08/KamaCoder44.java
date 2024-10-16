package class01_Array.test08;

import java.util.Arrays;
import java.util.Scanner;

public class KamaCoder44 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //n行m列
        int n  = sc.nextInt();
        int m = sc.nextInt();
        int[] rowSum = new int[n]; //n个行和
        int[] colSum = new int[m]; //m个列和

        //n行 j列
        for(int i = 0; i < n ; i++) {
            for (int j = 0; j < m; j++) {
                int num = sc.nextInt();
                rowSum[i] = j == 0 ? num : rowSum[i] + num;
                //colSum[j] = i == 0 ? num : colSum[j]+ num;
                colSum[j] = i == n-1 ? ( j == 0 ? colSum[j] + num : colSum[j - 1] + colSum[j] + num) : (i == 0 ? num : colSum[j]+ num); //最后一行时统计列前缀
            }
            //计算行前缀和
            rowSum[i] = i == 0 ? rowSum[i] : rowSum[i-1] + rowSum[i];
        }

        //计算行划分最小差值, n个行前缀和
        int min = Integer.MAX_VALUE;
        int all = rowSum[n-1];

        //对于每个前缀和可视作一种方案 ,总和 - A价值 = B价值,计算 A 与 B的价值差,即是 |(总和 - A) - A|
        for(int i = 0 ; i < n - 1; i++){
            min = Math.min(Math.abs(all - 2 * rowSum[i]),min);
        }
        for(int i = 0; i < m - 1; i++){
            min = Math.min(Math.abs(all - 2 * colSum[i]),min);
        }

       /* System.out.println(Arrays.toString(rowSum));
        System.out.println(Arrays.toString(colSum));*/
        System.out.println(min);

    }
}
