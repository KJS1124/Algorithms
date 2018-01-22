package sorting;

import java.util.Arrays;

/**
 * @author KJS1124
 * Time Complexity O(nLogn)
 */
public class HeapSort {

	public int leftIndex(int node) {
		return node * 2 + 1;
	}

	public int rightIndex(int node) {
		return node * 2 + 2;
	}

	public int[] maxHeap(int arr[], int heapSize, int node) {
		int largest = node;
		int left = leftIndex(node);
		int right = rightIndex(node);
		if (left <= heapSize && arr[left] >= arr[node])
			largest = left;
		if (right <= heapSize && arr[right] > arr[largest])
			largest = right;
		if (largest != node) {
			int temp = arr[largest];
			arr[largest] = arr[node];
			arr[node] = temp;
			maxHeap(arr, heapSize, largest);
		}
		return arr;
	}

	public int[] minHeap(int arr[], int heapSize, int node) {
		int largest = node;
		int left = leftIndex(node);
		int right = rightIndex(node);
		if (left <= heapSize && arr[left] <= arr[node])
			largest = left;
		if (right <= heapSize && arr[right] < arr[largest])
			largest = right;
		if (largest != node) {
			int temp = arr[largest];
			arr[largest] = arr[node];
			arr[node] = temp;
			maxHeap(arr, heapSize, largest);
		}
		return arr;
	}

	public int[] buildMaxHeap(int arr[]) {
		int heapLength = arr.length - 1;
		for (int i = heapLength / 2; i >= 0; i--)
			maxHeap(arr, heapLength, i);
		return arr;
	}

	public int[] buildMinHeap(int arr[]) {
		int heapLength = arr.length - 1;
		for (int i = heapLength / 2; i >= 0; i--)
			minHeap(arr, heapLength, i);
		return arr;
	}

	public int[] sortIncreasingOrder(int arr[]) {
		int heapSize = arr.length - 1;
		arr = buildMaxHeap(arr);
		Arrays.stream(arr).forEach(n -> System.out.print(n + " "));
		System.out.println();
		for (int i = arr.length - 1; i > 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapSize--;
			maxHeap(arr, heapSize, 0);
		}
		return arr;
	}

	public int[] sortDecreasingOrder(int arr[]) {
		int heapSize = arr.length - 1;
		arr = buildMinHeap(arr);
		for (int i = arr.length - 1; i > 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapSize--;
			minHeap(arr, heapSize, 0);
		}
		return arr;
	}

	public static void main(String agrs[]) {
		int arr[] = { 14, 56, 2, 7, 9, 2, 1, 5, 80, 7, 5, 432 };
		int arr2[] = { 14, 56, 2, 7, 9, 2, 1, 5, 80, 7, 5, 432 };
		HeapSort hs = new HeapSort();
		Arrays.stream(hs.sortIncreasingOrder(arr)).forEach(n -> System.out.print(n + " "));
		System.out.println();
		Arrays.stream(hs.sortDecreasingOrder(arr2)).forEach(n -> System.out.print(n + " "));
	}
}
