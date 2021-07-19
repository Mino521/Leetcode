/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        Node copyh = head;
        Node newList = new Node(head.val);
        Node newPtr = newList;
        Map<Node, Node> map = new HashMap<>();
        map.put(head,newList);
        while(head.next != null){
            newPtr.next = new Node(head.next.val);
            head = head.next;
            newPtr = newPtr.next;
            map.put(head,newPtr);
        }
        newPtr = newList;
        while (copyh != null){
            newPtr.random = map.get(copyh.random);
            newPtr = newPtr.next;
            copyh = copyh.next;
        }
        return newList;
    }
}