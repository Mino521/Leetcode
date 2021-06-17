class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = getLength(head);
        int target = len-n;
        ListNode current = head;
        if(len <=1)
            return null;
        if(target == 0)
            return head.next;
        for(int i = 1; i < target; i++)
            current = current.next;
        current.next = current.next.next;
        return head;
    }

    public int getLength(ListNode head){
        int n = 0;
        while(head != null){
            head = head.next;
            n++;
        }
        return n;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}