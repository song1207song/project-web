package com.songha.projectweb.aspect;

import com.songha.projectweb.service.ProjectWebService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class GameAspect extends AbstractProjectWebAspect {

    @Override
    @Autowired
    @Qualifier("gameService")
    protected void setProjectWebService(ProjectWebService projectWebService) {
        this.projectWebService = projectWebService;
    }

    @Override
    protected void setCategoryPointCut() {

    }
}
