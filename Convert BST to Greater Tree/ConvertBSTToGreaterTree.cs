namespace LeetcodePracticeCsharpVersion
{
    class ConvertBSTToGreaterTree
    {
        int currentTotal = 0;
        public TreeNode ConvertBST(TreeNode root)
        {
            PostPorder(root);

            return root;
        }

        private void PostPorder(TreeNode node)
        {
            if (node == null) return;
            PostPorder(node.right);

            node.val += currentTotal;
            currentTotal = node.val;

            PostPorder(node.left);
        }
    }
}
