package Tree;


/**
 * ClassName: TestDemo
 * Description: 二叉树实现
 * date: 2021/5/2 12:59
 * @author wt
 * @since JDK 1.8
 */
public class TestDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.createTree();

        System.out.print("非递归前序遍历: ");
        binaryTree.preOrderTraversalNor(root);
        System.out.println();
        System.out.print("递归前序遍历: ");
        binaryTree.preOrderTraversal(root);

        System.out.println();
        System.out.print("非递归中序遍历: ");
        binaryTree.inOrderTraversalNor(root);
        System.out.println();
        System.out.print("递归中序遍历: ");
        binaryTree.inOrderTraversal(root);

        System.out.println();
        System.out.print("非递归后序遍历: ");
        binaryTree.postOrderTraversalNor(root);
        System.out.println();
        System.out.print("递归后序遍历: ");
        binaryTree.postOrderTraversal(root);
        System.out.println();
//        System.out.print("层序遍历: ");
//        binaryTree.levelOrderTraversal(root);
//        System.out.println();
//
//        System.out.println("节点个数");
//        binaryTree.getSize1(root);
//        System.out.println(BinaryTree.size);
//        System.out.println(binaryTree.getSize2(root));
//
//        System.out.println("叶子节点：");
//        binaryTree.getLeafSize1(root);
//        System.out.println(BinaryTree.leafSize);
//        System.out.println(binaryTree.getLeafSize2(root));
//        System.out.println("树第K层的节点："+binaryTree.getKLevelSize(root, 3));
//        System.out.println("树的高度: "+binaryTree.getHeight(root));
//        Node ret = binaryTree.find(root, 'B');
//        System.out.println(ret.val);
//        System.out.println("是否为完全二叉树："+binaryTree.isCompleteTree(root));

    }
}
