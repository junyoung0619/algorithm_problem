package problem16287;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int w = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		int mid = n/2;
		Set<Integer> set = new HashSet<>();
		
		st= new StringTokenizer(br.readLine());
		for(int i = 0 ;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
	}
}
