package iam.doky.user.payload.request;

import iam.doky.user.domain.enums.RoleType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Schema(description = "회원 추가 요청 DTO")
public record MemberRequestRecord(

        @Schema(description = "회원 이름", example = "김도키")
        @NotBlank(message = "이름은 필수 입력 값입니다.")
        String name,

        @Schema(description = "성별", example = "MAIL")
        @NotBlank(message = "성별은 필수 입력 값입니다.")
        String gender,

        @Schema(description = "생년월일", example = "19920808")
        @NotBlank(message = "생년월일은 필수 입력 값입니다.")
        String birth,

        @Schema(description = "연락처", example = "01099998888")
        @NotBlank(message = "연락처는 필수 입력 값입니다.")
        String mobile,

        @Schema(description = "회원 이메일", example = "iam@doky.com")
        @NotBlank(message = "이메일은 필수 입력 값입니다.")
        @Email(message = "이메일 형식에 맞지 않습니다.")
        String email,

        @Schema(description = "회원 닉네임", example = "doky")
        @NotBlank(message = "닉네임은 필수 입력 값입니다.")
        String nickname,

        @Schema(description = "비밀번호", example = "Qwer1234@!")
        @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
        @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}",
                message = "비밀번호는 영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 8자 ~ 20자의 비밀번호여야 합니다.")
        String password,

        @Schema(description = "회원 계정 타입", example = "KAKAO")
        @NotBlank(message = "계정 타입은 필수 입력 값입니다.")
        @Pattern(regexp = "^(KAKAO|NAVER)$", message = "카카오 네이버 ... ")
        String authType,

        @Schema(description = "회원 사용 여부", example = "true")
        @NotBlank(message = " true / false.")
        boolean active,

        @Schema(description = "회원 권한", example = "USER")
        RoleType role) {

}

