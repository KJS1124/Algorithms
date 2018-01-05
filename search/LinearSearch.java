package search;
/**
 * @author KJS1124
 * Time Complexity O(n)
 */
public class LinearSearch {

	public int linearSearch(int arr[], int x) {
		for (int i = 0; i < arr.length; i++)
			if (x == arr[i])
				return i;
		return -1;
	}

	public static void main(String agrs[]) {
		int arr[] = { 3, 6, 33, 1, 57, 4, 2, 1, 4, 6, 8, 86 };
		LinearSearch ls = new LinearSearch();
		System.out.println(ls.linearSearch(arr, 33));
		System.out.println(ls.linearSearch(arr, 100));
	}
}
