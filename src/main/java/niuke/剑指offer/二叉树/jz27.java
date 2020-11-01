package niuke.剑指offer.二叉树;

import niuke.common.TreeNode;

public class jz27 {
    public static void main(String[] args) {

    }

    /**
     * 镜像二叉树
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root ==null) return null;
        TreeNode left = root.left;
        root.right = mirrorTree(root.left);
        root.left = mirrorTree(left);
        return root;
    }
}
