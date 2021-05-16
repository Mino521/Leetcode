/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode resCopy = res;
        int carry = 0, val = 0;
        while(l1 != null || l2 != null){
            if(l1 == null){
                val = (l2.val+carry) % 10;
                carry = (l2.val+carry) / 10;
            }
            else if(l2 == null){
                val = (l1.val+carry) % 10;
                carry = (l1.val+carry) / 10;
            }
            else{
                val = (l1.val+l2.val+carry) % 10;
                carry = (l1.val+l2.val+carry) / 10;
            }
            resCopy.next = new ListNode(val);
            resCopy = resCopy.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry == 1)
            resCopy.next = new ListNode(carry);
        return res.next;
    }
}