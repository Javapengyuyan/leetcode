package com.algorithms.DataStructure.homework;

import com.algorithms.niuke.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class DataStructure04 {
    /**
     *
     * 第四章：树
     *  树的定义就是递归的
     *  树：顺序存储、链式存储
     */

    //二叉树层次遍历
    public void levelOrder(TreeNode treeNode){
        Queue queue = new LinkedList();
        while (!queue.isEmpty()){
            ((LinkedList) queue).pop();
            if (treeNode.left != null){
                queue.add(treeNode.left);
            }
            if (treeNode.right != null){
                queue.add(treeNode.right);
            }
        }

    }

}
