package leetcode100;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class N107 {

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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null){
            return res;
        }

        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);

        while (nodeList.size() > 0) {
            List<Integer> subList = new ArrayList<>();

            int size = nodeList.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = nodeList.get(i);
                subList.add(treeNode.val);

                TreeNode left = treeNode.left;
                TreeNode right = treeNode.right;

                if (left != null) {
                    nodeList.add(left);
                }
                if (right != null) {
                    nodeList.add(right);
                }
            }

            for (int i = size - 1; i >= 0; i--) {
                nodeList.remove(i);
            }

            res.add(subList);
        }

        Collections.reverse(res);

        return res;
    }


    @Test
    void t() {

        TreeNode root = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        root.left = node9;
        root.right = node20;

        node20.left = node15;
        node20.right = node7;

        List<List<Integer>> lists = levelOrderBottom(root);

        System.out.println(lists);
    }
}
