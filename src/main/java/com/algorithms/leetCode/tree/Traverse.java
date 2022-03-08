package com.algorithms.leetCode.tree;

import com.algorithms.niuke.common.TreeNode;

public class Traverse {


    public void traverseQ(TreeNode tree){
        //前序遍历
        //左子树
        traverseQ(tree.left);
        //中序遍历
        //右子树
        traverseQ(tree.right);
        //后序遍历
    }




}
