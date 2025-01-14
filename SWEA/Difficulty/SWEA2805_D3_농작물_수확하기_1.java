package SWEA.Difficulty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*20,628kb 135ms
[문제 해석]
NxN 농장 규칙
1. 농장의 크기는 항상 홀수 (1x1, 3x3,...49x49)
2. 수확은 항상 농장의 크기에 딱맞는 정사각형 마름모 형태로만 가능

[제약 사항]
농장의 크기 N은 1 이상 49 이하 홀수 (1<=N<=49)
농작물의 가치 0~5

[입력]
1. 테스트 케이스의 개수 T
2. 농장의 크기  N
3~. 농장 내 농작물의 가치

[출력]
#t 수익

[문제 해결 프로세스]
가운데(0, N/2)~(N-1, N/2)를 기점으로 좌우 탐색
for i=1 in N/2 (i++)
   for j=i in N-i (j++)

[시간 복잡도]
O(N^2) = O(49^2)
 */
public class SWEA2805_D3_농작물_수확하기_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            for(int i=0;i<N;i++) {
                String str = br.readLine();
                for(int j=0;j<N;j++) {
                    arr[i][j] = str.charAt(j)-'0';
                }
            }
            int mid = N/2;
            int sum = 0;

            for(int i=0;i<N;i++) {
                sum += arr[i][mid];
            }

            for(int i=1;i<=mid;i++){
                for(int j=i;j<N-i;j++){
                    sum += arr[j][mid-i];
                    sum += arr[j][mid+i];
                }
            }

            sb.append("#"+t+" "+sum+"\n");
        }
        System.out.println(sb);
    }
}