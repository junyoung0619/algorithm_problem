package 예상대진표;

public class Solution {
	public static void main(String[] args) {
		System.out.println(solution(9,4,9));
	}
	public static int solution(int n, int a, int b)
    {
        int answer = 0;
        a = a-1;
        b = b-1;
        int i = 21;
        while(true) {
        	if((a&(1<<i))==(b&(1<<i))) {
        		i=i-1;
        	} else {
        		answer = i+1;
        		break;
        	}
        }

        return answer;
    }
}
