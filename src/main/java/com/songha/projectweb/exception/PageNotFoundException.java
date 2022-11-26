package com.songha.projectweb.exception;

import com.songha.projectweb.domain.error.ErrorCode;

/**
 * @Description :: 찾을 수 없는 페이지 요청 시 exception
 */

public class PageNotFoundException extends ProjectWebException {
    public PageNotFoundException() {
        super(ErrorCode.PAGE_NOT_FOUND);
    }
}
