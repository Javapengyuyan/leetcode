package leetCode.JZ;

import niuke.common.TreeNode;

public class JZ26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //遍历A树
        if (A == null || B == null){
            return false;
        }

        return contain(A,B) ||isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }

    /**
     *  判断 a 是否包含 b
     * @param a
     * @param b
     * @return
     */
    public boolean contain(TreeNode a,TreeNode b){
        if (b == null){
            return true;
        }
        if ( a == null || a.val != b.val){
            return false;
        }
        return contain(a.left,b.left) && contain(a.right,b.right);
    }

   /* public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    boolean recur(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }*/

}
