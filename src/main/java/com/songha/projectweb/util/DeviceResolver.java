package com.songha.projectweb.util;

import com.songha.projectweb.domain.common.Device;
import lombok.NoArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @Description :: 파라미터에 입력되는 공통 인자들의 중복된 코드를 하나의 작업으로 통일시켜주기 위해
 * HandlerMethodArgumentResolver 를 사용, 해당 구현체를 Bean 주입하여 사용한다.
 * - 아래의 코드는 접속한 환경의 device 를 구분하기 위한 것이다.
 */

@NoArgsConstructor
public class DeviceResolver implements HandlerMethodArgumentResolver {
    @Override
    public Device resolveArgument(MethodParameter methodParameter
            , ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest
            , WebDataBinderFactory webDataBinderFactory) throws Exception {

        // todo : data set

        return new Device();
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(Device.class);
    }
}
