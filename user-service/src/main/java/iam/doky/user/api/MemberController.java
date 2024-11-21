package iam.doky.user.api;

import iam.doky.user.application.MemberService;
import iam.doky.user.domain.Member;
import iam.doky.user.payload.request.MemberRequestRecord;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "회원 API", description = "회원 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/member")
public class MemberController {

    private final MemberService memberService;
    private final ModelMapper modelMapper;

    @Operation(summary = "회원 신규 추가(가입)", description = "새로운 회원을 추가하는 API로, 회원의 정보를 입력받아 저장.")
    @PostMapping("")
    public ResponseEntity<Long> addMember(@Valid @RequestBody MemberRequestRecord request) {

        return ResponseEntity.ok(memberService.join(Member.builder()
                .name(request.name())
                .gender(request.gender())
                .birth(request.birth())
                .mobile(request.mobile())
                .email(request.email())
                .nickName(request.nickname())
                .password(request.password())
                .authType(request.authType())
                .active(request.active())
                .role(request.role())
                .build()));
    }
}