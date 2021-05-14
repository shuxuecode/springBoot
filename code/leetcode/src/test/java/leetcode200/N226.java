package leetcode200;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class N226 {

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


    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

//        TreeNode treeNode = root;
//
//
//        TreeNode node = invertNode(treeNode);
//
//        TreeNode left = node.left;
//        while (left != null) {
//            left = invertNode(left);
//            left = left.left;
//        }
//
//        TreeNode right = node.right;
//        while (right != null) {
//            right = invertNode(right);
//            right = right.right;
//        }

        return invertNode(root);

//        return node;
    }

    public TreeNode invertNode(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode left = node.left;
        node.left = node.right;
        node.right = left;

        invertNode(node.left);
        invertNode(node.right);

        return node;
    }


    @Test
    void t() {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        root.left = node2;
        root.right = node3;

        node2.left = node4;
        node2.right = node5;

        print(root);

        TreeNode tree = invertTree(root);

        print(tree);
    }


    public List<List<Integer>> print(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<TreeNode> nodeList = new ArrayList<>();

        nodeList.add(root);

        while (!nodeList.isEmpty()) {
            List<Integer> list = new ArrayList<>();

            List<TreeNode> newNodeList = new ArrayList<>();

            for (TreeNode treeNode : nodeList) {
                list.add(treeNode.val);

                if (treeNode.left != null) {
                    newNodeList.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    newNodeList.add(treeNode.right);
                }
            }

            nodeList.clear();
            nodeList.addAll(newNodeList);

            result.add(list);
        }

        System.out.println(result);

        return result;
    }
}
