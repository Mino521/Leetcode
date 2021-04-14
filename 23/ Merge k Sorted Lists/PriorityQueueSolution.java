import java.util.PriorityQueue;

public class PriorityQueueSolution {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Node implements Comparable<Node> {
        int val;
        ListNode ptr;

        Node(int val, ListNode ptr) {
            this.val = val;
            this.ptr = ptr;
        }

        public int compareTo(Node node2) {
            return this.val - node2.val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        for(ListNode ln : lists){
            if(ln != null){
                q.offer(new Node(ln.val, ln));
            }
        }
        ListNode head = new ListNode(0);
        ListNode res = head;
        while (!q.isEmpty()){
            Node min = q.poll();
            head.next = min.ptr;
            head = head.next;
            if(head.next != null)
                q.offer(new Node(head.next.val, head.next));
        }
        return res.next;
    }
}