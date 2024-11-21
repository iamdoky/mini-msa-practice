package iam.doky.bookapi.domain.enums;

import lombok.Getter;

@Getter
public enum JoinType {

    NORMAL("일반"),
    NAVER("네이버"),
    KAKAO("카카오"),
    UNDEFINED("몰라요");

    private final String value;

    JoinType(String value) {
        this.value = value;
    }
}
