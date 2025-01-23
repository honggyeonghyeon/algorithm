package BOJ.Silver;

import java.io.*;
import java.util.*;

/* 56,460KB 448ms
[문제 해석]
수 N개가 주어졌을 때, i번 째 수부터 j번째 수까지 합을 구하는 프로그램

[입력]
1. 수의 개수 N 합을 구해야 하는 횟수 M
2. N개의 수 (1,000 이하의 자연수)
3-M. 구간 i와 j

[출력]
M개의 줄에 합 출력

[문제 해결 프로세스]
1. 1부터 i까지 합을 저장하는 배열 sum[N+1]
2. i부터 j까지 합
    sum[j] - sum[i-1]

[시간 복잡도]
O(N+M)
 */
public class B11659_S3_구간합구하기4 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] sum = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            int n = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + n;
        }

        StringBuilder sb = new StringBuilder();
        for(int k=0; k<M; k++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            sb.append(sum[j]-sum[i-1]).append('\n');
        }

        System.out.println(sb);
    }
}
