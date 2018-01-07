package sorting;

import java.util.Arrays;

/**
 * @author KJS1124 
 * Time Complexity O(n^2) 
 * Auxiliary Space: O(1)
 */
public class ExtendedBubbleSort {

	public int[] bubbleSort(int arr[]) {
		boolean swapped = true;
		for (int i = 1; i < arr.length - 1; i++) {
			swapped = false;
			for (int j = arr.length - 1; j >= i; j--) {
				if (arr[j - 1] > arr[j]) {
					int temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
					swapped = true;
				}
			}
			if (!swapped)
				return arr;
		}
		return arr;
	}

	public static void main(String agrs[]) {
		int arr[] = { 4, 5, 7, 4, 2, 4, 456, 5, 32, 3, 42, 765, 12, 4, 67, 4, 4, 3, 43, 5, 13, 5, 65 };
		int arr2[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		ExtendedBubbleSort bs = new ExtendedBubbleSort();
		Arrays.stream(bs.bubbleSort(arr)).forEach(n -> System.out.print(n + " "));
		System.out.println();
		Arrays.stream(bs.bubbleSort(arr2)).forEach(n -> System.out.print(n + " "));
	}

}
