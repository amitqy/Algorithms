package com.example.twopointers.maxdiff;

import java.util.* ;
import java.util.ArrayList;
public class SolutionMaxDiff {
    public static int maxDiff(ArrayList<Integer> a, int n) {
        // Write your code here.
        List<Integer> maxArr = new ArrayList<>();
        for(Integer e: a){
            maxArr.add(0);
        }
        // 34 8 10 3 2 80 30 33 1
        //                33 33 1
        maxArr.set(n-1,a.get(n-1));
        for(int i = n-2; i >= 0; i--){
            maxArr.set( i , Math.max(a.get(i), maxArr.get(i+1)));
        }

//       i  3 5 5 1
//       j  3 4 5 1
        int i = 0;
        int j = 0;
        int diff = -1;
        while(i < n && j < n){
            if(maxArr.get(i) >= a.get(j)){
                diff = Math.max(diff, i-j);
                i++;
            }
            else{
                j++;
            }
        }
        return diff;
    }

    public static void main(String[] args) {

    }
}