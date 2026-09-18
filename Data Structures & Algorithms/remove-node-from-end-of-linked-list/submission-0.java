/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;
        while (temp!=null) {
            temp = temp.next;
            size++;
        }
        if (size==n) {
            head = head.next;
            return head;
        }
        int deletionIdx = size - n;
        int i = 0;
        temp = head;
        ListNode prev = null;
        while (i!=deletionIdx) {
            prev = temp;
            temp = temp.next;
            i++;
        }
        prev.next = temp.next;
        return head;
    }
}
