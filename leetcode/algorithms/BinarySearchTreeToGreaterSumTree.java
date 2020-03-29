package leetcode.algorithms;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BinarySearchTreeToGreaterSumTree {
  public static class TreeNode {
    int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
      this.val = x;
    }

    @Override
    public String toString() {
      return "TreeNode [val=" + this.val + ", left=" + this.left + ", right=" + this.right + "]";
    }


  }


  public TreeNode bstToGst(TreeNode root) {
    TreeMap<Integer, Integer> ocurrences = new TreeMap<Integer, Integer>();
    Integer sum = 0;
    TreeNode current;
    Queue<TreeNode> bfs = new LinkedList<TreeNode>();
    bfs.add(root);
    while (bfs.size() > 0) {
      current = bfs.poll();

      if (current == null) {
        continue;
      }

      sum += current.val;

      if (!ocurrences.containsKey(current.val))
        ocurrences.put(current.val, 0);

      if (current.left != null)
        bfs.add(current.left);
      if (current.right != null)
        bfs.add(current.right);
    }

    // scan and update how should be deducted for each key
    Integer carry = 0;
    for (Map.Entry<Integer, Integer> e : ocurrences.entrySet()) {
      e.setValue(sum - carry);
      carry += e.getKey();
    }



    bfs.add(root);
    while (bfs.size() > 0) {
      current = bfs.poll();
      if (current == null) {
        continue;
      }
      current.val = ocurrences.get(current.val);

      if (current.left != null)
        bfs.add(current.left);
      if (current.right != null)
        bfs.add(current.right);
    }

    return root;
  }
}
