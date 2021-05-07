package Tree;

import java.util.Scanner;

class TreeNode{
    public char val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(char val) {
        this.val = val;
    }
}

 class Main{

    public static int i = 0;

    public static TreeNode creTree(String str) {
        TreeNode root =null;
        if(str.charAt(i)!= '#') {
            root = new TreeNode(str.charAt(i));
            i++;
            root.left = creTree(str);
            root.right = creTree(str);
        }else{
            i++;
        }
        return root;
    }
    //中序遍历
    public static void postOrderTraversal(TreeNode root) {
        if(root == null) return;
        postOrderTraversal(root.left);
        System.out.print(root.val+" ");
        postOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入字符串的先序遍历：");
        String str = scan.nextLine();
        TreeNode root = creTree(str);
        System.out.println("中序遍历为：");
        postOrderTraversal(root);
    }
}