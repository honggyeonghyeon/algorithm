package BOJ.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 11926KB 72ms
[문제 해석]
9명의 난쟁이 중 진짜 일곱 난쟁이를 찾는 프로그램
- 일곱 난쟁이의 키의 합: 100

[입력]
9개의 줄에 걸쳐 난쟁이들의 키가 주어짐
0<h<100

[출력]
일곱 난쟁이의 키 오름차순 출력

[문제 해결 프로세스]
9명 중 7명을 선택하는 조합
난쟁이들의 키의 합이 100을 넘으면 백트래킹

[시간 복잡도]
9C7
 */
public class B2309_B1_일곱난쟁이 {
    static int[] height, res;

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        height = new int[9];
        res = new int[7];

        for(int i=0; i<9; i++){
            height[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(height);

        comb(0, 0, 0);
    }

    private static void comb(int cnt, int idx, int sum){
        if(sum > 100) return;

        if(cnt == 7){
            if(sum != 100) return;
            for(int i=0; i<7; i++)  System.out.println(height[res[i]]);
            System.exit(0);
        }

        for(int i=idx; i<9; i++){
            res[cnt] = i;
            comb(cnt+1, idx+1, sum+height[i]);
        }
    }
}
