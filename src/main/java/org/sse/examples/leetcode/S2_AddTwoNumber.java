package org.sse.examples.leetcode;

public class S2_AddTwoNumber
{
     public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static void main(String[] args)
    {
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode();
        ListNode n = result;
        int carry = 0;

        while(l1 != null || l2 != null)
        {
            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;

            n.next = new ListNode();
            n = n.next;
            n.val = v1 + v2 + carry;

            if (n.val >= 10) {
                carry = n.val/10;
                n.val = n.val%10;
            } else carry = 0;

            if (l1 != null)
                l1 = l1.next;

            if (l2 != null)
                l2 = l2.next;
        }

        if (carry > 0)
            n.next = new ListNode(carry);


        return result.next;
    }
}
