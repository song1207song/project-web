package me.songha.projectweb.controller;

import me.songha.projectweb.util.ViewPathUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
public class IndexController {

    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView index(ModelAndView modelAndView, HttpServletRequest request) {
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping(value = "/{category}/{viewName}", produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView indexByViewName(ModelAndView modelAndView, HttpServletRequest request,
                                        @PathVariable String category, @PathVariable String viewName) {
        log.info("IndexController.indexByViewName :: category->{}, viewName->{}", category, viewName);
        String viewPathName = ViewPathUtil.viewPathName(category, viewName);
        modelAndView.setViewName(viewPathName);
        return modelAndView;
    }

    @GetMapping(value = "/error/404", produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView indexError(ModelAndView modelAndView, HttpServletRequest request) {
        modelAndView.setViewName("error/404");
        return modelAndView;
    }
}
