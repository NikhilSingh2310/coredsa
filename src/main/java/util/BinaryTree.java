package util;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private TreeNode root;
    private final Queue<TreeNode> queue;

    public BinaryTree() {
        this.root = null;
        this.queue = new LinkedList<>();
    }

    public TreeNode getRootNode() {
        return root;
    }

    public void insertNode(int val) {
        TreeNode newNode = new TreeNode(val);
        if (root == null) {
            root = newNode;
            queue.add(root);
            return;
        }
        TreeNode cur = queue.peek();
        assert cur != null;
        if (cur.left == null) {
            cur.left = newNode;
        } else {
            cur.right = newNode;
            queue.poll();
        }
        queue.add(newNode);
    }

    public void inorderTraversal() {
        System.out.print("Inorder Traversal: ");
        inorderTraversalRec(root);
        System.out.println();
    }

    private void inorderTraversalRec(TreeNode node) {
        if (node == null) {
            return;
        }
        inorderTraversalRec(node.left);
        System.out.print(node.val + " ");
        inorderTraversalRec(node.right);
    }

    public void preorderTraversal() {
        System.out.print("Preorder Traversal: ");
        preorderTraversalRec(root);
        System.out.println();
    }

    private void preorderTraversalRec(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preorderTraversalRec(root.left);
        preorderTraversalRec(root.right);
    }

    public void postorderTraversal() {
        System.out.print("Postorder Traversal: ");
        postorderTraversalRec(root);
        System.out.println();
    }

    private void postorderTraversalRec(TreeNode root) {
        if (root == null) {
            return;
        }
        postorderTraversalRec(root.left);
        postorderTraversalRec(root.right);
        System.out.print(root.val + " ");
    }

    public int getHeightBFS() {
        return bfsHeightRec(root);
    }

    public int getHeightDFS() {
        return dfsHeightRec(root);
    }

    private int dfsHeightRec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(dfsHeightRec(root.left), dfsHeightRec(root.right));
    }

    private int bfsHeightRec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            height++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode parent = queue.poll();
                if (parent.left != null) {
                    queue.add(parent.left);
                }
                if (parent.right != null) {
                    queue.add(parent.right);
                }
            }
        }
        return height;
    }

}
