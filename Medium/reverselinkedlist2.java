

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode curr = head;
        ListNode prev = null;
        int counter = 1;

        while (counter < left) {
            prev = curr;
            curr = curr.next;
            counter++;
        }
        
        ListNode start = prev;
        ListNode end = curr;

        while (counter <= right) {
            ListNode after = curr.next;
            curr.next = prev;
            prev = curr;
            curr = after;
            counter++;
        }

        if (start != null) {
            start.next = prev;
        } else {
            head = prev;
        }

        end.next = curr;

        return head;
    }
}   
