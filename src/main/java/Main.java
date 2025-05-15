import util.BinaryTree;
import util.TreeNode;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        for (int i = 0; i < n; i++) {
            tree.insertNode(arr[i]);
        }
        tree.inorderTraversal();
        tree.preorderTraversal();
        tree.postorderTraversal();
    }
}
