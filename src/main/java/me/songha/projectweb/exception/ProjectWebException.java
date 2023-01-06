package me.songha.projectweb.exception;

import me.songha.projectweb.domain.error.ErrorCode;

/**
 * @Description :: 프로젝트에서 사용할 최상위 custom exception
 */
public class ProjectWebException extends RuntimeException {
    private final ErrorCode errorCode;

    public ProjectWebException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
