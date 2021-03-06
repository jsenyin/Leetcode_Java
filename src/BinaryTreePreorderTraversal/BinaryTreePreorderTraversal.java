package BinaryTreePreorderTraversal;

import java.util.*;

/**
 * 144. Binary Tree Preorder Traversal
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 *  \
 *   2
 *  /
 * 3
 *
 * return [1,2,3].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 *
 * Testcase:
 * [1,2,3,4,5,6,7,null,null,8,null,null,9] -> [1,2,4,5,8,3,6,9,7]
 */
public class BinaryTreePreorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        List<Integer> list = new ArrayList<>();

        if(root == null)
            return list;

        stack.push(root);
        TreeNode node = null;

        while(!stack.empty()) {
            node = stack.pop();
            list.add(node.val);

            if(node.right != null)
                stack.push(node.right);

            if(node.left != null)
                stack.push(node.left);

        }

        return list;
    }

    // concise solution
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                result.add(p.val);  // Add before going to children
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                p = node.right;
            }
        }
        return result;
    }
}
