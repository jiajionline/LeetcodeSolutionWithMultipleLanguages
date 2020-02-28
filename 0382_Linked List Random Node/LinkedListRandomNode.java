public class Solution {
    private ListNode _head;
    private Random r = new Random();

    public Solution(ListNode head) {
        _head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        ListNode temp = _head;
        ListNode ret = null;
        int index = 1;
        while (temp != null) {
            if (r.nextInt(index++) == 0) {
                ret = temp;
            }

            temp = temp.next;

        }

        return ret.val;
    }
}