import java.util.*;

class Solution {

  public static int findKthSmallest(int[][] matrix, int k) {
    PriorityQueue<Node> minHeap = new PriorityQueue<Node>((n1, n2) -> matrix[n1.row][n1.col] - matrix[n2.row][n2.col]);

    // put the 1st element of each row in the min heap, the first element must the smallest one in the matrix
    // we don't need to push more than 'k' elements in the heap since we are looking for the Kth. If the length of row > k, and the 
    // k+1 and above will be useless.
    for (int i = 0; i < matrix.length && i < k; i++)
		minHeap.add(new Node(i, 0));

    // take the smallest (top) element form the min heap, if the running count is equal to k return the number
    // if the row of the top element has more elements, add the next element to the heap
    int numberCount = 0, result = 0;
    while (!minHeap.isEmpty()) {
      Node node = minHeap.poll();
      result = matrix[node.row][node.col];
      if (++numberCount == k)
        break;
      node.col++;
      if (matrix[0].length > node.col)
        minHeap.add(node);
    }
    return result;
  }
}

class Node {
    int row;
    int col;
  
    Node(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }