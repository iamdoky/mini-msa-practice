package iam.doky.user.repository;

import iam.doky.user.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJPARepository extends JpaRepository<Member, Long> {

    Member findMemberByEmail(String email);
}
