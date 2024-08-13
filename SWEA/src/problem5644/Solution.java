package problem5644;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int[] dx = {0,0,1,0,-1};
		int[] dy = {0,-1,0,1,0};
		for (int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int count=0;
			int[] move_a = new int[M+1];
			int[] move_b = new int[M+1];
			int[][] BC = new int[A][3];
			PriorityQueue<Integer>[][] arr = new PriorityQueue[10][10];
			for (int i=0;i<10;i++) {
				for (int j=0;j<10;j++) {
					arr[i][j] = new PriorityQueue<>(Collections.reverseOrder());
					arr[i][j].add(0);
				}
			}
			st = new StringTokenizer(br.readLine());
			for (int i=1;i<M+1;i++) {
				move_a[i]=Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i=1;i<M+1;i++) {
				move_b[i]=Integer.parseInt(st.nextToken());
			}
			for (int i=0;i<A;i++) {
				st = new StringTokenizer(br.readLine());
				BC[i][0] = Integer.parseInt(st.nextToken());
				BC[i][1] = Integer.parseInt(st.nextToken());
				BC[i][2] = Integer.parseInt(st.nextToken());
				BC[i][3] = Integer.parseInt(st.nextToken());
			}
			for (int i=0;i<10;i++) {
				for(int j=0;j<10;j++) {
					for(int k=0;k<A;k++) {
						if(Math.abs(BC[k][0]-j)+Math.abs(BC[k][1]-i)<=BC[k][2]) {
							arr[i][j].add(BC[k][3]);
						}
					}
				} // 각각의 좌표에 최대힙으로 용량 넣어놓음 
			}
			
		}
	}
}
