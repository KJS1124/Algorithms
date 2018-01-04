package sorting;

import java.util.Arrays;

public class InsertionSort {

	public int[] insertionSortInIncresing(int arr[])
	{
		for(int i=1;i<arr.length;i++)
		{
			int key=arr[i];
			int j =i-1;
			while(j>=0 && key<arr[j])
			{
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=key;
		}
		return arr;
	}
	
	public int[] insertionSortInDecreasing(int arr[])
	{
		for(int i =1;i<arr.length;i++)
		{
			int key = arr[i];
			int j = i-1;
			while(j>=0 && key>arr[j])
			{
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=key;
		}
		return arr;
	}
	
	public static void main(String agrs[]) {
		int arr[]= {5,1,7,9,3,1,4,6,7,9};
		int arr2[]= {5,1,7,9,3,1,4,6,7,9};
		InsertionSort is = new InsertionSort();
		Arrays.stream(is.insertionSortInIncresing(arr)).forEach(n->System.out.print(n+" "));
		System.out.println();
		Arrays.stream(is.insertionSortInDecreasing(arr2)).forEach(n->System.out.print(n+" "));
	}
}
