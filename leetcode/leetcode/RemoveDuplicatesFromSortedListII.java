/*
Given a sorted linked list, delete all nodes that have duplicate numbers, 
leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = prev.next;
        while (cur != null) {
            ListNode next = cur.next;
            while (next != null && cur.val == next.val) {
                next = next.next;
            }
            if (cur.next != next) {
                prev.next = next;
            }
            prev = prev.next;
            if (prev != null) {
                cur = prev.next;
            }
        }
        return dummy.next;
    }

}