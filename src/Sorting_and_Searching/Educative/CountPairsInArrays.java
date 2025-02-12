package Sorting_and_Searching.Educative;

import java.util.Arrays;

public class CountPairsInArrays {

    public static void main(String[] args) {
        int[] nums1 = {1,3,2,4,5};
        int[] nums2 = {3,4,2,1,5};
        System.out.println("Number of pairs matching the condition are: "+findPairsOptimized(nums1, nums2));
    }


    /**
     *  OPTIMIZED VERSION
     */
    public static int findPairsOptimized(int[] nums1, int[] nums2){

        int[] diffs = new int[nums1.length];
        int left = 0, mid = 0, right = 0, count = 0;

        for(int i = 0 ; i < nums1.length; i++){
            diffs[i] = nums1[i] - nums2[i];
        }
        Arrays.sort(diffs);
        System.out.println("Diffs: "+ Arrays.toString(diffs));

        for(int i = 0 ; i < diffs.length; i++){
            if(diffs[i] <= 0){
                left = i + 1;
                right = diffs.length - 1;

                while(left <= right){
                    mid = (left + right) / 2;
                    if((diffs[i] + diffs[mid]) > 0){
                        right = mid - 1;
                    }else{
                        left = mid + 1;
                    }
                }
                count += diffs.length - left;

            }else if(diffs[i] > 0){
                count += diffs.length - i - 1;
            }
        }

        return count;
    }

    /**
     * Brute Force Technique
     * @param nums1
     * @param nums2
     * @return
     */
    public static int findPairs(int[] nums1, int[] nums2){
        int count = 0;

        for(int i = 0 ; i < nums1.length - 1; i++){
            for(int j = i + 1; j < nums2.length; j++){
                if((nums1[i] + nums1[j]) > (nums2[i] + nums2[j])){
                    System.out.println(i+" : "+j+" --- "+(nums1[i] + nums1[j])+" : "+(nums2[i] + nums2[j]));
                    count++;
                }
            }
        }
        return count;
    }
}
