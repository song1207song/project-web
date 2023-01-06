package me.songha.projectweb.domain.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description :: exception handling의 반환 타입
 */

@Getter
@NoArgsConstructor
public class ErrorResponse {
    private LocalDateTime timestamp = LocalDateTime.now();
    private String message; // 예외 메시지
    private String code; // 예외를 세분화하기 위한 사용자 지정 코드 :: e.g. C001, C002
    private String errorCode; // e.g. exception.PAGE_NOTFOUND
    private int status; // HTTP 상태 값 :: e.g. 400, 404, 500..

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("errors")
    private List<FieldError> fieldErrors; // @Valid의 Parameter 검증을 통과하지 못한 필드가 담긴다.

    public static ErrorResponse create() {
        return new ErrorResponse();
    }

    public ErrorResponse code(String code) {
        this.code = code;
        return this;
    }

    public ErrorResponse errorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public ErrorResponse status(int status) {
        this.status = status;
        return this;
    }

    public ErrorResponse message(String message) {
        this.message = message;
        return this;
    }

    public ErrorResponse errors(Errors errors) {
        this.fieldErrors = errors.getFieldErrors();
        return this;
    }

}
