package iam.doky.bookapi.api;

import iam.doky.bookapi.application.NaverBookService;
import iam.doky.bookapi.payload.request.naver.NaverSearchRequest;
import iam.doky.bookapi.payload.response.naver.NaverBookResponse;
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

@Tag(name = "네이버")
@RequestMapping("/api/naver")
@RestController
@RequiredArgsConstructor
@Slf4j
public class NaverController {

    private final NaverBookService naverBookService;

    @Operation(summary = "[네이버북] 검색한 대상 저장하기", description = "[네이버북] 검색한 대상을 조회 및 저장")
    @PostMapping(value = "")
    public ResponseEntity<Mono<NaverBookResponse>> search(
            @RequestBody NaverSearchRequest request) {

        return ResponseEntity.ok(naverBookService.search(request));
    }
}
