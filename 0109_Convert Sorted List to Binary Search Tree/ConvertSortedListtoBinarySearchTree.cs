public class Solution {
    private ListNode p;
    public TreeNode SortedListToBST(ListNode head) {
        if(head == null) return null;
        p = head;
        var len = Length(head);
        return SortedListToBST(0, len-1);
    }
    
    private int Length(ListNode head)
    {
        var len = 0;
        while(head!=null)
        {
            len++;
            head = head.next;
        }
        
        return len;
    }
    
    private TreeNode SortedListToBST(int l, int r)
    {
        if(l > r) return null;
        int mid = (r - l)/2 + l;
        var lNode = SortedListToBST(l, mid-1);
        var root = new TreeNode(p.val);
        root.left = lNode;
        p = p.next;
        var rNode = SortedListToBST(mid+1, r);
        root.right = rNode;
        return root;
    }
}