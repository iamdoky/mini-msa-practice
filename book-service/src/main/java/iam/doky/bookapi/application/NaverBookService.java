package iam.doky.bookapi.application;

import iam.doky.bookapi.domain.Book;
import iam.doky.bookapi.domain.enums.JoinType;
import iam.doky.bookapi.payload.request.naver.NaverSearchRequest;
import iam.doky.bookapi.payload.response.naver.NaverBookResponse;
import iam.doky.bookapi.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class NaverBookService {

    @Value("${naver.api.client-id}")
    private String clientId;

    @Value("${naver.api.client-secret}")
    private String clientSecret;

    private final WebClient naverWebClient;
    private final BookRepository bookRepository;

    public Mono<NaverBookResponse> search(NaverSearchRequest request) {

        return naverWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v1/search/book.json")
                        .queryParam("query", request.keyword())
                        .queryParam("display", request.display())
                        .queryParam("start", request.display())
                        .build())
                .header("X-Naver-Client-Id", clientId)
                .header("X-Naver-Client-Secret", clientSecret)
                .retrieve()
                .bodyToMono(NaverBookResponse.class)
                .doOnSuccess(this::saveByNaver);
    }

    private void saveByNaver(NaverBookResponse response) {

        response.items()
                .stream()
                .filter(book -> existByIsbn(book.isbn()))
                .map(book -> Book.of(book, JoinType.NAVER))
                .forEach(bookRepository::save);
    }

    private boolean existByIsbn(String isbn) {

        return !bookRepository.existsByIsbn(isbn);
    }
}
