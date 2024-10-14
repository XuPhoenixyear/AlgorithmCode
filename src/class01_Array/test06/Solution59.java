package class01_Array.test06;

public class Solution59 {
    public static int[][] generateMatrix(int n) {
        int startX = 0,startY = 0;
        int loop = 1; //当前圈数,共 n/2圈
        int count = 1;
        int offset = 1;
        int[][] arr = new int[n][n];
        int i = 0,j = 0;

        while(loop <= n /2 ){

            //向右
            for(i = startX, j = startY; j < n - offset; j++){
                arr[i][j] = count++;
            }

            //向下
            for(i = startX ; i < n - offset; i++){
                arr[i][j] = count++;
            }

            //向左 (i,j)为右下角
            for(;j >= offset; j--){
                arr[i][j] = count ++;
            }

            //向上 (i,j)为左下角
            for(;i >= offset;i--){
                arr[i][j] = count++;
            }

            //一圈结束,此时更新边界值

            startX++; //更新起始点
            startY++;
            offset++;//更新边距
            loop++; //进入下一圈
        }

        //n为奇数,中心值需单独处理
        if(n % 2 == 1)
            arr[startX][startY] = count;
        return arr;
    }


    public static void main(String[] args) {
        int n = 3;

        int[][] arr = generateMatrix(n);
        for(int i = 0; i < arr.length; i++){
            for(int j = 0 ; j < arr[0].length; j++){
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
