package Tree;

/**
 * ClassName: BinarySearchTree
 * Description: 二叉搜索树
 * date: 2021/5/18 19:49
 *
 * @author wt
 * @since JDK 1.8
 */
public class BinarySearchTree {

    public Node root;

    //内部类优先使用静态内部类，不需要依赖外部类对象
    static class Node{
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }
    }
    /**
     * 中序遍历
     */
    public void  inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }
    /**
     * 在搜索树中查找 key，如果找到，返回 key 所在的结点，否则返回 null
     * @param key
     * @return
     */
    public  boolean search(int key) {
        if (root == null) return false;
        Node cur = root;
        while (cur != null) {
            if (cur.val > key) {
                cur = cur.left;
            } else if (cur.val < key) {
                cur = cur.right;
            } else {
                return true;
            }
        }
        return false;
    }
    /**
     * 插入
     */
    public void insert(int key) {
        Node node = new Node(key);
        if (root == null) {
            root = node;
            return;
        }

        Node cur = root;
        Node prev = cur;
        while (cur != null) {
            if (cur.val > key) {
                prev = cur;
                cur = cur.left;
            } else if (cur.val < key) {
                prev = cur;
                cur =cur.right;
            }
        }
        //cur的结点一定为空了
        if (prev.val > key) {
            prev.left = node;
        } else {
            prev.right = node;
        }
    }

    /**
     * 删除
     */
    public void remove(int key) {
        Node cur = root;
        Node prev = null;
        while (cur != null) {
            if (cur.val > key) {
                prev = cur;
                cur = cur.left;
            } else if (cur.val < key) {
                prev = cur;
                cur = cur.right;
            } else {
                //删除节点,感觉智商不够用了
                removeNode(prev,cur);
            }
        }
    }
    public void removeNode(Node parent,Node cur) {
        if(cur.left == null) {
            if(cur == root) {
                root = cur.right;
            }else if(cur == parent.left) {
                parent.left = cur.right;
            }else {
                parent.right = cur.right;
            }
        }else if(cur.right == null) {
            if(cur == root) {
                root = cur.left;
            }else if(cur == parent.left) {
                parent.left = cur.left;
            }else {
                parent.right = cur.left;
            }
        }else {
            Node tp = cur;
            Node t = tp.right;
            while (t.left != null) {
                tp = t;
                t = t.left;
            }
            //t.left == null
            cur.val = t.val;//替罪
            //
            if(tp.left == t) {
                tp.left = t.right;
            }else {
                tp.right = t.right;
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        int array [] = {5,3,4,1,7,8,2,6,0,9};
        for (int x:array) {
            binarySearchTree.insert(x);
        }
        System.out.println("查找元素："+binarySearchTree.search(1));
        System.out.println("中序遍历：");
        binarySearchTree.inorder(binarySearchTree.root);

        System.out.println();
        System.out.println("删除元素：5");
        binarySearchTree.remove(5);
        binarySearchTree.inorder(binarySearchTree.root);
    }
}
