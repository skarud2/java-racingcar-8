package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {

    public static int generate() {
        int randomNum;
        randomNum = Randoms.pickNumberInRange(0, 9);
        return randomNum;
    }

    public static boolean canMove() {
        return generate() >= 4;
    }
}
