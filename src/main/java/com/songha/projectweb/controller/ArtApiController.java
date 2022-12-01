package com.songha.projectweb.controller;

import com.songha.projectweb.annotation.Logging;
import com.songha.projectweb.domain.art.Art;
import com.songha.projectweb.domain.common.Device;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping(value = "/api/{category:art}")
public class ArtApiController {

    @Logging
    @GetMapping(value = "/{artName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Art> art(@PathVariable String artName, Device device) {
        log.info("ArtApiController.art :: artName->{}", artName);

        Art body = new Art();

        return ResponseEntity.ok(body);
    }
}
