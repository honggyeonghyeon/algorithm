package BOJ.Silver;

import java.io.*;
import java.util.*;

/* 127,604KB 632ms
[문제 해석]
NxN 크기의 표 (x1, y1)부터 (x2, y2)까지 합을 구하는 프로그램

[입력]
1. 크기 N, 합을 구해야하는 횟수 M
    (1<=N<=1024, 1<=M<=100,000)
2. 표에 채워진 수 (1,000이하의 자연수)
3. 네 개의 정수 x1, y1, x2, y2

[출력]
합 출력

[문제 해결 프로세스]
누적합
1. (i, j) -> (1~i, 1~j) 까지의 합 sum[][]
    sum[i][j] = n + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1]
2. (x1, y1) ~ (x2, y2)
    res = sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1-1]

[시간 복잡도]
O(N^2) = 1024^2 = 1,048,576
 */
public class B11660_S1_구간합구하기5 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] sum = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                int n = Integer.parseInt(st.nextToken());
                sum[i][j] = n + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            sb.append(sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1-1])
                    .append('\n');
        }

        System.out.println(sb);
    }
}
