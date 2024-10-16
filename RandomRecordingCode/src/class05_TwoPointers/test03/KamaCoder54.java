package class05_TwoPointers.test03;

import java.util.Scanner;

public class KamaCoder54 {
    /*public static String replaceNumber(String s){
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c >= '0' && c <= '9'){
                sb.append("number");
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }*/

    //本意是原地进行操作,但Java的String类无法修改. 但是实际上这题用StringBuilder构造更快且内存消耗更少.
    //原地从前往后遍历复杂度为O(n^2),因为每次插入number会让后面的字符后移
    //此处应该先扩容再从后往前处理
    public static String replaceNumber(String s){
        char[] old = s.toCharArray();
        int count = 0;
        //统计数字数
        for(char c: old){
            if(c >= '0' && c <= '9')
                count++;
        }
        char[] newS = new char[(s.length() - count)+ count * 6];
        for(int i = newS.length - 1, j = old.length - 1; j >= 0; j--) {
            if(old[j] >= '0' && old[j] <= '9') {
                newS[i--] = 'r';
                newS[i--] = 'e';
                newS[i--] = 'b';
                newS[i--] = 'm';
                newS[i--] = 'u';
                newS[i--] = 'n';
            }else{
                newS[i--] = old[j];
            }
        }
        return new String(newS);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(replaceNumber(s));
    }
}
