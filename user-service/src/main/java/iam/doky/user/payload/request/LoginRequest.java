package iam.doky.user.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record LoginRequest(

        @NotNull(message = "이메일 입력은 필수입니다.")
        @Email
        String email,

        @NotNull(message = "패스워드 입력은 필수입니다.")
        String password) {

}
