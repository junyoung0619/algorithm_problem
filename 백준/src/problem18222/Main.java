package problem18222;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
//		double k = sc.nextDouble();
		int k=2;
		int a = 0;
		while(k>1) {
			int count=0;
			double tmp = k-1;
			while(tmp>0) {
				count+=1;
				tmp=tmp/2;
			}
			k=(1<<count)+1-k;
			a=1-a;
		}
		System.out.println(a);
		sc.close();
	}
}
