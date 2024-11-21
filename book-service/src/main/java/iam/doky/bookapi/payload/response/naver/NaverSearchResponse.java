package iam.doky.bookapi.payload.response.naver;


public record NaverSearchResponse(

        String title,
        String link,
        String image,
        String author,
        String discount,
        String publisher,
        String pubdate,
        String isbn,
        String description) {
}
