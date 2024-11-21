package iam.doky.bookapi.api;

import iam.doky.bookapi.application.MemberService;
import iam.doky.bookapi.domain.Member;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "회원")
@RequestMapping("/api/member")
@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @Operation(summary = "회원 조회", description = "전체 회원을 조회 합니다.")
    @GetMapping(value = "")
    public ResponseEntity<List<Member>> get() {

        return ResponseEntity.ok(memberService.getAll());
    }
}
