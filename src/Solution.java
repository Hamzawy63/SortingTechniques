import java.util.ArrayList;
import java.util.List;

/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode first = null;
        ListNode second = null;
        boolean found = true;
        while (found) {
            found = false;
            int min = Integer.MAX_VALUE;
            int idx = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val < min) {
                    found = true;
                    min = lists[i].val;
                    idx = i;
                }
            }
            if (found) {
                int val = lists[idx].val;
                if (first == null) {
                    first = new ListNode(val);
                    second = first;
                } else {
                    second.next = new ListNode(val);
                    second = second.next;
                }
                lists[idx] = lists[idx].next;
            }
        }
        return first;


    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        ListNode[] lists = {l1, l2, l3};
        ListNode res = mergeKLists(lists);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}