package niuke.剑指offer.线性表;

import niuke.common.TreeNode;

import java.util.Stack;

public class DataStructure03 {
    /**
     * 栈：栈顺序存储、链式存储两种。
     *
     * 应用：1、括号匹配
     *  2、层次遍历
     */

    //层次遍历
    public void traversing(TreeNode head){
        Stack<TreeNode> stack = new Stack();
        if (head.left != null){
            stack.push(head.left);
        }
        if (head.right != null){
            stack.push(head.right);
        }
        if (!stack.isEmpty()){
            traversing(stack.pop());
        }
    }


}
