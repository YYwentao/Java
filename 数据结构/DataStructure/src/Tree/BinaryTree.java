package Tree;

/**
 * ClassName: BinaryTree
 * Description:
 * date: 2021/5/2 12:44
 *
 * @author wt
 * @since JDK 1.8
 */
class Node{
    public char val;
    public Node left;
    public Node right;

    public Node(char val) {
        this.val = val;
    }
}
public class BinaryTree {
    public Node createTree() {
        Node A =new Node('A');
        Node B =new Node('B');
        Node C =new Node('C');
        Node D =new Node('D');
        Node E =new Node('E');
        Node F =new Node('F');
        Node G =new Node('G');
        Node H =new Node('H');
        A.left = B;
        A.right =C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;
        return A;
    }

    // 前序遍历
    void preOrderTraversal(Node root){
        if (root == null) return;
        System.out.print(root.val+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);

    }
    // 中序遍历
    void inOrderTraversal(Node root){
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.val+" ");
        inOrderTraversal(root.right);
    }
    // 后序遍历
    void postOrderTraversal(Node root){
        if (root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val+" ");
    }

    // 遍历思路-求结点个数
    static int size = 0;
    void getSize1(Node root){
        if (root == null) return;
        size = size+1;
        getSize1(root.left);
        getSize1(root.right);
    }
    // 子问题思路-求结点个数
    int getSize2(Node root){
        if (root == null) return 0;
        return getSize2(root.left)+getSize2(root.right) + 1;
    }

    // 遍历思路-求叶子结点个数
    static int leafSize = 0;
    void getLeafSize1(Node root){
        if (root == null) return;
        if (root.left == null && root.right == null) {
            leafSize++;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);
    }
    // 子问题思路-求叶子结点个数
    int getLeafSize2(Node root){
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafSize2(root.left) + getLeafSize2(root.right);
    }

    // 子问题思路-求第 k 层结点个数
    int getKLevelSize(Node root){
        return -1;
    }
    // 获取二叉树的高度
    int getHeight(Node root){
        return -1;
    }
    // 查找 val 所在结点，没有找到返回 null
    // 按照 根 -> 左子树 -> 右子树的顺序进行查找
    // 一旦找到，立即返回，不需要继续在其他位置查找
    Node find(Node root, int val){
        return null;
    }
}
