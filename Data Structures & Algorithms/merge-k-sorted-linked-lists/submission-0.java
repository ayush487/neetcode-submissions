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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        int n = 0;
        for (ListNode hNode : lists) {
            ListNode temp = hNode;
            while (temp != null) {
                n++;
                temp = temp.next;
            }
        }

        ListNode temp = null;
        for (int i = 0; i < n; i++) {
            ListNode minNode = findMinimum(lists);
            if (i == 0) {
                head = minNode;
                temp = head;
            } else {
                temp.next = minNode;
                temp = temp.next;
            }
        }
        return head;
    }

    private ListNode findMinimum(ListNode[] nodeArr) {
        int[] minimum = {-1, Integer.MAX_VALUE};
        for (int i = 0; i < nodeArr.length; i++) {
            if (nodeArr[i] == null) continue;
            if (nodeArr[i].val < minimum[1]) {
                minimum[0] = i;
                minimum[1] = nodeArr[i].val;
            }
        }
        ListNode returnNode = nodeArr[minimum[0]];
        nodeArr[minimum[0]] = returnNode.next;
        return returnNode;
    }
}
