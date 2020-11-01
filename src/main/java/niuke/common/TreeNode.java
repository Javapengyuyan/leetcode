package niuke.common;

public class TreeNode {
    public Integer val;
    public TreeNode left;//左前区
    public TreeNode right;//右前驱
    public TreeNode leftChild;//左孩子
    public TreeNode rightChild;//右孩子
    public TreeNode (int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public Integer getval() {
        return val;
    }

    public void setval(Integer val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
