package com.algorithms.niuke.Tree;

import com.algorithms.niuke.common.TreeNode;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Tree {
    /**
     * 二叉树遍历
     * 前序、中序、后序、层级
     * 递归、非递归
     *
     */
    //前序--递归
    public void PreOrderTravel(TreeNode root){
        if (root == null){
            return;
        }
        System.out.println(root.val);
        PreOrderTravel(root.getLeft());
        PreOrderTravel(root.getRight());
    }

    //前序--非递归
    public void PreTravel(TreeNode root){
        if (root == null){
            return;
        }
        Queue queue = new ArrayBlockingQueue(16);
        queue.add(root);
        while (queue != null){
            TreeNode treeNode = (TreeNode) queue.poll();
            System.out.println(treeNode.val);
            if (treeNode.getLeft() != null){
                queue.add(treeNode.left);
            }
            if (treeNode.right != null){
                queue.add(treeNode.right);
            }

        }

    }



}
