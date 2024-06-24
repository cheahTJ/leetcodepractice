

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode hare = head;
        ListNode tor = head;
        if (head == null || head.next == null) return null;
        ListNode meetingPoint =  new ListNode(0);
        
        if (hare.next == null || hare.next.next == null) {
            return null;
        } else {
            hare = hare.next;
            hare = hare.next;
            tor = tor.next;
        }
        
        while (hare != tor) {
            if (hare.next == null || hare.next.next == null) {
                return null;
            } else {
                hare = hare.next;
                hare = hare.next;
            }
            tor = tor.next;
        }

        meetingPoint = hare;
        while(head != meetingPoint) {
            head = head.next;
            meetingPoint = meetingPoint.next;
        }
        return head;
    }
}