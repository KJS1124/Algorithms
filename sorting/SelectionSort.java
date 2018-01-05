package sorting;

import java.util.Arrays;

public class SelectionSort {

	public int[] selectionSortInIncreasing(int arr[])
	{
		for(int i=0;i<arr.length;i++)
		{
			int index =i;
			for(int j =i ; j<arr.length;j++)
			{
				if(arr[index] > arr[j]) {
				index = j;
				}
			}
			int temp = arr[i];
			arr[i]=arr[index];
			arr[index]=temp;
		}
		return arr;
	}
	
	
	public int[] selectionSortInDecreasing(int arr[])
	{
		for(int i=0;i<arr.length;i++)
		{
			
			int index =i;
			for(int j =i ; j<arr.length;j++)
			{
				if(arr[index] < arr[j]) {
				index = j;
				}
			}
			int temp = arr[i];
			arr[i]=arr[index];
			arr[index]=temp;
		}
		return arr;
	}
	
	public static void main(String agrs[])
	{
		int arr[]= {14,56,2,7,9,2,1,5,80,7,5,432};
		int arr2[]= {14,56,2,7,9,2,1,5,80,7,5,432};
		SelectionSort ss =new SelectionSort();
		Arrays.stream(ss.selectionSortInIncreasing(arr)).forEach(n-> System.out.print(n+" "));
		System.out.println();
		Arrays.stream(ss.selectionSortInDecreasing(arr2)).forEach(n-> System.out.print(n+" "));
	}
}
