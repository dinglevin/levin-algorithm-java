package com.dinglevin.algorithm.leetcode;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * 描述：Number98Test
 *
 * @author dinglevin
 * @since 2021/6/10 17:57 周四
 */
public class Number0098Test {
    @Test
    public void testIsValidBST() {
        Number0098.TreeNode root1 = buildTreeNode1();
        assertTrue(new Number0098().isValidBST(root1));

        Number0098.TreeNode root2 = buildTreeNode2();
        assertFalse(new Number0098().isValidBST(root2));
    }

    private Number0098.TreeNode buildTreeNode1() {
        Number0098.TreeNode root = new Number0098.TreeNode(2);
        root.setLeft(new Number0098.TreeNode(1));
        root.setRight(new Number0098.TreeNode(3));
        return root;
    }

    private Number0098.TreeNode buildTreeNode2() {
        Number0098.TreeNode root = new Number0098.TreeNode(5);
        root.setLeft(new Number0098.TreeNode(4));
        root.setRight(new Number0098.TreeNode(6));

        root.getRight().setLeft(new Number0098.TreeNode(3));
        root.getRight().setRight(new Number0098.TreeNode(7));

        return root;
    }
}
