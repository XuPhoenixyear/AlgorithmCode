package class03_Hash.test01;

public class Solution242 {


    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] arr = new int[26];
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();
        for(int i = 0 ; i < s.length(); i++){
            arr[S[i] - 97] ++;
            arr[T[i] - 97] --;
        }
        for(int i = 0 ; i < 26; i++){
            if(arr[i] != 0) return false;
        }
        return true;
    }

    /*public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] count = new int[26];
        for(char c : s.toCharArray()){
            count[c - 'a'] ++;
        }

        for(char c : t.toCharArray()){
            count[c - 'a'] --;
        }

        for(int i : count){
            if(i != 0) return false;
        }
        return true;
    }*/

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        System.out.println(isAnagram(s,t));
    }
}
