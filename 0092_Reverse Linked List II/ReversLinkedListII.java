class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode prev = preHead;
        ListNode curr = prev.next;
        int index = 1;
        while(index < left) {
            prev = curr;
            curr = curr.next;
            index++;
        }

        ListNode lastNodeBeforeReverse = prev;
        while(index <= right) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            index++;
        }

        lastNodeBeforeReverse.next.next = curr;
        lastNodeBeforeReverse.next = prev;
        return preHead.next;

    }
}