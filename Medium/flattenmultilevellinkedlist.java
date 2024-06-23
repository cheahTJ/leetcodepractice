import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};


class Triplet {
    public Node curr;
    public Node nxt;
    public Node children;
    public Triplet(Node curr, Node nxt, Node children) {
        this.curr = curr;
        this.nxt = nxt;
        this.children = children;
    }
}

class Solution {
    public Node flatten(Node head) {
        Node current = head;
        Queue<Triplet> q = new LinkedList<Triplet>();
        if (head == null) return null;

        while (current != null || !q.isEmpty()) {
            if (current.child != null) {
                Triplet t = new Triplet(current, current.next, current.child);
                q.add(t);
                current.child = null;
            }

            if (!q.isEmpty()) {
                Triplet t1 = q.remove();
                t1.curr.next = t1.children;
                t1.children.prev = t1.curr;
                Node temp = t1.children;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = t1.nxt;
                if (t1.nxt != null) {
                    t1.nxt.prev = temp;
                }


            } 
            current = current.next;
            

        }
        
        return head;  
    }
}
