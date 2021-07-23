class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null)
            return head;
        ListNode node = head;
        int len = 0;
        while(node != null){
            len++;
            node = node.next;
        }
        ListNode dummyHead = new ListNode(0,head);
        for(int subLength=1; subLength < len; subLength *= 2){
            ListNode pre = dummyHead, cur = dummyHead.next;
            while (cur != null){
                ListNode head1 = cur;
                for(int i = 1; i < subLength && cur.next != null; i++){
                    cur = cur.next;
                }
                ListNode head2 = cur.next;
                cur.next = null;
                cur = head2;
                for(int i = 1; i < subLength && cur != null && cur.next != null; i++){
                    cur = cur.next;
                }
                ListNode next = null;
                if(cur != null){
                    next = cur.next;
                    cur.next = null;
                }
                ListNode merged = merge(head1, head2);
                pre.next = merged;
                while(pre.next != null)
                    pre = pre.next;
                cur = next;
            }
        }
        return dummyHead.next;
    }

    public ListNode merge(ListNode head1, ListNode head2){
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while(temp1 != null && temp2 != null){
            if(temp1.val <= temp2.val){
                temp.next = temp1;
                temp1 = temp1.next;
            }
            else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if(temp1 != null)
            temp.next = temp1;
        else if(temp2 != null)
            temp.next = temp2;
        return dummyHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}