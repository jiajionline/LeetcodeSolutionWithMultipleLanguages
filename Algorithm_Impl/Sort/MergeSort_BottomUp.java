import java.util.Arrays;

// References : https://www.techiedelight.com/iterative-merge-sort-algorithm-bottom-up/

public class MergeSort
{
	// Merge two sorted subarrays A[left…mid] and A[mid+1…right]
	public static void merge(int[] A, int[] temp, int left, int mid, int right)
	{
		int k = left, i = left, j = mid + 1;

		// loop till no elements are left in the left and right runs
		while (i <= mid && j <= right)
		{
			if (A[i] < A[j]) {
				temp[k++] = A[i++];
			}
			else {
				temp[k++] = A[j++];
			}
		}

		//Only copy remaining elements, don't have to copy the second half because the remaining are already in ascending order in the temp array
		while (i <= mid) {
			temp[k++] = A[i++];
		}

		// Copy back to the original array
		for (i = left; i <= right; i++) {
			A[i] = temp[i];
		}
	}

	// Sort subarray A[left, right] by using a temporary array iteratively
	public static void mergesort(int[] A)
	{
		int left = 0;
		int right = A.length - 1;

		int[] temp = Arrays.copyOf(A, A.length);

		// Divide the array into blocks of size m
		// m = [1, 2, 4, 8, 16…]
		for (int m = 1; m <= right - left; m = 2*m)
		{
			// for m = 1, i = 0, 2, 4, 6, 8 …
			// for m = 2, i = 0, 4, 8, 12 …
			// for m = 4, i = 0, 8, 16 …
			// …
			for (int i = left; i < right; i += 2*m)
			{
				int left = i;
				int mid = i + m - 1;
				int right = Integer.min(i + 2*m - 1, right);

				merge(A, temp, left, mid, right);
			}
		}
	}

	// Iterative implementation of merge sort
	public static void main(String[] args)
	{
		int[] A = { 5, 7, -9, 3, -4, 2, 8 };

		System.out.println("Original array: " + Arrays.toString(A));
		mergesort(A);
		System.out.println("Modified array: " + Arrays.toString(A));
	}
}