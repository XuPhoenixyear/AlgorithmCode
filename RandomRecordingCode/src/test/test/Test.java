package test.test;

import java.util.Stack;

public class Test {
    public static int count = 0;
    public static class Point{
        public int x;
        public int y;
        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }

        public boolean equal(Point p){
            return x == p.x && y == p.y;
        }
    }

    public static void getPath(int[][]arr,Point src,Point obj){
        if(arr == null || arr.length == 0)
            return;
        Stack<Point> stack = new Stack<>();
        stack.push(src);
        arr[src.x][src.y] = 1;
        count++;
        if(process(arr,obj,stack)){
            while(!stack.isEmpty()){
                System.out.println("(" + stack.peek().x + "," + stack.peek().y + ")");
                stack.pop();
            }
            System.out.println();
        }
        else{
            System.out.println(false);
        }

    }

    public static boolean process(int[][]arr,Point obj,Stack<Point> stack){
        //所有点都走过且最后一个点是终点
        int all = arr.length * arr[0].length - 2;
        if(count >= all && obj.equal(stack.peek())){
            return true;
        }

        //走到终点但是不是所有点都走了
        if(obj.equal(stack.peek()) && count < all){
            return false; //此路不通
        }

        //没走到终点
        Point cur = stack.peek(); //当前位置
        int n = arr.length; //边界x
        int m = arr[0].length;//边界y


        //向上走
        if(!isBorder(new Point(cur.x - 1,cur.y),n,m) && arr[cur.x - 1][cur.y] != 1){
            //向上有路能走
            count++;
            arr[cur.x - 1][cur.y] = 1;
            stack.push(new Point(cur.x- 1,cur.y)); //向上走
            if(process(arr,obj,stack))
                return true;
            else{
                //向上走不通,回溯
                count --;
                stack.pop();
                arr[cur.x - 1][cur.y] = 0;
            }
        }


        //向右走
        if(!isBorder(new Point(cur.x,cur.y+1),n,m) && arr[cur.x][cur.y+1] != 1){
            //向右有路能走
            count++;
            arr[cur.x][cur.y+1] = 1;
            stack.push(new Point(cur.x,cur.y+1)); //向上走
            if(process(arr,obj,stack))
                return true;
            else{
                //向右走不通,回溯
                count--;
                stack.pop();
                arr[cur.x][cur.y+1] = 0;
            }
        }


        //向下走
        if(!isBorder(new Point(cur.x+1,cur.y),n,m) && arr[cur.x+1][cur.y] != 1){
            //向下有路能走
            count++;
            arr[cur.x+1][cur.y] = 1;
            stack.push(new Point(cur.x+1,cur.y)); //向上走
            if(process(arr,obj,stack))
                return true;
            else{
                //向下走不通,回溯
                count--;
                stack.pop();
                arr[cur.x+1][cur.y] = 0;
            }
        }

        //向左走
        if(!isBorder(new Point(cur.x,cur.y - 1),n,m) && arr[cur.x][cur.y - 1] != 1){
            //向左有路能走
            count++;
            arr[cur.x][cur.y - 1] = 1;
            stack.push(new Point(cur.x,cur.y - 1)); //向上走
            if(process(arr,obj,stack))
                return true;
            else{
                //向左走不通,回溯
                count--;
                stack.pop();
                arr[cur.x][cur.y - 1] = 0;
            }
        }
        return false; //四条路都走不通
    }

    public static boolean isBorder(Point p,int n,int m){
        if(p.x < 0 || p.x > n - 1 || p.y < 0 || p.y > m - 1){
            return true;
        }

        if(p.x == 4 && p.y == 2)
            return true;

        if(p.x == 0 && p.y == 0)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = new int[5][5];

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                arr[i][j] = 0;
            }
        }
        //getPath(arr,new Point(arr.length - 1,0),new Point(arr.length - 1,arr[0].length - 1));
        int all = arr.length * arr[0].length - 2;

        getPath(arr,new Point(0,1),new Point(4,3));
    }

}
