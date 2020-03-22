package coding.leetcode.problems.ms;

public class MinMovesConsecutiveLetters {

    public int solution(String S) {
        int N = 0;

        if (S.length() < 3) {
            return N; // less than 3 characters, is worthless to review the string
        }

        if (!S.matches("(a|b)+")) {
            return N; // contains an invalid character
        }

        int start = 0, end = -1;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i - 1) != S.charAt(i)) {
                end = i;
                if ((end - start) > 2) {
                    N += (end - start) / 3;
                }
                start = end;
            }
        }
        end = S.length();
        if ((end - start) > 2) {
            N += (end - start) / 3;
        }
        return N;
    }

    public static int getSolution(String S) {
        MinMovesConsecutiveLetters solution = new MinMovesConsecutiveLetters();
        return solution.solution(S);
    }

}
