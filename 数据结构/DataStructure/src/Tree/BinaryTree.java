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
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
        System.out.print(root.val+" ");
    }
}
