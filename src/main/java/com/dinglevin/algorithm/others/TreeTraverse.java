package com.dinglevin.algorithm.others;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.google.common.collect.Lists;

/**
 * 描述：TreeTraverse
 *
 * @author dinglevin
 * @since 2021/6/11 15:16 周五
 */
public class TreeTraverse {
    /**
     * 按层遍历：非递归
     *
     * @param node
     * @param visitor
     */
    public static void levelOrderTraverseQueue(TreeNode node, NodeVisitor visitor) {
        if (node == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            visitor.visit(current);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    /**
     * 前序遍历：递归
     *
     * @param node
     * @param visitor
     */
    public static void preOrderTraverseRecursive(TreeNode node, NodeVisitor visitor) {
        if (node == null) {
            return;
        }

        visitor.visit(node);
        preOrderTraverseRecursive(node.left, visitor);
        preOrderTraverseRecursive(node.right, visitor);
    }

    /**
     * 前序遍历：非递归
     *
     * @param node
     * @param visitor
     */
    public static void preOrderTraverseStack(TreeNode node, NodeVisitor visitor) {
        if (node == null) {
            return;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode current = node;
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                visitor.visit(current);
                stack.push(current);
                current = current.left;
            } else {
                TreeNode inner = stack.pop();
                current = inner.right;
            }
        }
    }

    /**
     * 中序遍历：递归
     *
     * @param node
     * @param visitor
     */
    public static void inOrderTraverseRecursive(TreeNode node, NodeVisitor visitor) {
        if (node == null) {
            return;
        }

        inOrderTraverseRecursive(node.left, visitor);
        visitor.visit(node);
        inOrderTraverseRecursive(node.right, visitor);
    }

    /**
     * 中序遍历：非递归
     *
     * @param node
     * @param visitor
     */
    public static void inOrderTraverseStack(TreeNode node, NodeVisitor visitor) {
        if (node == null) {
            return;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode current = node;
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode inner = stack.pop();
                visitor.visit(inner);
                current = inner.right;
            }
        }
    }

    /**
     * 后序遍历：递归
     *
     * @param node
     * @param visitor
     */
    public static void postOrderTraverseRecursive(TreeNode node, NodeVisitor visitor) {
        if (node == null) {
            return;
        }

        postOrderTraverseRecursive(node.left, visitor);
        postOrderTraverseRecursive(node.right, visitor);
        visitor.visit(node);
    }

    /**
     * 后序遍历：非递归
     *
     * @param node
     * @param visitor
     */
    public static void postOrderTraverseStack(TreeNode node, NodeVisitor visitor) {
        if (node == null) {
            return;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode current = node;
        TreeNode pre = null;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            if (!stack.isEmpty()) {
                current = stack.peek();
                if (current.right == null || pre == current.right) {
                    visitor.visit(current);
                    pre = current;
                    current = null;
                    stack.pop();
                } else {
                    current = current.right;
                }
            }
        }
    }

    public static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public interface NodeVisitor {
        void visit(TreeNode node);
    }

    public static class ListCollector implements NodeVisitor {
        private List<Integer> result = Lists.newArrayList();

        @Override
        public void visit(TreeNode node) {
            result.add(node.value);
        }

        public List<Integer> getResult() {
            return result;
        }
    }

    public static class PrintNodeVisitor implements NodeVisitor {
        public static final PrintNodeVisitor INSTANCE = new PrintNodeVisitor();

        @Override
        public void visit(TreeNode node) {
            System.out.print(node.value + ", ");
        }
    }
}
