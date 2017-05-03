namespace LeetcodePracticeCsharpVersion
{
    class DeleteNodeinaLinkedList
    {
        public void DeleteNode(ListNode node)
        {
            if (node == null || node.next == null) return;
            var next = node.next;
            node.next = next.next;
            node.val = next.val;
        }
    }
}
