package iam.doky.bookapi.api;

import iam.doky.bookapi.application.KakaoBookService;
import iam.doky.bookapi.payload.request.kakao.KakaoSearchRequest;
import iam.doky.bookapi.payload.response.kakao.KakaoBookResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Tag(name = "카카오")
@RequestMapping("/api/kakao")
@RestController
@RequiredArgsConstructor
@Slf4j
public class KakaoController {

    private final KakaoBookService kakaoBookService;

    @Operation(summary = "[카카오북] 책 검색하기", description = "[카카오북] 책 검색하기")
    @PostMapping(value = "")
    public ResponseEntity<Mono<KakaoBookResponse>> search(
            @RequestBody KakaoSearchRequest request) {

        return ResponseEntity.ok(kakaoBookService.search(request));
    }
}
