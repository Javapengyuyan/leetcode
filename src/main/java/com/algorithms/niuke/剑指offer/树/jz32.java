package com.algorithms.niuke.剑指offer.树;

import com.algorithms.niuke.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class jz32 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        levelOrder2(treeNode);
        //测试提交

    }

    /**
     * 从上到下打印二叉树（广度优先搜索）
     * @param root
     * @return
     */
    public static int[] levelOrder2(TreeNode root) {
        if (root == null) return new int[0];
        //queue简便写法
        Queue<TreeNode> queue = new LinkedList(){{add(root);}};
        /**
         * 队列使用，offer优于add（不能添加返回false）
         * poll优于remove（为空时返回null而不是错误）
         * peek优于element(查询元素)
         */
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            arrayList.add(node.val);
            if(root.left != null) queue.offer(root.left);
            if(root.right != null) queue.offer(root.right);

        }
        int[] abs = new int[arrayList.size()];
        for (int i=0;i<arrayList.size();i++){
            abs[i] = arrayList.get(i);
        }
        return abs;
    }


}
