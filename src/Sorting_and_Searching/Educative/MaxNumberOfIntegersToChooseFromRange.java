package Sorting_and_Searching.Educative;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxNumberOfIntegersToChooseFromRange {

    public static void main(String[] args) {
        int[] banned = {
                230,547,351,748,414,374,74,523,380,138,930,937,939,825,182,658,236,744,503,628,589,685,508,678,190,298,591,12,715,1,608,240,556,517,407,701,144,257,773,171,977,495,487,499,758,108,562,65,917,117,129,122,451,334,40,203,420,642,92,8,164,571,116,349,676,418,433,330,784,250,495,577,819,364,707,756,683,909,642,920,292,735,876,892,8,285,948,271,267,55,708,528,902,691,635,241,710,624,325,981,138,499,290,561,287,744,924,644,729,796,415,768,906,755,691,872,48,979,358,395,228,644,514,396,199,538,39,702,543,221,167,434,577,217,471,962,24,172,982,360,72,96,227,519,8,357,196,424,453,624,198,763,268,721,563,215,462,442,53,137,445,85,159,737,624,525,566,864,317,211,959,804,476,129,1,199,17,706,917,124,907,257,566,707,806,452,297,239,704,552,176,82,417,994,871,311,524,651,281,748,178,489,208,701,383,911,760,301,239,159,33,996,698,84,395,148,19,722,226,617,240,949,356,535,509,544,241,676,762,443,232,379,829,139,109,836,333,873,349,402,684,200,410,247,274,779,785,765,132,138,189,700,7,324,928,909,141,180,194,85,237,135,20,658,503,269,921,940,914,338,962,455,46,170,967,243,365,74,621,581,274,740,25,279,168,484,7,948,498,907,233,212,336,930,456,932,948,999,811,246,916,686,167,609,24,596,103,44};
        int n = 221, maxSum = 12328;

        System.out.println("Maximum integers to choose in the range: "+findTotalIntegersToChoose(banned, n, maxSum));
    }

    public static int findTotalIntegersToChoose(int[] banned, int n, int maxSum){

        List<Integer> numsList = new ArrayList<>();
        int sum = 0, left = 0, difference = 0, right = 0;

        for(int i = 1; i <= n; i++){
            if(!binarySearch(banned, i)){
                numsList.add(i);
                sum += i;
            }
        }
        System.out.println("Sum: "+sum);

        if(maxSum < sum){
            Collections.sort(numsList);
            right = numsList.size() - 1;
            while ((sum - numsList.get(right)) > maxSum) {
                sum -= numsList.get(right);
                right--;
            }
            difference = right;
        }else {
            if (sum <= maxSum) {
                return numsList.size();
            } else {
                Collections.sort(numsList);
                while ((sum - numsList.get(left)) >= maxSum) {
                    sum -= numsList.get(left);
                    left++;
                }
                difference = numsList.size() - left;
            }
        }

        return difference;
    }

    public static boolean binarySearch(int[] banned, int num){

        int low = 0, high = banned.length - 1, mid = 0;

        while(low <= high){
            mid = (low + high)/2;
            if(banned[mid] == num){
                return true;
            }else if(banned[mid] < num){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return false;
    }
}
