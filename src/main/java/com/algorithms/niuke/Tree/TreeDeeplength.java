package com.algorithms.niuke.Tree;

import com.algorithms.niuke.common.TreeNode;

import java.util.Collections;
import java.util.HashMap;

public class TreeDeeplength {

    public volatile Integer x = 3;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        Integer length = treeDeep(root);
        System.out.println(length);
    }

    /**
     * 二叉树深度
     * @return
     */
    public static Integer treeDeep(TreeNode root){
        if (root == null){
            return 0;
        }
        Integer leftDeep = treeDeep(root.left);
        Integer rightDeep = treeDeep(root.right);
        return Math.max(leftDeep,rightDeep)+1;
    }


    public void test(){
        HashMap map = new HashMap();
        Integer a = 1;
        System.out.println(a<<1);
        System.out.println(a<<2);
        Integer b = 3;
        System.out.println(b<<3);
        Integer x = 4;
        System.out.println(x>>1);
        HashMap map2 = new HashMap();
        if (map == map2){
            System.out.println("引用类型相等");
        }else {
            System.out.println("引用类型不相等");
        }
        Integer i1 =40;
        Integer i2 = 40;
        if (i1 == i2){
            System.out.println("包装类相等");
        }else {
            System.out.println("包装类不相等");
        }
        System.out.println(7%4);
        System.out.println(Math.floorMod(7,4));
        System.out.println(-7%4);
        System.out.println(Math.floorMod(-7,4));
        System.out.println(7%-4);
        System.out.println(Math.floorMod(7,-4));
        Collections.synchronizedMap(new HashMap<>(16));


    }


}
