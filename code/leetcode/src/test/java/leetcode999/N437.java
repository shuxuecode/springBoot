package leetcode999;

import org.junit.jupiter.api.Test;

/**
 * @author shuxuezhao
 * @date 2021/9/28
 */
public class N437 {


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

    int target = 0;
    int pathSum = 0;

    // todo 未通过
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return pathSum;
        }

        target = targetSum;


        dfs(root, root.val);

        return pathSum;
    }

    private void dfs(TreeNode node, int sum) {

        if (node.left != null) {
            int val = node.left.val;
            if (sum + val == target) {
                pathSum++;
            }
            if (sum + val < target) {
                dfs(node.left, sum + val);
            }

            dfs(node.left, node.left.val);
        }

        if (node.right != null) {
            int val = node.right.val;
            if (sum + val == target) {
                pathSum++;
            }
            if (sum + val < target) {
                dfs(node.right, sum + val);
            }

            dfs(node.right, node.right.val);
        }
    }


    @Test
    void t1() {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(-3);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(11);
        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(-2);
        TreeNode node9 = new TreeNode(1);


        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node4.left = node7;
        node4.right = node8;

        node5.right = node9;

        node3.right = node6;

        int pathSum = pathSum(node1, 8);

        System.out.println(pathSum);
    }

    @Test
    void t2() {
        //    5,4,8,11,null,13,4,7,2,null,null,5,1]

        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(5);
        TreeNode node10 = new TreeNode(1);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;

        node3.left = node5;
        node3.right = node6;

        node4.left = node7;
        node4.right = node8;

        node6.left = node9;
        node6.right = node10;

        int pathSum = pathSum(node1, 22);

        System.out.println(pathSum);


    }

}
