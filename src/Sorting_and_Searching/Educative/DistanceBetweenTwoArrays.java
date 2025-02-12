package Sorting_and_Searching.Educative;

import java.util.Arrays;

public class DistanceBetweenTwoArrays {

    public static void main(String[] args) {
        int[] nums1 = {3,6,9};
        int[] nums2 = {0,2,8,10};
        int distance = 1;

        System.out.println("The distance value between two arrays is: "+findDistanceValueOptimized(nums1, nums2, distance));
    }

    public static int findDistanceValueOptimized(int[] nums1, int[] nums2, int distance){

        int actualDistance = 0;
        int low = 0, high = nums2.length, mid = 0;
        boolean valid = true;

        for(int i = 0 ; i < nums1.length; i++) {
            valid = true;
            low = 0;
            high = nums2.length - 1;

            while (low <= high) {
                mid = low + (high - low) / 2;

                if (nums2[mid] == nums1[i]) {
                    valid = true;
                    break;
                }else if (nums2[mid] < nums1[i]) {
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }

            if(low < nums2.length && Math.abs(nums2[low] - nums1[i]) <= distance){
                valid = false;
            }

            if(high >= 0 && Math.abs(nums2[high] - nums1[i]) <= distance){
                valid = false;
            }
            if(valid){
                actualDistance++;
            }
        }
        return actualDistance;

    }
    public static int findDistanceValue(int[] nums1, int[] nums2, int distance){

        int actualDistance = 0, totalDistanceCount = 0;
        Arrays.sort(nums2); //O(nlogn)

        for(int i = 0; i < nums1.length; i++){
            for(int j = 0 ; j < nums2.length; j++){
                if(Math.abs(nums1[i] - nums2[j]) <= distance){
                    actualDistance++;
                }
            }
            if(actualDistance == 0){
                totalDistanceCount++;
            }
            actualDistance = 0;
        } //O(n*n)

        return totalDistanceCount; //O(n log n + n * n) = O(n * n)
    }
}
