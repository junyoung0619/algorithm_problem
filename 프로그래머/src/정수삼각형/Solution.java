package 정수삼각형;

import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}}));
	}
	public static int solution(int[][] triangle) {
		int answer = 0;
		int len = triangle.length;
		int[][] dp = new int[len][len];
		dp[0][0] = triangle[0][0];

		for (int i = 1; i < len; i++) {
			dp[i][0] = dp[i - 1][0] + triangle[i][0];
			for (int j = 1; j <= i; j++) {
				dp[i][j] = triangle[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
			}
		}

		for (int i = 0; i < len; i++) {
			if(answer < dp[len-1][i]) {
				answer = dp[len-1][i];
			}
		}
		return answer;
	}
}
