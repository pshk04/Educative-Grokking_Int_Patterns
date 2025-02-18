package Cyclic_Sort;

import java.util.Arrays;

public class MissingNumber {

    public static void main(String[] args) {
        int[][] nums = {
                {5,6,4,2,1,3,0,7,9},
                {7,6,0,4,3,8,5,1,9},
                {0}
        };
        for(int[] numArray: nums) {
            System.out.println("the missing number is: " + findMissingNumber(numArray));
        }
    }

    /**
     * Optimised: Time Complexity - O(N)
     * @param result
     * @return
     */
    public static int findMissingNumber(int[] result){

        int missingNumber = 0, index = 0;
        if(result.length == 1 && result[0] != 1){
            return 1;
        }

        while(index < result.length){
            if(result[index] < result.length && index != (result[index])) {
                result = swap(result, index, result[index]);
            }else{
                index++;
            }
        }

        for(int i = 0; i < result.length; i++){
            if((i) != result[i]){
                missingNumber = i;
            }
        }
        return missingNumber;
    }

    public static int[] swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;

        return nums;
    }
}
