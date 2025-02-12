package Sorting_and_Searching.Educative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TargetIndicesAfterSorting {

    public static void main(String[] args) {
        int[] nums = {1,2,4,5,2};
        int target = 2;

        System.out.println("The target indices after sorting: "+findTargetIndicesAfterSorting(nums, target));
    }

    public static List<Integer> findTargetIndicesAfterSorting(int[] nums, int target){

        List<Integer> numsList = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] == target){
                numsList.add(i);
            }
        }
        return numsList;
    }
}
