package com.dinglevin.algorithm.others;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 描述：TreeTraverseTest
 *
 * @author dinglevin
 * @since 2021/6/11 15:23 周五
 */
public class TreeTraverseTest {
    @Test
    public void testPreOrderTraverse() {
        TreeTraverse.TreeNode root = buildTree();

        TreeTraverse.ListCollector collector1 = new TreeTraverse.ListCollector();
        TreeTraverse.preOrderTraverseRecursive(root, collector1);

        TreeTraverse.ListCollector collector2 = new TreeTraverse.ListCollector();
        TreeTraverse.preOrderTraverseStack(root, collector2);

        assertEquals(collector1.getResult(), collector2.getResult());
    }

    @Test
    public void testInOrderTraverse() {
        TreeTraverse.TreeNode root = buildTree();

        TreeTraverse.ListCollector collector1 = new TreeTraverse.ListCollector();
        TreeTraverse.inOrderTraverseRecursive(root, collector1);

        TreeTraverse.ListCollector collector2 = new TreeTraverse.ListCollector();
        TreeTraverse.inOrderTraverseStack(root, collector2);

        assertEquals(collector1.getResult(), collector2.getResult());
    }

    @Test
    public void testPostOrderTraverse() {
        TreeTraverse.TreeNode root = buildTree();

        TreeTraverse.ListCollector collector1 = new TreeTraverse.ListCollector();
        TreeTraverse.postOrderTraverseRecursive(root, collector1);

        TreeTraverse.ListCollector collector2 = new TreeTraverse.ListCollector();
        TreeTraverse.postOrderTraverseStack(root, collector2);

        assertEquals(collector1.getResult(), collector2.getResult());
    }

    private TreeTraverse.TreeNode buildTree() {
        TreeTraverse.TreeNode root = new TreeTraverse.TreeNode(5);
        root.left = new TreeTraverse.TreeNode(4, new TreeTraverse.TreeNode(8), null);
        root.right = new TreeTraverse.TreeNode(6, new TreeTraverse.TreeNode(3), 
                new TreeTraverse.TreeNode(7, null, 
                        new TreeTraverse.TreeNode(9)));
        return root;
    }
}
