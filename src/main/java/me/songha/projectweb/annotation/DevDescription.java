package me.songha.projectweb.annotation;

import java.lang.annotation.*;

/***
 * @Description :: 코드의 기능에 대한 코멘트를 추후 알아보기 쉽게 붙이기 위해 관리용 Annotation 을 생성하였다.
 */

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface DevDescription {
    String description() default "";
}
