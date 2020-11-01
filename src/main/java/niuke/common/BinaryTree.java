package niuke.common;

public class BinaryTree {
    private TreeNode root;
    public TreeNode insert(TreeNode node,Integer value){
        TreeNode newNode = new TreeNode(value);
        if (root.val == null){
            root = newNode;
            return newNode;
        }
        if (node.val > value){
            insert(node.left,value);
        }else {
            insert(node.right,value);
        }
        return newNode;
    }



}
