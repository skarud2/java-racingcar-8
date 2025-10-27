package racingcar.service;
import java.util.HashSet;
import java.util.Set;

public class RacingService {

    public void validateCarNames(String carNames) {
        String[] names = carNames.split(",");
        Set<String> uniqueNames = new HashSet<>();

        for (String name: names) {
            String trimmed = name.trim().toLowerCase();

            if (trimmed.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
            }
            if (names.length <2) {
                throw new IllegalArgumentException("경주할 자동차 이름을 2개 이상 입력하세요.");
            }
            if (trimmed.length() >5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해주세요.");
            }
            if (uniqueNames.contains(trimmed)) {
                throw new IllegalArgumentException("중복된 이름이 있습니다.");
            }
            uniqueNames.add(trimmed);

        }
    }

    public void validateAttempts(int attempts) {
        if (attempts < 1) {
            throw new IllegalArgumentException("시도 횟수는 1번 이상이어야 합니다.");
        }
    }
}
