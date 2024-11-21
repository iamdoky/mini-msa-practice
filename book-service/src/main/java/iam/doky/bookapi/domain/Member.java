package iam.doky.bookapi.domain;

import iam.doky.bookapi.domain.enums.Gender;
import iam.doky.bookapi.domain.enums.JoinType;
import iam.doky.bookapi.domain.enums.MemberStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "member")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = false)
@ToString
public class Member extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "birth")
    private String birth;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "phone")
    private String phone;

    @Column(name = "path")
    @Enumerated(EnumType.STRING)
    private JoinType path;

    @Column(name = "email")
    private String email;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    @Builder
    private Member(
            String name,
            String birth,
            Gender gender,
            String phone,
            JoinType path,
            String email,
            MemberStatus status) {

        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.phone = phone;
        this.path = path;
        this.email = email;
        this.status = status;
    }

    public static Member of(
            String name,
            String birth,
            Gender gender,
            String phone,
            JoinType path,
            String email,
            MemberStatus status) {

        return new Member(name, birth, gender, phone, path, email, status);
    }
}
