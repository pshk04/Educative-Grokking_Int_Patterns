package Cyclic_Sort;

import java.util.Arrays;

public class RepeatedAndMissingNumber {

    public static void main(String[] args) {
        int[][] nums = {
                {4,1,2,1,6,3},
                {3,1,2,3,6,4}
        };
        for(int[] numArray : nums) {
            System.out.println("The repeated and missing numbers are: " + Arrays.toString(findRepeatedAndMissingNumberOptimized(numArray)));
        }
    }

    /**
     * Optimised: Time Complexity - O(N * N)
     * @param nums
     * @return
     */
    public static int[] findRepeatedAndMissingNumber(int[] nums){
        int[] result = new int[2];

        for(int i = 0 ; i < nums.length; i++) {
            while ((i < nums.length)) {
                if (i != (nums[i] - 1)) {
                    if(nums[i] == nums[nums[i] - 1]){
                        result[0] = nums[i];
                        result[1] = i + 1;
                        return result;
                    }
                    nums = swap(nums, i, nums[i] - 1);
                }else{
                    i++;
                }
            }
        }
        return nums;
    }

    /**
     * Optimised: Time Complexity - O(N)
     * @param result
     * @return
     */
    public static int[] findRepeatedAndMissingNumberOptimized(int[] result){ // 3,1,2,3,6,4
        int[] missingElements = new int[2];
        int index = 0;

        while(index < result.length){
            if(result[index] <= result.length && (index + 1) != result[index]){
                if(result[index] == result[result[index] - 1]){
                    missingElements[0] = result[index];
                    index++;
                }else {
                    result = swap(result, index, result[index] - 1);
                }
            }else{
                index++;
            }
        }
        System.out.println(Arrays.toString(result));

        for(int i = 0; i < result.length; i++){
            if((i + 1) != result[i]){
                missingElements[1] = (i + 1);
            }
        }
        return missingElements;
    }

    public static int[] swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;

        return nums;
    }

}
