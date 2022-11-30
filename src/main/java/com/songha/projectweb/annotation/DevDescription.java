package com.songha.projectweb.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/***
 * @Description :: 코드의 기능에 대한 코멘트를 규칙 있게 붙이기 위해 관리용 Annotation 을 생성하였다.
 */

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface DevDescription {
    String description() default "";
}
