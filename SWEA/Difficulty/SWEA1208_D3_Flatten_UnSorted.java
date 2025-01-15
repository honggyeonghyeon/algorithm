package SWEA.Difficulty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 19,192kb 105ms
[문제 해석]
한 쪽 벽면에 노란색 상자들 쌓임
평탄화
- 높은 곳의 상자를 낮은 곳에 옮기는 방식으로 최고점과 최저점의 간격을 줄이는 작업
평탄화를 모두 수행하고 나면 가장 높은 곳과 가장 낮은 곳의 차이가 최대 1 이내
작업 횟수가 정해져 있을 때, 작업 수행 후 최고점과 최저점의 차이 반환

[제약  사항]
가로 길이 100
모든 위치에서 상자의 높이는 1이상 100이하
덤프 횟수 1이상 1000이하
주어진 덤프 횟수 이내에 평탄화가 완료되면 더이상 덤프 수행 불가
-> 그때의 최고점과 최저점의 높이 차 반환(0 또는 1)

[입력]
10개의 테스트 케이스
1. 덤프 쇳수
2. 각 상자의 높이값

[출력]
#t 최고점과 최저점의 높이 차

[문제 해결 프로세스]
매 평탄화 작업마다 max, min의 idx를 구해서 max의 경우 --, min의 경우 ++

[시간 복잡도]
O(N)
 */
public class SWEA1208_D3_Flatten_UnSorted {
    static int max, min, maxIdx, minIdx;
    static int[] arr;
    static final int HEIGHT = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int t=1; t<=10; t++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            arr = new int[100];

            for(int i=0; i<100; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            for(int i=0; i<N; i++){
                findMaxAndMin();
                if(max-min <= 1) break;
                arr[maxIdx]--;
                arr[minIdx]++;
            }

            findMaxAndMin();
            sb.append("#"+t+" "+(max-min)+"\n");
        }
        System.out.println(sb);
    }

    private static void findMaxAndMin() {
        max = 0;
        min = Integer.MAX_VALUE;

        for(int i=0; i<HEIGHT; i++){
            if(arr[i] > max) {
                max = arr[i];
                maxIdx = i;
            }
            if(arr[i] < min) {
                min = arr[i];
                minIdx = i;
            }
        }
    }
}
