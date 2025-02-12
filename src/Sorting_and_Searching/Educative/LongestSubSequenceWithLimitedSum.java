package Sorting_and_Searching.Educative;

import java.util.Arrays;

public class LongestSubSequenceWithLimitedSum {

    public static void main(String[] args) {
        int[] nums = {2,4,8,10};
        int[] queries = {6,20,42};

        System.out.println("The total number of subsequence: "+Arrays.toString(findSubsequenceWithLimitedSum(nums, queries)));
    }

    public static int[] findSubsequenceWithLimitedSum(int[] nums, int[] queries){

        Arrays.sort(nums);
        int[] prefixSum = new int[nums.length];
        int[] result = new int[queries.length];
        int currentSum = nums[0], low = 0, high = nums.length - 1, mid = 0;
        prefixSum[0] = nums[0];

        for(int i = 1 ; i < nums.length; i++){
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        System.out.println("PrefixSum: "+Arrays.toString(prefixSum));

        for(int i = 0 ; i < queries.length; i++) {
            low = 0;
            high = nums.length - 1;
            mid = 0;

            while (low <= high) {
                mid = (low + high) / 2;
                if (prefixSum[mid] <= queries[i]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
            result[i] = low;
        }

        return result;

    }
}
