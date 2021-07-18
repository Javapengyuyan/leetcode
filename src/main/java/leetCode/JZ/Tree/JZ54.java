package leetCode.JZ.Tree;

import niuke.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JZ54 {

    public static int k,res;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.setLeft(new TreeNode(1));
        root.left.setRight(new TreeNode(2));
        root.setRight(new TreeNode(4));
        //System.out.println(kthLargest(root,1));
        List list = new ArrayList();
        int k= 2;
        list = deep(root,list);
        if (k > list.size()){
            System.out.println(-1);
        }
        Collections.reverse(list);
        System.out.println(list.get(k-1));
    }

    static public int kthLargest(TreeNode root, int k) {

        List list =new ArrayList();
        list = qx(root,list);
        if (k-1 > list.size()){
            return -1;
        }
        return (int) list.get(k-1);
    }

    static public List<Integer> qx(TreeNode root,List list){
        if (root != null){
            if (root.left != null){
                list.add(root.left.val);
                qx(root.left,list);
            }
            //list.add(root.val);
            if (root.right != null){
                list.add(root.right.val);
                qx(root.right,list);
            }
        }
        return list;
    }

    static public List<Integer> deep(TreeNode root,List list){
        if (root == null) return list;
        deep(root.left,list);
        list.add(root.val);
        deep(root.right,list);
        return list;
    }

    static public void dfs(TreeNode root){
        if (root == null) return;
        dfs(root.right);
        if (k==0)return;
        if (--k==0) res = root.val;
        dfs(root.left);
    }



}
