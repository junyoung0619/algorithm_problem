package 기능개발;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		int[] s= {95,95,95,95};
		int[] t= {4,3,2,1};
		System.out.println(Arrays.toString(solution(s,t)));
	}
	public static int[] solution(int[] progresses, int[] speeds) {
        int len = progresses.length;
        int[] arr = new int[len];
        List<Integer> ans = new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        for (int i=0;i<len;i++) {
        	arr[i] = (99-progresses[i])/speeds[i]+1;
        }
        System.out.println(Arrays.toString(arr));
        for (int i=0;i<len;i++) {
        	if (lst.isEmpty()) {
        		lst.add(arr[i]);
        	} else if(lst.get(0)>=arr[i]){
        		lst.add(arr[i]);
        	} else {
        		ans.add(lst.size());
        		lst.clear();
        		lst.add(arr[i]);
        	}
        }
        if (!lst.isEmpty())
        	ans.add(lst.size());
        len=ans.size();
        int[] answer = new int[len];
        for (int i=0;i<len;i++) {
        	answer[i]=ans.get(i);
        }
        return answer;
    }
}
