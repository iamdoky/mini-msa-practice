package iam.doky.bookapi.error;

import java.util.Arrays;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Errors {
    ERRORS_MESSAGE(1000, "에러 메시지.");


    private final int code;
    private final String message;

    public String getCodeMessage() {
        return String.format("%s, %s", this.code, this.message);
    }

    public static Optional<Errors> codeOf(int code) {
        return Arrays.stream(values()).filter(val -> val.getCode() == code).findFirst();
    }
}
