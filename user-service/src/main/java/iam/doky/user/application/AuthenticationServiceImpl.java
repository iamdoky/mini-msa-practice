package iam.doky.user.application;

import iam.doky.user.common.util.JwtUtil;
import iam.doky.user.domain.Member;
import iam.doky.user.payload.request.CustomUserInfoDto;
import iam.doky.user.payload.request.LoginRequest;
import iam.doky.user.repository.MemberJPARepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthenticationServiceImpl implements AuthenticationService{

    private final JwtUtil jwtUtil;
    private final MemberJPARepository memberJPARepository;
    private final PasswordEncoder encoder;
    private final ModelMapper modelMapper;

    @Transactional
    public String login(LoginRequest request) {

        String email = request.email();
        String password = request.password();
        Member member = memberJPARepository.findMemberByEmail(email);

        if(member == null) throw new UsernameNotFoundException("이메일이 존재하지 않습니다.");

        // 암호화된 password를 디코딩한 값과 입력한 패스워드 값이 다르면 null 반환
        if(!encoder.matches(password, member.getPassword()))
            throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");

        CustomUserInfoDto info = modelMapper.map(member, CustomUserInfoDto.class);

        return jwtUtil.createAccessToken(info);
    }
}
