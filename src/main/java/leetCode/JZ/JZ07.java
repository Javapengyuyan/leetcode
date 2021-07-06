package leetCode.JZ;

import niuke.common.TreeNode;

import java.util.HashMap;

public class JZ07 {
    //前序遍历划分 [ 3 | 9 | 20 15 7 ]
    //中序遍历划分 [ 9 | 3 | 15 20 7 ]
    static int[] preorder  = {3,9,20,15,7};;
    static HashMap<Integer,Integer> dic = new HashMap<>();
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        //this.preorder = preorder;
        int length = preorder.length;
        for (int i=0;i<inorder.length;i++){
            dic.put(inorder[i],i);
        }
        TreeNode treeNode =  recur(0,0,length-1);


    }


    /*int[] preorder;
    HashMap<Integer,Integer> dic = new HashMap<>();*/

    /**
     * 通过给定前序、中序遍历数组还原二叉树
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        /*this.preorder = preorder;
        int length = preorder.length;
        for (int i=0;i<inorder.length;i++){
            dic.put(inorder[i],i);
        }
        TreeNode treeNode =  recur(0,0,length-1);
        return treeNode;*/
        return null;
    }

    //递归遍历
    static TreeNode recur(int root,int left,int right){
        if (left > right){
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[root]);
        //根节点在中序遍历的位置
        int i = dic.get(preorder[root]);
        //遍历左子树
        treeNode.left =  recur(root+1,left,i-1);
        //遍历右子树
        treeNode.right = recur(root+1+1+i-1-left,i+1,right);
        return treeNode;

    }

}
