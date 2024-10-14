package class04_String.test02;

public class Solution541 {

    //在[start,end)上做反转
    private static void rev(char[] s,int start,int end){
        end--;
        while(start<end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }


    public static String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        for(int i = 0;i < arr.length;) {
            rev(arr,i,Math.min(arr.length,i+k)); //剩下的部分反转
            i = i + 2 * k;
        }
        return new String(arr);
    }

    //前k个字符一定会反转,不足k个全反转
    /*public static String reverseStr(String s, int k) {
        int n = s.length();
        int seg = n / k;//段数,偶数段余数反转,奇数段余数保持
        int rest = n % k;//余数

        StringBuilder sb = new StringBuilder();

        for(int i = 1 ; i <= seg ; i++){
            if(i % 2 == 1){//反转
                for(int j = i * k - 1;j >= (i-1)*k; j--)
                    sb.append(s.charAt(j));
            }else{
                for(int j = (i-1) * k; j <= i * k - 1; j++)
                    sb.append(s.charAt(j));
            }

        }

        if(seg % 2 == 0){
            //偶数段余数反转
            for(int i = n - 1; i >= n - rest; i--){
                sb.append(s.charAt(i));
            }
        }else{
            for(int i = n - rest; i < n; i++){
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }*/
    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println(reverseStr(s,2));
    }
}
