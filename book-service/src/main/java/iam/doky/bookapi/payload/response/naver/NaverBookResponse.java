package iam.doky.bookapi.payload.response.naver;

import java.util.List;

public record NaverBookResponse(

        String lastBuildDate,
        int total,
        int start,
        int display,
        List<NaverSearchResponse> items) {

}
