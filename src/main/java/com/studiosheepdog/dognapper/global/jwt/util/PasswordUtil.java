package com.studiosheepdog.dognapper.global.jwt.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.concurrent.ThreadLocalRandom;

@NoArgsConstructor(access = AccessLevel.PRIVATE) // 유틸리티 클래스는 보통 정적(static) 멤버로만 구성, 인스턴스화 X, 일반적으로 생성자가 없는 것이 좋음
public class PasswordUtil {
    public static String generateRandomPassword() {

        char[] charSet = new char[] {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
                // 배열 안의 문자 및 숫자를 원하는대로 설정
        };

        // StringBuffer가 동기화(synchronized)되는 스레드 안전한 클래스
        // 대부분의 상황에서 스레드 간 공유하지 않는 문자열 조합 작업에는 동기화가 필요하지 않으므로 성능상의 이점을 위해 StringBuilder를 사용
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            int randomIndex = ThreadLocalRandom.current().nextInt(charSet.length);
            password.append(charSet[randomIndex]);
        }

        return password.toString();
    }
}

