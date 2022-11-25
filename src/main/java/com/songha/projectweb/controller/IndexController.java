package com.songha.projectweb.controller;

import com.songha.projectweb.util.ViewPathUtil;
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

    @GetMapping(value = "/{name}", produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView indexByName(ModelAndView modelAndView, HttpServletRequest request, @PathVariable String name) {
        log.debug("IndexController.indexByName :: name->{}", name);
        String pageName = ViewPathUtil.menuName();
        modelAndView.setViewName(pageName);
        return modelAndView;
    }
}
