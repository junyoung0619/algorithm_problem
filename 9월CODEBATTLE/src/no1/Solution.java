package no1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			try {
				int N = Integer.parseInt(st.nextToken());
				int M = Integer.parseInt(st.nextToken());
				ArrayList<String> lst = new ArrayList<>();
				Set<String> set = new HashSet<>();
				
				for(int i=0;i<N;i++) {
					st = new StringTokenizer(br.readLine());
					String str = st.nextToken();
					set.add(str);
				}
				
				for(int i =0;i<M;i++) {
					st = new StringTokenizer(br.readLine());
					String str = st.nextToken();
					if(set.contains(str)) {
						lst.add(str);
					}
				}
				
				lst.sort(null);
				
				for(String str:lst) {
					sb.append(str).append("\n");
				}
			} catch(Exception e) {
				break;
			}
		}
		System.out.println(sb);
	}
}
