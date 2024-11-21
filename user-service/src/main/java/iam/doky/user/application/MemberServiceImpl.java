package iam.doky.user.application;

import iam.doky.user.domain.Member;
import iam.doky.user.repository.MemberRepository;
import jakarta.ws.rs.NotFoundException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder encoder;

    @Transactional
    public Long join(Member member) {

        Optional<Member> vailMember = memberRepository.findByEmail(member.getEmail());
        if (vailMember.isPresent()) {
            throw new NotFoundException("This member email is already exist. " + member.getEmail());
        }

        // 비밀번호 해시 처리
        member.encodePassword(encoder.encode(member.getPassword()));
        memberRepository.create(member);

        return member.getId();
    }
}
