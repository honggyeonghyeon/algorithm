package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 11636KB 68ms
[문제 해석]
1부터 연속적으로 번호가 붙어있는 스위치 N개
스위치는 켜져 있거나 꺼져있는 상태
'1' : 켜진 상태
'0' : 꺼진 상태
M명의 학생을  뽑아 1 이상, N 이하인 자연수 배부
학생들은 성별과 받은 수에 따라 스위치 조작
(1) 남학생 - 스위치 번호가  자기 받은 수의 배수이면 스위치 상태 바꿈
(2) 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭이면
    가장 많은 스위치를 포함하는 구간을 찾아 그 구간의 스위치 상태 바꿈 (홀수)

[입력]
1. 스위치 개수 N (100 이하의 양의 정수)
2. 각 스위치의 상태
3. 학생 수 M (100 이하의 양의 정수
4.~ 학생의 성별(남자: 1, 여자: 2) 학생이 받은 수 (N 이하)

[출력]
1번 스위치에서 시작하여 N번 스위치까지 한 줄에 20개씩 출력

[문제 해결 프로세스]
비트마스킹
- 상태 바꿈 status ^= (1 << n)

[시간 복잡도]
O(N*M)
 */
public class B1244_S4_스위치켜고끄기 {
    static int N;
    static int[] status;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        status = new int[N+1];
        for(int i=1; i<=N; i++){
            int n = Integer.parseInt(st.nextToken());
            status[i] = n;
        }

        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if(sex == 1) male(num);
            else female(num);
        }

        for(int i=1; i<=N; i++){
            System.out.print(status[i] + " ");
            if(i%20 == 0) System.out.println();
        }

    }

    private static void male(int num){
        int n = num;
        while(n <= N){
            status[n] ^= 1;
            n += num;
        }
    }

    private static void female(int n){
        int pre = n-1;
        int next = n+1;
        status[n] ^= 1;

        while(pre >= 1 && next <= N && status[pre] == status[next]){
            status[pre--] ^= 1;
            status[next++] ^= 1;
        }
    }
}