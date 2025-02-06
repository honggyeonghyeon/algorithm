package SWEA.Difficulty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*24,448 kb 75ms
[문제 해석]
NxN 배열 안에서 MxM 크기의 파리채를 한 번에 내려쳐 최대한 많은 파리 죽이기
죽은 파리의 개수

[제약 사항]
1. 5<=N<=15
2. 2<=M<=N
3. 각 영역의 파리 개수 30개 이하

[입력]
1. T
2. N M
3. NxM

[출력]
#t 정답

[문제 해결 프로세스]
1. for (1, 1) ~ (N-M+1, N-M+1)
1.1 구간합 방식 arr[x1][y1] ~ arr [x2][y2]
    = arr[x2][y2] - arr[x2][y1-1] - arr[x1-1][y2] + arr[x1-1][y2-1]

[시간 복잡도]
O(N^2)
 */
public class SWEA2001_D2_파리퇴치_improve {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            sb.append('#').append(t).append(' ');
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N+1][N+1];
            int res = 0;

            for(int i=1; i<=N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=1; j<=N; j++){
                    int cnt = Integer.parseInt(st.nextToken());
                    arr[i][j] = arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1] + cnt;
                    if(i>=M && j>=M)
                        res = Math.max(res, arr[i][j]-arr[i-M][j]-arr[i][j-M]+arr[i-M][j-M]);
                }
            }

            sb.append(res).append('\n');
        }

        System.out.println(sb);
    }
}
