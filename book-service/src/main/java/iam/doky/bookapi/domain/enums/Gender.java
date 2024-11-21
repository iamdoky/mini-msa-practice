package iam.doky.bookapi.domain.enums;

import lombok.Getter;

@Getter
public enum Gender {

    MALE("남성"),
    FEMALE("여성"),
    UNDEFINED("몰라요");

    private final String value;

    Gender(String value) {
        this.value = value;
    }
}
