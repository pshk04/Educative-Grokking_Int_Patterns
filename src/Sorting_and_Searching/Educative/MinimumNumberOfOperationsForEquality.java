package Sorting_and_Searching.Educative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumNumberOfOperationsForEquality {

    public static void main(String[] args) {
        int[][] nums =
                {
                    {3,8,12,6},
                    {2,3,7,9}
                };
        int[][] queries = {
                {10,4},
                {5,8,4}
        };
        for(int i = 0 ; i < nums.length; i++) {
            System.out.println("Minimum number of operations required to make the array equality: " + totalOperationsRequiredOptimized(nums[i], queries[i]));
        }
    }

    /**
     * OPTIMIZED
     * Time Complexity: O(n log n + n + m log n) = O((m + n) log n)
     * @param nums
     * @param queries
     * @return
     */
    public static List<Long> totalOperationsRequiredOptimized(int[] nums, int[] queries){
        List<Long> answers = new ArrayList<Long>();
        int low = 0, high = 0, mid = 0;
        long leftOps = 0, rightOps = 0;
        Arrays.sort(nums);
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;

        for(int i = 1 ; i <= nums.length; i++){
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        System.out.println("prefixSum: "+Arrays.toString(prefixSum));

        for(int query : queries) {
            low = 0;
            high = nums.length - 1;
            while (low <= high) {
                mid = (low + high) / 2;
                if(nums[mid] < query){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
            leftOps = (long) query * low - prefixSum[low];
            rightOps = (prefixSum[nums.length] - prefixSum[low]) - (long)query * (nums.length - low);

            answers.add(leftOps + rightOps);
        }

        return answers;

    }

    /**
     * Brute Force Technique
     * Time Complexity: O(m * n)
     * @param nums
     * @param queries
     * @return
     */
    public static List<Long> totalOperationsRequired(int[] nums, int[] queries){

        List<Long> answers = new ArrayList<Long>();
        long sum = 0;

        for(int query: queries) {
            for (int i = 0; i < nums.length; i++) {
                sum += Math.abs(nums[i] - query);
            }
            answers.add(sum);
            sum = 0;
        }
        return answers;
    }
}
