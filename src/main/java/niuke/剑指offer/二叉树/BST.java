package niuke.剑指offer.二叉树;

import niuke.common.BinaryTree;
import niuke.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class BST {
    TreeNode root;
    //遍历二叉树
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        int[] tree = new int[]{5,3,4,6,7};
        BinaryTree binaryTree = new BinaryTree();
        for (int i=0;i<tree.length;i++){
            //binaryTree.insert(new TreeNode(),tree[i]);


        }
    }

    /**
     * 前序遍历
     * @param node
     */
    public void front(TreeNode node){
        if (node != null){
            System.out.println(node.val);
            front(node.left);
            front(node.right);
        }
    }

}
