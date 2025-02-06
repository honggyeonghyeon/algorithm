package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 11,484KB 68ms
[문제 해석]
재료 N개
각 재료의 신맛 S, 쓴맛 B
신맛: 사용한 재료의 신맛의 곱
쓴맛: 합
적절히 섞여서 요리의 신맛과 쓴맛의 차이를 작게 만들려고 함
재료는 적어도 하나 이상
신맛과 쓴맛의 차이가 가장 작은 요리 만들기

[입력]
1. N (1<=N<=10)
2. 신맛 쓴맛 (1,000,000,000 이하)

[출력]
신맛과 쓴맛의 차이가 가장 작은 요리의 차이

[문제 해결 프로세스]
1. 부분 집합
1.1 comb(int cnt, long s, long b)
1.2 |s-b| 의 최솟값 갱신
1.3 if cnt == N : return
1.4 for i in cnt:N
    comb(cnt+1, s*s`, b+b`)

[시간 복잡도]
O(N^2)
 */
public class B2961_S2_도영이가_만든_맛있는_음식 {

    static int N;
    static long res = Long.MAX_VALUE;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        subset(0, 1, 0);

        System.out.println(res);
    }

    private static void subset(int cnt, int s, int b){
        if(cnt == N) return;

        for(int i=cnt; i<N; i++){
            int s1 = s * arr[i][0];
            int b1 = b + arr[i][1];
            res = Math.min(res, Math.abs(s1-b1));
            subset(i+1, s1, b1);
        }
    }
}
