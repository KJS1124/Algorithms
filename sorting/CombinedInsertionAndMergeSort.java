package sorting;

import java.util.Arrays;
/**
 * @author KJS1124
 * Time Complexity O(nk + nLog(n/k))
 * Auxiliary Space: O(n)
 */
public class CombinedInsertionAndMergeSort {

	public static int THREESHOLD = 4;

	public int[] hybridSort(int arr[], int start, int end) {
		if (start > end)
			return arr;
		if (end - start <= THREESHOLD) {
			arr = insertionSort(arr, start, end);
		} else {
			int mid = (start + end) / 2;
			hybridSort(arr, start, mid);
			hybridSort(arr, mid + 1, end);
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
			right[i] = arr[i + mid + 1];
		left[n1] = Integer.MAX_VALUE;
		right[n2] = Integer.MAX_VALUE;
		int i = 0;
		int j = 0;
		for (int k = start; k <= end; k++)
			if (left[i] <= right[j])
				arr[k] = left[i++];
			else
				arr[k] = right[j++];
		return arr;
	}

	public int[] insertionSort(int arr[], int start, int end) {
		for (int i = start + 1; i <= end; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= start && key < arr[j]) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
		return arr;
	}

	public static void main(String agrs[]) {
		int arr[] = { 33, 656, 21, 4, 5, 643, 2, 1, 34, 6, 67, 87, 2345, 45, 3434 };
		CombinedInsertionAndMergeSort hybridSort = new CombinedInsertionAndMergeSort();
		Arrays.stream(hybridSort.hybridSort(arr, 0, arr.length - 1)).forEach(n -> System.out.print(n + " "));
	}
}
