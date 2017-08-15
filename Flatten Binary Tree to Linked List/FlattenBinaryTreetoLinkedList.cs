namespace LeetcodePracticeCsharpVersion
{
    class FlattenBinaryTreetoLinkedList
    {
        public void Flatten(TreeNode root)
        {
            if (root == null) return;
            var left = root.left;
            var right = root.right;

            root.left = null;
            Flatten(left);
            Flatten(right);

            root.right = left;
            TreeNode current = root;
            while (current.right != null) current = current.right;

            current.right = right;
        }
    }
}
