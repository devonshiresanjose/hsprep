package Saratoga18;

import java.util.*;

@SuppressWarnings("resource")
public class K {

	public static boolean[] totalV;
	public static boolean[] visited;
	public static int[][] adjMat;
	public static int N, M;
	public static int count;
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		N = s.nextInt(); M = s.nextInt();
		totalV = new boolean[N];
		adjMat = new int[N][N];
		for(int i = 0; i < M; i++) 
			adjMat[s.nextInt()-1][s.nextInt()-1] = 1;
		
		//print adjMat
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(adjMat[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		boolean hasAns = false;
		for(int i = 0; i < N; i++) {
			visited = new boolean[N];
			count = 0;
			if(totalV[i]) continue;
			if(dfs(i)) {
				System.out.println(i+1);
				hasAns = true;
			}
			for(int j = 0; j < N; j++) {
				System.out.print(visited[j]+" ");
				if(visited[j]) totalV[j] = true;
			}
			System.out.println();
			for(int j = 0; j < N; j++) System.out.print(totalV[j]+" ");
			System.out.println();
		}
		if(!hasAns) System.out.println(-1);
		
	}
	
	public static boolean dfs(int room) {
		if(visited[room]) return false;
		visited[room] = true;
		
		count++;
		if(count >= N) return true;
		
		for(int i = 0; i < N; i++)
			if(adjMat[room][i] == 1 && dfs(i)) return true;
		
		System.out.print("room " + room + " :");
		for(int i = 0; i < N; i++) {
			System.out.print(visited[i]);
		}
		System.out.println();
		
		return false;
	}
	
}
