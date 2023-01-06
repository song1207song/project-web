package me.songha.projectweb.domain.error;

import lombok.Getter;

/***
 * @Description :: 프로젝트 내에서 throw할 exception 종류를 enum으로 관리하였다.
 */

@Getter
public enum ErrorCode {
    PAGE_NOT_FOUND(404, "C001", "exception.PAGE_NOTFOUND", "Page is not found"),
    BAD_REQUEST(400, "C002", "exception.BAD_REQUEST", "Invalid request data");

    private final int status;
    private final String code;
    private final String errorCode;
    private final String message;

    ErrorCode(int status, String code, String errorCode, String message) {
        this.status = status;
        this.code = code;
        this.errorCode = errorCode;
        this.message = message;
    }
}
