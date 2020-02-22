class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode preHeader = new ListNode(-1);
		ListNode current = preHeader;
		ListNode p1 = l1;
		ListNode p2 = l2;

		while (p1 != null && p2 != null) {
			if (p1.val < p2.val) {
				current.next = p1;
				current = p1;
				p1 = p1.next;
			} else {
				current.next = p2;
				current = p2;
				p2 = p2.next;
			}
		}

		if (p1 != null) {
			current.next = p1;
		}

		if (p2 != null) {
			current.next = p2;
		}

		return preHeader.next;

	}
}
