package concureency.chapterEight;

import niuke.common.TreeNode;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executor;

public class Parallel {

    public void sequential(List<TreeNode> nodes, Collection results){
        for (TreeNode n : nodes){
            results.add(n.val);
            nodes.add(n.left);
            sequential(nodes,results);
        }
    }

    public void sequential(final Executor executor,List<TreeNode> list,
                           final Collection results){
        for (final TreeNode n : list){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    results.add(n.left);
                    results.add(n.right);
                }
            });
            sequential(executor,list,results);
        }
    }


}
