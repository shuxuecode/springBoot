package leetcode100;

import org.junit.jupiter.api.Test;

import java.util.*;

public class N103 {

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

    // 列表实现,
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);

        int line = 1;

        while (!nodeList.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            List<TreeNode> newNodeList = new ArrayList<>();

            // 倒序遍历
            for (int i = nodeList.size() - 1; i >= 0; i--) {
                TreeNode treeNode = nodeList.get(i);

                list.add(treeNode.val);

                if (line % 2 == 0) {
                    if (treeNode.right != null) {
                        newNodeList.add(treeNode.right);
                    }
                    if (treeNode.left != null) {
                        newNodeList.add(treeNode.left);
                    }
                } else {
                    if (treeNode.left != null) {
                        newNodeList.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        newNodeList.add(treeNode.right);
                    }
                }
            }

            nodeList.clear();
            nodeList.addAll(newNodeList);

            result.add(list);
            line++;
        }
        return result;
    }

    // 双向队列实现
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int line = 0;

        while (!queue.isEmpty()) {

            Deque<Integer> deque = new LinkedList<>();

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();

                if (line % 2 == 0) {
                    deque.offerLast(treeNode.val);
                } else {
                    // 往头部插入元素，实现了反向遍历
                    deque.offerFirst(treeNode.val);
                }

                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }

            }

            result.add(new LinkedList<>(deque));
            line++;
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

        List<List<Integer>> list = zigzagLevelOrder(root);

        System.out.println(list);
    }
}
