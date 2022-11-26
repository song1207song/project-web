package com.songha.projectweb.exception;

import com.songha.projectweb.domain.error.ErrorCode;

/**
 * @Description :: client 단의 요청 값이 잘못되었을 경우 exception
 */

public class BadRequestException extends ProjectWebException {
    public BadRequestException() {
        super(ErrorCode.BAD_REQUEST);
    }
}
