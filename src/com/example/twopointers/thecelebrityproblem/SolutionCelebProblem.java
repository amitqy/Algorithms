package com.example.twopointers.thecelebrityproblem;
import java.util.* ;

/*
	This is signature of helper function 'knows'.
	You should not implement it, or speculate about its implementation.

	boolean knows(int A, int B);
	Function 'knows(A, B)' will returns "true" if the person having
	id 'A' know the person having id 'B' in the party, "false" otherwise.
	Use it as Runner.knows(A, B);
*/

public class SolutionCelebProblem {
    public int findCelebrity(int n) {
        // Write your code here
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < n; i++){
            s.push(i);
        }
        // uses elimination technique
        while(s.size() >= 2){
            int a = s.pop();
            int b = s.pop();

            if(knows(a,b)){
                s.push(b);
            }
            else{
                s.push(a);
            }
        }
        int ele = s.peek();

        for(int i = 0; i < n; i++){
            // the potential celeb should not know anyone
            // there shouldn't be anyone who does no the potential celeb except
            // himself
            if(knows(ele,i) || (knows(i,ele) && i != ele)){
                return -1;
            }
        }
        return ele;
    }

    // stub method
    public boolean knows(int a, int b){
        return false;
    }
}