package com.algorithms.leetCode.JZ.Tree;


import com.algorithms.niuke.common.TreeNode;

public class JZ68 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root.val < p.val && root.val < q.val){
            lowestCommonAncestor(root.right,p,q);
        }
        if (root.val > p.val && root.val > q.val){
            lowestCommonAncestor(root.left,p,q);
        }
        return root;

    }

    //JZ68--2
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){//4、节点为空--返回null
            return null;
        }
        if (root.val == p.val || root.val == q.val){//2、节点即为root--返回root
            return root;
        }
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left == null){//3、左子树没有--返回右子树
            return right;
        }
        if (right == null){//3、右子树没有--返回左子树
            return left;
        }
        return root;//4、两子树都有--返回root
    }


}
