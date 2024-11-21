package iam.doky.bookapi.domain.enums;

import lombok.Getter;

@Getter
public enum MemberStatus {

    ACTIVE("활성 회원"),
    INACTIVE("바활성 회원"),
    WITHDRAW("탈퇴 회원");

    private final String value;

    MemberStatus(String value) {
        this.value = value;
    }
}
