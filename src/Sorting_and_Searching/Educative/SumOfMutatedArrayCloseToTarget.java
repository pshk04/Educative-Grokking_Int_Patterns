package Sorting_and_Searching.Educative;

import java.util.Arrays;

public class SumOfMutatedArrayCloseToTarget {

    public static void main(String[] args) {
        int[][] nums =  {
                {3,7,6,2,5},
                {4,9,3},
                {1,1,1},
                {10,20,30}
        };
        int[] target = {17,10,5,25};

        for(int i = 0 ; i < nums.length; i++) {
            System.out.println("The minimum value that is close to target is: " + findMinimumValueCloseToTargetOptimized(nums[i], target[i]));
        }
    }

    /**
     * OPTIMIZED
     * Time Complexity: O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int findMinimumValueCloseToTargetOptimized(int[] nums, int target){
        int minValue = 0;
        Arrays.sort(nums);

        for(int i = 0 ; i < nums.length; i++){
            if(target >= (nums[i] * (nums.length - i))){
                target = target - nums[i];
            }else{
                minValue = target / (nums.length - i) ;
                break;
            }
        }

        return (minValue != 0) ? minValue : nums[nums.length - 1];

    }

    /**
     * Brute Force Technique - DID NOT WORK
     * @param nums
     * @param target
     * @return
     */
    public static int findMinimumValueCloseToTarget(int[] nums, int target){
        int currentSum = 0, minValue = 0, previousMaxSum = 0;
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 1; i++){ //2,3,5,6,7
            if(nums[i] < nums[i + 1]){
                currentSum = (nums.length - (i + 1)) * nums[i] + findCurrentSum(nums, i);
                if(currentSum <= target){
                    if(currentSum > previousMaxSum) {
                        previousMaxSum = currentSum;
                        minValue = nums[i];
                    }
                }else{
                    break;

                }
            }
        }
        return minValue;

    }

    public static int findCurrentSum(int[] nums, int index){
        int sum = 0;
        for(int i = 0; i <= index; i++){
            sum += nums[i];
        }

        return sum;
    }
}
