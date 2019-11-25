import java.util.Stack;

public class ReverseList {
  public static class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
      this.val = x;
    }

    @Override
    public String toString() {
      return "ListNode [val=" + this.val + ", next=" + this.next + "]";
    }


  }

  public ListNode reverseList(ListNode head) {
    Stack<ListNode> stack = new Stack<ListNode>();
    ListNode tmp;

    while ((tmp = head) != null) {
      stack.add(tmp);
      head = head.next;
    }

    tmp = stack.pop();
    head = tmp;
    this.fillNewList(head, stack);

    return head;
  }

  private void fillNewList(ListNode head, Stack<ListNode> stack) {
    if (stack.size() == 0) {
      head.next = null;
      return;
    }


    ListNode tmp = stack.pop();
    head.next = tmp;

    this.fillNewList(head.next, stack);
  }

}
