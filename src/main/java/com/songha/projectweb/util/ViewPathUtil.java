package com.songha.projectweb.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Slf4j
public class ViewPathUtil {

    public static String menuName() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String menuName = request.getRequestURI().split("/")[1];
        String menuViewPathName = "menu/" + menuName;

        log.debug("ViewPathUtil.menuName menuViewPathName->{}", menuViewPathName);

        return menuViewPathName;
    }

}
