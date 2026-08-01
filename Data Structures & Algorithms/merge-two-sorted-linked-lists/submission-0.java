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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return recurse(list1, list2);

        
    }

    public ListNode recurse(ListNode u, ListNode d) {
        // hit end, return the other.
        if (u == null) {
            return d;
        }

        if (d == null) {
            return u;
        }

        if (d.val < u.val) {
            ListNode temp = d;
            d = u;
            u = temp;
        }

        u.next = recurse(u.next, d);
        return u;
    }
}