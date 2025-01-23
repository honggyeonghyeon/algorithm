package BOJ.Silver;

import java.io.*;
import java.util.*;

/* 11,512KB 64ms
[문제 해석]
자연수 N과 M, 길이가 M인 수열 구하기
- 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
- 고른 수열은 오르참순

[입력]
1. 자연수 N, M (1<=M<=N<=8)

[출력]
1. 수열 출력 (중복 X, 공백 구분, 사전 순 증가)

[문제 해결 프로세스]
조합

[시간 복잡도]
8C4 = 70
 */
public class B15650_S3_N과M2 {

    static int[] arr;
    static int N, M;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        sb = new StringBuilder();

        comb(0, 1);
        System.out.println(sb);
    }

    private static void comb(int cnt, int idx){
        if(cnt==M){
            for(int n : arr) sb.append(n).append(' ');
            sb.append('\n');
            return;
        }

        for(int i=idx; i<=N; i++){
            arr[cnt] = i;
            comb(cnt+1, i+1);
        }
    }
}
