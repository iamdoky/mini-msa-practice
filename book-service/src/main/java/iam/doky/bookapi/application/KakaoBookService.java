package iam.doky.bookapi.application;

import iam.doky.bookapi.payload.request.kakao.KakaoSearchRequest;
import iam.doky.bookapi.payload.response.kakao.KakaoBookResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class KakaoBookService {

    @Value("${kakao.api.kakaoAK}")
    private String kakaoAK;

    private final WebClient kakaoWebClient;

    public Mono<KakaoBookResponse> search(KakaoSearchRequest request) {

        return kakaoWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v3/search/book")
                        .queryParam("query", request.query())
                        .queryParam("target", request.target())
                        .build())
                .header("Authorization", "KakaoAK " + kakaoAK)
                .retrieve()
                .bodyToMono(KakaoBookResponse.class);
    }
}
