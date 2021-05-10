package leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

public class N94 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        add(root, result);
        return result;
    }

    // 递归
    public void add(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        add(node.left, list);
        list.add(node.val);
        add(node.right, list);
    }

    @Test
    void test() {

        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(3, node6, node7);

        TreeNode root = new TreeNode(1, node2, node3);

//        List<Integer> list = inorderTraversal(root);
        List<Integer> list = inorderTraversal2(root);

        System.out.println(list);
        // 4 2 5 1 6 3 7
    }

    // 双向队列
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            result.add(root.val);

            root = root.right;
        }
        return result;
    }
}
