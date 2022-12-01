package com.songha.projectweb.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description :: logging 을 위한 annotation 을 커스텀하였다.
 * 메소드 혹은 클래스 단위로 붙일 수 있게 구성하였다.
 */

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Logging {
}
