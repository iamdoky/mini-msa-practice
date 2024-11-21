package iam.doky.user.application;

import iam.doky.user.domain.Member;

public interface MemberService {

    public abstract Long join(Member member);

}
