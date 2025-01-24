package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/* 24,084kB 192ms
[문제 해석]
DNA 문자열 : 모든 문자열에 등장하는 문자가 {'A', 'C', 'G', 'T'}
임의의 DNA 문자열 만들고 부분 문자열을 비밀번호로 사용
부분 문자열에서 등장하는 문자의 개수가 특정 개수 이상이어야 사용 가능
만들 수 있는 비밀번호의 종류의 수

[입력]
1. DNS 문자열 길이 S, 부분문자열 길이 P
    (1<=P<=S<=1,000,000)
2. DNS 문자열
3. A C G T 의 최소 개수

[출력]
비밀번호의 종류의 수

[문제 해결 프로세스]
슬라이딩 윈도우
1. 0부터 P-1까지 A C G T 의 개수 확인
    -> 0 이하면 cnt++
2. str[0]의 값 --, str[P]의 값 ++

[시간 복잡도]
O(S)
 */
public class B12891_S2_DNA비밀번호 {

    static Map<Character, Integer> dna = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        char[] str = new char[S];
        str = br.readLine().toCharArray();

        int[] check = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) check[i] = Integer.parseInt(st.nextToken());

        dna.put('A', 0);
        dna.put('C', 1);
        dna.put('G', 2);
        dna.put('T', 3);

        for(int i=0; i<P; i++){
            check[dna.get(str[i])]--;
        }

        int res = 0;
        int start = 0;
        int end = P;

        while(true){
            boolean status = true;
            for(int i=0; i<4; i++){
                if(check[i] > 0) {
                    status = false;
                    break;
                }
            }
            if(status) res++;

            if(end == S) break;
            check[dna.get(str[start++])]++;
            check[dna.get(str[end++])]--;
        }

        System.out.println(res);
    }
}
