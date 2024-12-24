package baseball.core;

public class Referee {

    /**
     * 스트라이크와 볼을 판단한다.
     * @param answer 정답
     * @param inputNumberArr 사용자 입력 값
     * @return 스트라이크와 볼의 개수
     */
    public int[] judge(int[] answer, int[] inputNumberArr) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            if (answer[i] == inputNumberArr[i]) { // 스트라이크 판단
                strike++;
                continue;
            }

            for (int j = 0; j < 3; j++) { // 볼 판단
                if (i == j) continue;
                if (answer[i] == inputNumberArr[j]) {
                    ball++;
                    break;
                }
            }
        }

        return new int[] {strike, ball};
    }

}
