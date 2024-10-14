package class01_Array.test03;

/**
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 *
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 * */

public class Solution844 {
    public static boolean backspaceCompare1(String s, String t) {
        StringBuilder sb1 = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch != '#'){
                sb1.append(ch);
            }else{
                if(sb1.length() > 0)
                    sb1.deleteCharAt(sb1.length() - 1);
            }
        }

        StringBuilder sb2 = new StringBuilder();
        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            if(ch != '#'){
                sb2.append(ch);
            }else{
                if(sb2.length() > 0)
                    sb2.deleteCharAt(sb2.length() - 1);
            }
        }
        return sb1.toString().equals(sb2.toString());
    }

    public static boolean backspaceCompare(String s, String t) {
        //逆序寻找字符比较
        int p1 = s.length() - 1;
        int p2 = t.length() - 1;
        int skip1 = 0;
        int skip2 = 0;

        while( p1 >= 0 || p2 >= 0){

            while(p1 >= 0){
                if(s.charAt(p1) == '#') {
                    skip1++;
                    p1--;
                }else if(skip1 > 0){//当前字符需要被删除
                    skip1 --;
                    p1--;
                }else //找到字符
                    break;
            }

            while(p2 >= 0){
                if(t.charAt(p2) == '#') {
                    skip2++;
                    p2--;
                }else if(skip2 > 0){//当前字符需要被删除
                    skip2 --;
                    p2--;
                }else //找到字符
                    break;
            }

            //如果两个字符都存在
            if(p1 >= 0 && p2 >= 0){
                if(s.charAt(p1) != t.charAt(p2))
                    return false;
            }else{
                //如果有一个串遍历没结束,另一个串是字符
                if(p1 >= 0 || p2 >= 0){
                    return false;
                }
            }
            p1 --;
            p2 --;
        }
        //两个串都遍历结束
        return true;
    }
    public static void main(String[] args) {
        String s = "ab#c";
        String t = "ad#c";
        System.out.println(backspaceCompare(s,t));
    }
}
