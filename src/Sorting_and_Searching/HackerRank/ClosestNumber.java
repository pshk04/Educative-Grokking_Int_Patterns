package Sorting_and_Searching.HackerRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://www.hackerrank.com/challenges/closest-numbers/problem
 */
public class ClosestNumber {

    public static void main(String[] args) {
        int[] nums = {-20, -3916237, -357920, -3620601, 7374819, -7330761, 30, 6246457, -6461594, 266854};
        List<Integer> numList = new ArrayList<>();
        for(int num : nums){
            numList.add(num);
        }
        System.out.println("The closest co-ordinates are: "+closestNumbers(numList));
    }

    public static List<Integer> closestNumbers(List<Integer> arr) {
        // Write your code here
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b)->(a[2] - b[2]));
        Collections.sort(arr);
        int first = 0, second = 0, diff = 0;
        List<Integer> numList = new ArrayList<>();
        int[] result = null;

        for(int i = 0 ; i < arr.size() - 1; i++){
            first = arr.get(i);
            second = arr.get(i + 1);
            diff = Math.abs(second - first);
            minHeap.offer(new int[]{first, second, diff});
        }

        diff = minHeap.peek()[2];
        while(!minHeap.isEmpty()){
            result = minHeap.poll();
            if(diff == result[2]){
                numList.add(result[0]);
                numList.add(result[1]);
            }
        }
        Collections.sort(numList);
        return numList;
    }
}
