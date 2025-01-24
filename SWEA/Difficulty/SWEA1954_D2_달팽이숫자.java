package SWEA.Difficulty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 24,320KB 72ms
[문제 해석]
1부터 N*N 숫자가 시계 방향
정수 N을 입력 받아 N 크기의 달팽이 출력

[제약 사항]
N은 1이상 10 이하의 정수

[입력]
1. T
2. N

[출력]
#t
달팽이 숫자

[문제 해결 프로세스]
달팽이 배열 arr[x][y]
1. 우-하-좌-상 방향으로 이동하며 값 1씩 증가
    idx = (idx+1)%4
    dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0}
2. arr[x][y] != 0 또는 x와 y의 범위가 (0, N-1)을 넘어서면 방향 전환

[시간 복잡도]
O(N^2)
 */
public class SWEA1954_D2_달팽이숫자 {
    static int N;
    static int[][] arr;
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            int idx = 0;
            int x = 0, y = 0;

            for(int i=1; i<=N*N; i++){
                arr[x][y] = i;
                if(!check(x+dx[idx], y+dy[idx])) idx = (idx+1)%4;

                x += dx[idx];
                y += dy[idx];
            }

            sb.append('#').append(t).append('\n');
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    sb.append(arr[i][j]).append(' ');
                }
                sb.append('\n');
            }
        }

        System.out.println(sb);
    }

    private static boolean check(int x, int y){
        return x>=0 && x<N && y>=0 && y<N
                && arr[x][y] == 0;
    }
}
