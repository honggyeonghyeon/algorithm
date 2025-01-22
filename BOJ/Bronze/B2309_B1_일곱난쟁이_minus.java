package BOJ.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 11528KB 64ms
[문제 해석]
9명의 난쟁이 중 진짜 일곱 난쟁이를 찾는 프로그램
- 일곱 난쟁이의 키의 합: 100

[입력]
9개의 줄에 걸쳐 난쟁이들의 키가 주어짐
0<h<100

[출력]
일곱 난쟁이의 키 오름차순 출력

[문제 해결 프로세스]
난쟁이들의 키 총합 sum
9명 중 2명을 제외해서 sum이 100이 되는 난쟁이 index 찾기

[시간 복잡도]
9C2
 */
public class B2309_B1_일곱난쟁이_minus {

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] height = new int[9];
        int sum = 0;

        for(int i=0; i<9; i++){
            height[i] = Integer.parseInt(br.readLine());
            sum += height[i];
        }
        Arrays.sort(height);

        StringBuilder sb = new StringBuilder();

        A: for(int i=0; i<9; i++){
            for(int j=i+1; j<9; j++){
                if(sum - height[i] - height[j] != 100) continue;

                for(int k=0; k<9; k++){
                    if(k==i || k==j) continue;
                    sb.append(height[k]).append('\n');
                }
                System.out.println(sb);

                break A;
            }
        }
    }
}
