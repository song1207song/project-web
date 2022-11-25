package com.songha.projectweb.exception;

import lombok.Data;

@Data
public class ProjectWebException extends RuntimeException {
    private String errorCode;
}
