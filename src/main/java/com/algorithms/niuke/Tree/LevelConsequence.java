package com.algorithms.niuke.Tree;

import com.algorithms.niuke.common.TreeNode;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;

public class LevelConsequence {

    /**
     * 二叉树层级遍历
     * @param args
     */
    public static void main(String[] args) throws Exception {
        /*Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();*/
        TreeNode root = new TreeNode(9);
        node(root);
        Hashtable hashtable = new Hashtable();



    }



    public static ArrayList<ArrayList<Integer>> node(TreeNode root){
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> queue = new ArrayList<>();
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()){
            ArrayList nodeList = new ArrayList();
            Integer size = treeNodes.size();
            for (;size>0;size--){
                TreeNode node = treeNodes.pollFirst();
                if (node.left != null){
                    treeNodes.addLast(node.left);
                }
                if (node.right != null){
                    treeNodes.addLast(node.right);
                }
                nodeList.add(node.val);
            }
            queue.add(nodeList);

        }
        return queue;
    }

    /**
     *  获取 HashMap 实际容量大小
     * @param hashMap
     * @return
     * @throws Exception
     */
    public static Integer getCapacity(HashMap hashMap) throws Exception {
        Method capacity = hashMap.getClass().getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        Integer realCapacity = (Integer) capacity.invoke(hashMap);
        return realCapacity;
    }


}
