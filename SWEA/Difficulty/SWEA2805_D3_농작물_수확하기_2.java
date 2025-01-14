package SWEA.Difficulty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*21,260kb 119ms
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
- 가운데 열(0, N/2)에서 시작
- 가운데 행 기준 (mid)
	- 작으면 gap++
    - 크면 gap--

for i=0 in N
	for j=mid-gap in mid+gap
   	if i<mid gap++
    else gap--

[시간 복잡도]
O(N^2) = O(49^2)
 */
public class SWEA2805_D3_농작물_수확하기_2 {
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
            int gap = 0;

            for(int i=0;i<N;i++){
                for(int j=mid-gap;j<=mid+gap;j++) sum += arr[i][j];

                if(i<mid) gap++;
                else gap--;
            }

            sb.append("#"+t+" "+sum+"\n");
        }
        System.out.println(sb);
    }
}