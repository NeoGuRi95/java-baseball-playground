package baseball.core;

import java.util.HashSet;
import java.util.Set;

public class RandomGenerator {

    /**
     * min ~ max 사이의 중복되지 않는 size개의 랜덤한 숫자 배열을 생성한다.
     * @param min 최소값
     * @param max 최대값
     * @param size 배열 크기
     * @return 랜덤한 숫자 배열
     */
    public static int[] generateNumbers(int min, int max, int size) {
        int[] numbers = new int[size];
        Set<Integer> numberSet = new HashSet<>();

        for (int i = 0; i < size; i++) {
            boolean isDuplicate = true;

            while (isDuplicate) {
                int number = (int) (Math.random() * (max - min + 1)) + min;

                if (!numberSet.contains(number)) {
                    isDuplicate = false;
                    numbers[i] = number;
                    numberSet.add(number);
                }
            }
        }

        return numbers;
    }
}
