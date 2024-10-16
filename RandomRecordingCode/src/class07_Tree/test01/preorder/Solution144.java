package class07_Tree.test01.preorder;

import java.util.ArrayList;
import java.util.List;

public class Solution144 {
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        process(root,list);
        return list;
    }
    public static void process(TreeNode cur,List<Integer> list){
        if(cur == null) return;
        list.add(cur.val);
        process(cur.left,list);
        process(cur.right,list);
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,3,4,5};
        TreeNode root = TreeNode.createTree(arr);
        System.out.println(preorderTraversal(root));
    }
}
