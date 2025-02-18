package Cyclic_Sort;

import java.util.Arrays;

public class CyclicSort {

    public static void main(String[] args) {
        int[] nums = {6,7,9,2,3,13,11};
        System.out.println("Array after sorting: "+ Arrays.toString(cyclicSort(nums)));
    }

    public static int[] cyclicSort(int[] nums){
        for(int i = 0 ; i < nums.length; i++){
            while((i < nums.length) && (i != (nums[i] - 1))){
                nums = swap(nums, i, nums[i] - 1);
                i++;
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
