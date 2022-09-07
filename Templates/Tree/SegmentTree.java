class SegmentTree {
    
    public void update(SegmentTreeNode root, int i, int v) {
        if(root.start == i & root.end == i) {
            root.sum = v;
            return;
        }

        int mid = (root.end - root.start)/2 + root.start;
        if(i <= mid) {
            update(root.left, i, v);
        }else {
            update(root.right, i, v);
        }

        root.sum = root.left.sum + root.right.sum;
    }

    public int sumRange(SegmentTreeNode root, int i, int j) {    
    if (i == root.start && j == root.end) {
      return root.sum;
    }
    int mid = (root.end - root.start)/2 + root.start;
    if (j <= mid) {
      return sumRange(root.left, i, j);
    } else if (i > mid) {
      return sumRange(root.right, i, j);
    } else {
      return sumRange(root.left, i, mid) + sumRange(root.right, mid + 1, j);
    }
  }

    public SegmentTreeNode build(int start, int end) {
        if(start == end) return new SegmentTreeNode(start, end, null, null);
        int mid = (end - start)/2 + start;
        SegmentTreeNode left = build(start, mid, null, null);
        SegmentTreeNode right = build(mid+1, end, null, null);
        SegmentTreeNode node = new SegmentTreeNode(start, end, left, right);
        node.sum = left.sum + right.sum;
        return node;
    }

    class SegmentTreeNode {
        int start;
        int end;
        int sum;
        SegmentTreeNode left;
        SegmentTreeNode right;

        public SegmentTreeNode(int start, int end, SegmentTreeNode left, SegmentTreeNode right) {
            this.start = start;
            this.end = end;
            this.left = left;
            this.right = right;
        }
    }
}