package leetCode.tree;

import niuke.common.TreeNode;

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
