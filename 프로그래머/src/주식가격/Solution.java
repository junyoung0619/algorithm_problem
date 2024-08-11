package 주식가격;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
	static Stack<Integer> stack = new Stack<>();
	static int check=0;
	public static void main(String[] args) {
		int[] ex= {1,2,3,4,3,2,1,2,3,4};
		int[] sol=solution(ex);
		System.out.println(Arrays.toString(sol));
	}
	public static int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        int temp=0,check=-1;
        for (int i=0;i<len;i++) {
        	if(stack.isEmpty()|| prices[stack.peek()]<=prices[i]) {
        		stack.push(i);
        	} else { 
        		check=0;
        		while(!stack.isEmpty()&& prices[stack.peek()]>prices[i] ) {
        			temp=stack.pop();
        			check+=1+answer[temp];
        			answer[temp]=check;
        		}
        		if (!stack.isEmpty()) {
        			temp = stack.peek();
        			answer[temp]=check+answer[temp];
        		}
        		stack.push(i);
        	}
        }
        check=-1;
        while (!stack.isEmpty()) {
        	temp=stack.pop();
        	check+=1+answer[temp];
        	answer[temp]=check;
        }
        return answer;
        
        
    }
}
