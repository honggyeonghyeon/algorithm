package SWEA.Difficulty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 31,580kb 150ms
[문제 해석]
사다리 타기
어느 사다리를 고르면 X 표시에 도착하는지
ex) 출발점 x=0 및 x=9인 세로 방향의 두 막대 사이의 임의 개수 막대 랜덤 간격 추가
이 막대들 사이에 가로 방향의 선 또한 랜덤하게 연결
x=0인 출발점에서 출발 -> 아래 방향으로 진행, 좌우 방향으로 이동 가능한 통로가 나타나면 방향 전환
방향 전환 이후 다시 아래 방향으로 이동

0: 평면, 1: 사다리 2: 도착 지점

[입력]
1. TC 번호
2. TC (총 10개)

[출력]
#tc 도착하게 되는 출발점 x 좌표

[문제 해결 프로세스]
1. arr[x][y] == 2인 좌표부터 탐색
2. 좌표 (x, y)에 대하여 좌, 우 방향으로 탐색
    2.1 arr[x`][y] == 1 이면 이동
        2.1.1 좌 또는 우 방향을 기억하고 arr[x`][y] == 0 일때까지 이동
    2.2 arr[x`][y] == 0 이면 y--
3. y = 0일 때의 답

[시간 복잡도]
1. arr[][] : 100*100
2. 사다리 : 100*100
 */
public class SWEA1210_D4_Ladder1_improve {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int T=1; T<=10; T++){
            int t = Integer.parseInt(br.readLine());
            int[][] arr = new int[100][100];
            int x = 0;

            for(int i=0; i<100; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<100; j++){
                    arr[j][i] = Integer.parseInt(st.nextToken());
                    if(arr[j][99] == 2) x = j;
                }
            }

            for(int y = 99; y>=0; y--){
                if(x-1>=0 && arr[x-1][y] == 1) {
                    while(x-1>=0 && arr[x-1][y] == 1) x--;
                }else if(x+1<100 && arr[x+1][y] == 1){
                    while(x+1<100 && arr[x+1][y] == 1) x++;
                }
            }

            sb.append("#"+t+" "+x+"\n");
        }

        System.out.println(sb);
    }
}
