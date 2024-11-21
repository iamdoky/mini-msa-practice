package iam.doky.user.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleType {

    ADMIN(1, "관리자"),
    USER(2, "사용자");

    private final int code;
    private final String name;
}
