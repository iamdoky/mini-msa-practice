package iam.doky.user.repository;

import iam.doky.user.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void create(Member member) {
        em.persist(member);
    }

    public Optional<Member> findByEmail(String email) {

        TypedQuery<Member> typedQuery = em.createQuery("select m from Member m where m.email = :email", Member.class);
        typedQuery.setParameter("email", email);

        try {
            Member member = (Member) typedQuery.getSingleResult();
            return Optional.ofNullable(member);

        } catch (NoResultException e) {

            return Optional.empty();
        }
    }
}
