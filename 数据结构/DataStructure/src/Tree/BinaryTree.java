package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * ClassName: BinaryTree
 * Description: 二叉树实现
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

    /**
     *递归遍历
     */
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
    // 层序遍历
    void levelOrderTraversal(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            //访问元素
            System.out.print(cur.val+" ");
            //左右子树入队列
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }
    /**
     * 非递归遍历
     */
    // 前序遍历
    void preOrderTraversalNor(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                System.out.print(cur.val+" ");
                cur = cur.left;
            }
            Node top = stack.pop();
            cur = top.right;
        }
    }
    // 中序遍历
    void inOrderTraversalNor(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur !=null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            Node top = stack.pop();//取栈顶
            System.out.print(top.val+" ");
            cur = top.right;
        }
    }

    // 后序遍历
    void postOrderTraversalNor(Node root) {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        Node prev = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();//
            if (cur.right == null || cur.right == prev) {//如果发现cur.right等于打印的值，进出循环pop()出栈并打印栈顶元素
                stack.pop();
                System.out.print(cur.val+" ");
                prev = cur;//记录cur打印的值
                cur = null;//cur置为空，目的是不进入内部while循环，防止再次把打印的元素放入栈

            } else {
                cur = cur.right;
            }
        }
    }

    /**
     * 求结点个数
     */
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

    /**
     * 求叶子结点个数
     */
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

    /**
     * 求第 k 层结点个数
     */
    // 子问题思路-求第 k 层结点个数
    int getKLevelSize(Node root,int k){
        if (root == null) return 0;
        if (k == 1) {
            return 1;
        }
        return getKLevelSize(root.left,k-1) + getKLevelSize(root.right,k-1);
    }
    // 获取二叉树的高度
    int getHeight(Node root){
        if (root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return leftHeight > rightHeight ?
                leftHeight+1:rightHeight+1;
    }
    // 查找 val 所在结点，没有找到返回 null
    // 按照 根 -> 左子树 -> 右子树的顺序进行查找
    // 一旦找到，立即返回，不需要继续在其他位置查找
    Node find(Node root, char val){
        if (root == null) return null;
        if (root.val == val) {
            return root;
        }
        Node r = find(root.left,val);
        if (r != null) {
            return r;
        }
        r = find(root.right,val);
        if (r != null) {
            return r;
        }
        return null;
    }
    /**
     * 判断一颗二叉树是否是平衡二叉树  (一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1 )
     */
    public boolean isBalanced(Node root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        //看当前节点对应的子树是否平衡
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (leftHeight-rightHeight > 1 || leftHeight-rightHeight < -1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    /**
     * 判断一颗二叉树是否是完全二叉树  (意思就是中间没有空隙)
     */
    boolean isCompleteTree(Node root){
        if (root == null) return true;
        //1.队列
        Queue<Node> queue = new LinkedList<>();
        //2.往队列里扔元素 ，出队列(==null)
        queue.offer(root);
        while (!queue.isEmpty()) {
             Node cur = queue.poll();
             if (cur != null) {
                 queue.offer(cur.left);
                 queue.offer(cur.right);
             } else {
                 break;
             }
        }
        //代码走到这里，说明上面while循环是break跳出，poll的cur节点一定为空
        //3，继续判断队列，如果全部为null，为true,否则为false(因为如果是完全二叉树，一单弹出的元素为null了，后面必须全文空)
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur != null) {
                return false;
            }
        }
        return  true;
    }
    /**
     * 对称二叉树
     * 判断 root.left与 root.right 是否为镜像关系
     */
    public boolean isSymmetric(Node root) {
        if(root == null) return true;
        return isMirror(root.left,root.right);
    }
    private boolean isMirror(Node A, Node B) {
        if(A == null && B == null) return true;
        if (A == null || B == null) return false; //两者一个为空，一个非空
        if(A.val != B.val) {
            return false;
        }
        return isMirror(A.left,B.right) && isMirror(A.right,B.left);
    }

    /**
     * 3. 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先 。
     */
    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        if(root == null) return null;
        if(root == p || root ==q ) {
            return root;
        }
        //每个节点左右分别递归找p和q,理解根节点就行，后面节点都一样
        Node leftTree = lowestCommonAncestor(root.left,p,q);
        Node rightTree = lowestCommonAncestor(root.right,p,q);
        //左右都有值的话，如1--5，6--0，2--8祖先都是 3
        if(leftTree != null && rightTree != null) {
            return root;
        }
        if(leftTree !=null && rightTree == null) {
            return leftTree;
        }
        if(leftTree ==null && rightTree != null) {
            return rightTree;
        }
        return null;
    }
}

