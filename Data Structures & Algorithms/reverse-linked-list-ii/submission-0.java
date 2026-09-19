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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode curr = head;
        int i = 1;
        ListNode beforeRev = null;
        while (i != left) {
            beforeRev = curr;
            curr = curr.next;
            i++;
        }
        int tempI = i;
        ListNode temp = beforeRev;
        while (tempI <= right) {
            if (tempI==1) temp = head;
            else temp = temp.next;
            tempI++;
        }
        ListNode nextAfterRev = temp.next;
        ListNode prev = null;
        while (i <= right) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            i++;
        }
        if (left == 1) head = prev;
        else beforeRev.next = prev;
        while (prev.next != null) {
            prev = prev.next;
        }
        prev.next = nextAfterRev;
        return head;
    }
}