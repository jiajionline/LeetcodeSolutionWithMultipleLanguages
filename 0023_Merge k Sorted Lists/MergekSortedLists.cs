/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode MergeKLists (ListNode[] lists) {
        return Merge(lists, 0, lists.Length-1);

    }

    private ListNode Merge(ListNode[] lists, int l, int r){
        if(l > r) return null;
        if(l == r) return lists[l];
        if(l+1 == r) return MergeTwoLists(lists[l],lists[r]);
        var m = (r-l)/2 + l;
        var left = Merge(lists, l, m);
        var right = Merge(lists, m+1,r);
        return MergeTwoLists(left, right);
    }

    private ListNode MergeTwoLists (ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = MergeTwoLists (l1.next, l2);
            return l1;
        } else {
            l2.next = MergeTwoLists (l1, l2.next);
            return l2;
        }
    }
}