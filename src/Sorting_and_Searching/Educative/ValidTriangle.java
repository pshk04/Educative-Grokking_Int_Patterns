package Sorting_and_Searching.Educative;

import java.util.Arrays;

public class ValidTriangle {

    public static void main(String[] args) {
        int[][] sidesList = {
                {3,5,7,9,12},
                {4,6,7,10},
                {1,2,3},
                {500,600,700,800,900},
                {10,10,10,10,10,10,10,10,10,10}
        };
        for(int[] sides : sidesList) {
            System.out.println("The number of valid triangles that can be formed are: " + findTotalValidTrianglesOptimized(sides));
        }
    }

    /**
     * OPTIMIZED
     * Time Complexity: O(nlog n + (n * n)) = O(n * n)
     * @param sides
     * @return
     */
    public static int findTotalValidTrianglesOptimized(int[] sides){
        int largest = sides.length - 1, left = 0, right = 0, count = 0, sum = 0;
        Arrays.sort(sides);

        for(int i = largest; i > 1; i--) {
            left = 0;
            right = i - 1;
            while (left < right) {
                sum = (sides[left] + sides[right]);
                if (sum > sides[i]) {
                    count += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return count;
    }

    /**
     * Brute Force Technique
     * Time Complexity: O(nlog n + (n * n)) = O(n * n)
     * @param sides
     * @return
     */
    public static int findTotalValidTriangles(int[] sides){

        Arrays.sort(sides);
        int first = 0, last = 0, count = 0;

        for(int i = 0 ; i < sides.length; i++){
            first = i + 1;
            last = sides.length - 1;

            while(first < last) {
                if ((sides[i] + sides[first]) <= sides[last]) {
                    last--;
                } else {
                    if((sides[i] + sides[first]) > sides[last]){
                        count++;
                        last--;
                        while((first < last) && (sides[i] + sides[first]) > sides[last]){
                            count++;
                            last--;
                        }
                    }else {
                        count++;
                    }
                    first++;
                    last = sides.length - 1;
                }
            }
        }
        return count;
    }
}
