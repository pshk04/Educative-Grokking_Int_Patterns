package Cyclic_Sort;

import java.util.Arrays;

public class FindKthMissingPositiveNumber {

    public static void main(String[] args) {
        int[][] nums ={
                {3,2,1,5,4,8,9,6,11,13},
                {6,7,9,2,3,13,11}
        };
        int[] k = {2,3};

        for(int i = 0; i < nums.length; i++) {
            System.out.println("Missing element is: " + findKthMissingPositiveNumber(nums[i], k[i]));
        }
    }

    public static int findKthMissingPositiveNumber(int[] result, int k){
        int kthMissingNumber = 0, index = 0;

        while(index < result.length){
            if(result[index] < result.length && (index + 1) != (result[index])) {
                result = swap(result, index, result[index] - 1);
            }else{
                index++;
            }
        }

        System.out.println("Nums array: "+Arrays.toString(result));

        for(int i = 0 ; i < result.length; i++){
            if(result[i] != i + 1){
                k--;
            }
            if(k == 0){
                kthMissingNumber = i + 1;
                break;
            }
        }

        return kthMissingNumber;
    }

    public static int[] swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;

        return nums;
    }
}
