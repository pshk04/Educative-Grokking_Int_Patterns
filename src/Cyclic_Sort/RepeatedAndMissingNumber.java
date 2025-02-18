package Cyclic_Sort;

import java.util.Arrays;

public class RepeatedAndMissingNumber {

    public static void main(String[] args) {
        int[] nums = {3,1,2,5,4,7,8,9,10,10};
        System.out.println("The repeated and missing numbers are: "+ Arrays.toString(findRepeatedAndMissingNumberOptimized(nums)));
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
    public static int[] findRepeatedAndMissingNumberOptimized(int[] result){
        int[] missingElements = new int[2];
        int index = 0;

        while(index < result.length){
            if(index != result[index] - 1){
                if(result[index] == result[result[index] - 1]){
                    missingElements[0] = result[index];
                    missingElements[1] = index + 1;
                    return missingElements;
                }
                result = swap(result, index, result[index] - 1);
            }else{
                index++;
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
