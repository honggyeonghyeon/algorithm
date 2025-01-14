package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 47756KB 180ms
 * [문제 해석]
 * 자연수 N과 M, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하기
 * - 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 * 
 * [입력]
 * 1. 자연수 N과 M (1<=M<=N<=8)
 * 
 * [출력]
 * 한 줄에 하나씩 문제의 조건을 만족하는 수열 출력
 * 수열은 사전 순으로 증가하는 순서
 * 
 * [문제 해결 프로세스]
 * 재귀 함수를 이용한 순열 
 * permu(int idx)
 * : idx - 현재 수열의 길이
 * 
 * [시간 복잡도]
 * O(N!) -> O(8!) = 40,320
 */
public class B15649_S3_N과M1 {
	static int N, M;
	static int[] arr;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		visit = new boolean[N+1];
		
		permu(0);
		System.out.println(sb);
	}

	private static void permu(int idx) {
		if(idx == M) {
			for(int num : arr) sb.append(num +" ");
			sb.append('\n');
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			arr[idx] = i;
			permu(idx+1);
			visit[i] = false;
		}
	}
}
