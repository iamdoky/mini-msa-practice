package iam.doky.user.payload.request;

import iam.doky.user.domain.enums.RoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomUserInfoDto{

    private Long memberId;

    private String email;

    private String name;

    private String password;

    private RoleType role;

}