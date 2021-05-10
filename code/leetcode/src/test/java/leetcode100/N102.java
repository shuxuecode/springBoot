package leetcode100;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class N102 {


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

    // 列表解法
    public List<List<Integer>> levelOrder2(TreeNode root) {
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

        return result;
    }

    // 队列解法
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();

            // 先获取size，知道遍历的次数，避免循环中添加元素导致循环逻辑出错
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();

                list.add(treeNode.val);

                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }

            result.add(list);
        }

        return result;
    }


    @Test
    public void test() {

        TreeNode root = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        root.left = node9;
        root.right = node20;

        node20.left = node15;
        node20.right = node7;

        List<List<Integer>> lists = levelOrder(root);

        System.out.println(lists);
    }
}
