package Cyclic_Sort;

import java.util.Arrays;

public class RepeatedAndMissingNumber {

    public static void main(String[] args) {
        int[] nums = {3,1,2,5,4,7,8,9,10,10};
        System.out.println("The repeated and missing numbers are: "+ Arrays.toString(findRepeatedAndMissingNumber(nums)));
    }

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
    public static int[] swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;

        return nums;
    }

}
