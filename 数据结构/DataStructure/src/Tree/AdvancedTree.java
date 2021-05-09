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
class AdvancedTree{
    public TreeNode createTree() {
        TreeNode A =new TreeNode('A');
        TreeNode B =new TreeNode('B');
        TreeNode C =new TreeNode('C');
        TreeNode D =new TreeNode('D');
        TreeNode E =new TreeNode('E');
        TreeNode F =new TreeNode('F');
        TreeNode G =new TreeNode('G');
        TreeNode H =new TreeNode('H');
        A.left = B;
        A.right =C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;
        return A;
    }

}

 class Main{
     /**
      * 1. 二叉树的构建及遍历
      */
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

    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入字符串的先序遍历：");
        String str = scan.nextLine();
        TreeNode root = creTree(str);
        System.out.println("中序遍历为：");
        postOrderTraversal(root);
    }



}

