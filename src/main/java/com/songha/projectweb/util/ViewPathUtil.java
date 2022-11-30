package com.songha.projectweb.util;

import com.songha.projectweb.annotation.DevDescription;
import com.songha.projectweb.exception.PageNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Slf4j
public class ViewPathUtil {
    @DevDescription(description = "HttpServletRequest에서 templatePath를 가져온다.")
    public static String viewPathName() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String category = request.getRequestURI().split("/")[1]; // path 경로의 첫번째 값이 category
        String viewName = request.getRequestURI().split("/")[2]; // path 경로의 두번째 값이 viewName
        return viewPathName(category, viewName);
    }

    @DevDescription(description = "parameter에서 templatePath를 받아온다.")
    public static String viewPathName(String category, String viewName) {
        String templatePath = getTemplatesPathOrThrow(category, viewName);
        log.info("ViewPathUtil.viewPathName :: templatePath->{}", templatePath);
        return templatePath;
    }

    /**
     * @Description 해당 page가 존재하는지에 대한 여부는 DB를 통해 관리하도록 한다.
     * 관리자용 테이블에 없는 page를 조회할 경우 별도로 커스텀한 PageNotFoundException을 throw 하여
     * exceptionHandler를 통해 정상적으로 404 페이지로 redirect 되도록 관리해주도록 한다.
     */
    private static String getTemplatesPathOrThrow(String category, String viewPathName) {
        boolean isViewNameExist = true; // todo db 조회 구현 필요
        if (!isViewNameExist) {
            log.info("ViewPathUtil.getTemplatesPathOrThrow :: view is not exist. category->{}, viewPathName->{}", category, viewPathName);
            throw new PageNotFoundException();
        }
        return category + "/" + viewPathName;
    }

}
