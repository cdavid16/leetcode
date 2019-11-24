
import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {
  public static class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
      this.val = x;
    }
  }

  public int maxDepth(TreeNode root) {
    int depth = 0;
    // initial case
    if (root == null)
      return depth;

    TreeNode current;
    Queue<TreeNode> bfs = new LinkedList<TreeNode>();
    bfs.add(root);
    bfs.add(null);
    while (bfs.size() > 0) {
      current = bfs.poll();

      if (current == null) {
        depth++;
        bfs.add(null);
        if (bfs.peek() == null)
          break;
        else
          continue;
      }

      if (current.left != null)
        bfs.add(current.left);
      if (current.right != null)
        bfs.add(current.right);


    }
    return depth;
  }
}
