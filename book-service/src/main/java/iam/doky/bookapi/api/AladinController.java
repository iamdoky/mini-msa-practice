package iam.doky.bookapi.api;

import iam.doky.bookapi.application.AladinBookService;
import iam.doky.bookapi.payload.request.aladin.AladinBookRequest;
import iam.doky.bookapi.payload.response.aladin.AladinBookResponse;
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

@Tag(name = "알라딘북")
@RequestMapping("/api/aladin")
@RestController
@RequiredArgsConstructor
@Slf4j
public class AladinController {

    private final AladinBookService aladinBookService;

    @Operation(summary = "[알라딘북] 상품 검색 API", description = "[알라딘북] 상품 검색 API")
    @PostMapping(value = "")
    public ResponseEntity<Mono<AladinBookResponse>> search(
            @RequestBody AladinBookRequest request) {

        return ResponseEntity.ok(aladinBookService.search(request));
    }
}
