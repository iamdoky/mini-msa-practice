package iam.doky.user.payload.request;

import iam.doky.user.domain.enums.RoleType;

public record CustomUserInfo(
        Long memberId, String email, String name, String password, RoleType role) {
}