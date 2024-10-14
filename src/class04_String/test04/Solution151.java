package class04_String.test04;

import java.util.Arrays;

//翻转字符串里的单词
public class Solution151 {
    public static String reverseWords(String s) {
        //"掐头去尾": 去除首尾的空格
        String str1 = removeSpace(s.toCharArray());
        char[] str = str1.toCharArray();
        reverseString(str,0,str.length -1);

        return reverseWords(str);
    }

    //去除空格
    public static String removeSpace(char[] ch){
        StringBuilder sb = new StringBuilder();

        int start = 0;
        int end = ch.length - 1;

        while(ch[start] == ' ') start ++;
        while(ch[end] == ' ') end --;

        while(start <= end){
            //去掉中间的多余空格: 如果sb尾部已经存在空格,再次读到空格时不添加
            if(ch[start] != ' ' || sb.charAt(sb.length() - 1)!=' '){
                sb.append(ch[start]);
            }
            start++;
        }
        return sb.toString();
    }

    //反转字符串
    public static void reverseString(char[] ch,int start,int end){
        while(start <= end){
            char c = ch[start];
            ch[start] = ch[end];
            ch[end] = c;

            start++;
            end--;
        }
    }


    //反转字符串中的单词
    public static String reverseWords(char[] ch){
        //此时已经经过掐头去尾,首尾都是有效字符,单词之间以空格分隔
        int start = 0;
        int n = ch.length;
        while(start < n){
            int end = start;
            while(end < n && ch[end] != ' '){
                end ++;
            }
            //ch[end] = ' '
            reverseString(ch,start,end-1);
            start = end + 1;
        }
        return new String(ch);
    }

    public static void main(String[] args) {
        /*String s = "    headllo adae!  ";
        System.out.println(Arrays.toString(s.split(" ")));*/

        //方法1: 使用 split 分割的话,前面的空格会被识别为子串,尾部的多余空格会被丢弃.
        System.out.println(reverseWords("  hello! Hei.  "));
    }
}
