package search;
/**
 * @author KJS1124
 * Algorithm name: Kadane’s Algorithm
 * Time Complexity O(n)
 * Problem link http://www.spoj.com/problems/MAXSUMSU/
 */
public class MaximumSumSubArray {

	public int maximumSubArraySum(int arr[])
	{
		int maximumSumSoFar=0;
		int maximumSumTillNow=0;
		for(int i=0 ; i < arr.length;i++)
		{
			maximumSumTillNow+=arr[i];
			if(maximumSumTillNow<0)
				maximumSumTillNow=0;
			maximumSumSoFar = Math.max(maximumSumSoFar, maximumSumTillNow);
		}
		return maximumSumSoFar;
	}
	
	public static void main(String agrs[])
	{
		int arr[] = {2, 3, 4, 5, 7};
		MaximumSumSubArray maximumSumSubArray = new MaximumSumSubArray();
		System.out.println(maximumSumSubArray.maximumSubArraySum(arr));
	}
}
