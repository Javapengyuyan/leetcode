package com.algorithms.leetCode.tree;

import com.algorithms.niuke.common.TreeNode;

import java.util.Stack;

public class All226 {
    /**
     * 反转二叉树
     */

    Stack stack = new Stack();

    public void re(TreeNode root){
        addStack(root);
        while (stack != null){
            TreeNode treeNode = (TreeNode) stack.pop();
            reserve(treeNode);
        }

    }

    public void addStack(TreeNode root){
        if (root == null){
            return;
        }
        stack.add(root);
        addStack(root.left);
        addStack(root.right);
    }

    public void reserve(TreeNode root){
        if (root == null){
            return ;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        swap(root,left,right);
    }

    public void swap(TreeNode root,TreeNode left,TreeNode right){
        root.left = right;
        root.right = left;
    }

    //递归方式实现
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = left;
        root.left = right;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }



}
