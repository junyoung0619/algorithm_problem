package problem15651;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int[] arr= new int[M];
		btk(0,arr);
	}
	public static void btk(int b,int[] c) {
		if(b==M) {
			for (int num:c) {
				System.out.printf("%d ",num);
			}
			System.out.println();
			return;
		} else {
			for (int i=1;i<=N;i++) {
				c[b]=i;
				btk(b+1,c);
			}
		}
	}
}
