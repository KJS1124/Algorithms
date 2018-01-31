package queue;
/**
 * @author KJS1124
 * Time Complexity 
 * Find_Maximum O(1)
 * Extract_Max O(logn)
 * insert_element O(logn)
 * increase_key O(logn)
 */
public class PriorityQueue {
	int heapSize = 0;

	public int getParent(int node) {
		return node / 2;
	}

	public int getLeft(int node) {
		return 2 * node + 1;
	}

	public int getRight(int node) {
		return 2 * node + 2;
	}

	public int[] maxHeap(int arr[], int node) {
		int left = getLeft(node);
		int right = getRight(node);
		int largest = node;
		if (left <heapSize && arr[node] <= arr[left])
			largest = left;
		if (right <heapSize && arr[largest] < arr[right])
			largest = right;
		if (largest != node) {
			int temp = arr[node];
			arr[node] = arr[largest];
			arr[largest] = temp;
			maxHeap(arr, largest);
		}
		return arr;
	}
	
	public int max(int arr[])
	{
		return arr[0];
	}
	
	public int extractMax(int arr[])
	{
		int max = arr[0];
		arr[0]=arr[heapSize-1];
		heapSize--;
		maxHeap(arr, 0);
		return max;
	}
	
	public boolean increaseValue(int arr[],int node,int value)
	{
		if(arr[node]>=value)
			return false;
		arr[node]=value;
		while(node>0 && arr[node]>=arr[getParent(node)])
		{
			int temp = arr[getParent(node)];
			arr[getParent(node)]=arr[node];
			arr[node] = temp;
			node = getParent(node);
		}
		return true;
	}
	
	public boolean insert(int arr[],int value)
	{
		arr[heapSize]=Integer.MIN_VALUE;
		heapSize++;
		return increaseValue(arr, heapSize-1, value);
	}
	
	public static void main(String agrs[]) {
		int arr[] = new int[100];
		int arr2[] = { 14, 56, 2, 7, 9, 2, 1, 5, 80, 7, 5, 432 };
		PriorityQueue pq = new PriorityQueue();
		for(int value : arr2)
		{
			pq.insert(arr, value);
		}
		
		while(pq.heapSize>0)
		{
			System.out.print(pq.extractMax(arr)+" ");
		}
	}
}
