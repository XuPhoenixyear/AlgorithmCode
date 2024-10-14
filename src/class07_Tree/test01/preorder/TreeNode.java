package class07_Tree.test01.preorder;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode createTree(Integer[] arr){
        if(arr == null || arr.length == 0 || arr[0] == null) return null;
        TreeNode root = new TreeNode(arr[0]);
        process(root,arr,0);
        return root;
    }

    private static void process(TreeNode cur,Integer[]arr,int index){
        if(cur == null || index >= arr.length) return;
        if(index * 2 + 1 < arr.length) {
            cur.left = new TreeNode(arr[index * 2 + 1]);
        }else
            cur.left = null;
        if(index * 2 + 2 < arr.length) {
            cur.right = new TreeNode(arr[index * 2 + 2]);
        }else
            cur.right = null;

        process(cur.left,arr,index*2 + 1);
        process(cur.right,arr,index*2 + 2);
    }

}