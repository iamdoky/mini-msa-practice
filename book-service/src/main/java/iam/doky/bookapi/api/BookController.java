package iam.doky.bookapi.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "도서")
@RequestMapping("/api/book")
@RestController
@RequiredArgsConstructor
@Slf4j
public class BookController {



}
