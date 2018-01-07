package sorting;

import java.util.Arrays;
/**
 * @author KJS1124
 * Time Complexity O(nLogn)
 * Auxiliary Space: O(n)
 */
public class MergeSortInDecreasing {

	public int[] mergeSort(int arr[], int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid + 1, end);
			merge(arr, start, mid, end);
		}
		return arr;
	}

	public int[] merge(int arr[], int start, int mid, int end) {
		int n1 = mid - start + 1;
		int n2 = end - mid;
		int left[] = new int[n1 + 1];
		int right[] = new int[n2 + 1];
		for (int i = 0; i < n1; i++)
			left[i] = arr[start + i];
		for (int i = 0; i < n2; i++)
			right[i] = arr[mid + i + 1];
		left[n1] = Integer.MIN_VALUE;
		right[n2] = Integer.MIN_VALUE;
		int i = 0;
		int j = 0;
		for (int k = start; k <= end; k++)
			if (left[i] >= right[j])
				arr[k] = left[i++];
			else
				arr[k] = right[j++];
		return arr;
	}

	public static void main(String agrs[]) {
		int arr[] = { 33, 656, 21, 4, 5, 643, 2, 1, 34, 6, 67, 87, 2345, 45, 3434 };
		MergeSortInDecreasing ms = new MergeSortInDecreasing();
		Arrays.stream(ms.mergeSort(arr, 0, arr.length - 1)).forEach(n -> System.out.print(n + " "));
	}
}
