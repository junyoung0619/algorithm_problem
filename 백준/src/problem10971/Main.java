package problem10971;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static int min_sum=(int) Math.pow(10, 7)+1;
	static int N=0;
	static int[][] arr=new int[11][11];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set<Integer> set = new HashSet<>();
		N = sc.nextInt();
		for (int i=2;i<=N;i++)
			set.add(i);
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		btk(0,1,set);
		System.out.println(min_sum);
	}
	public static void btk(int sum,int start,Set<Integer> s) {
		if(s.isEmpty()) {
			if (arr[start][1]!=0 && sum+arr[start][1]<min_sum)
				min_sum=sum+arr[start][1];
			return;
		}
		for (int i=1;i<=N;i++) {
			if (arr[start][i]!=0 && s.contains(i)) {
				s.remove(i);
				btk(sum+arr[start][i],i,s);
				s.add(i);
			}
		}
	}
}
