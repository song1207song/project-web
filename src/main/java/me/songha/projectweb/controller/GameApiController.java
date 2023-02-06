package me.songha.projectweb.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.songha.projectweb.annotation.Logging;
import me.songha.projectweb.domain.common.Device;
import me.songha.projectweb.template.game.LostArkOpenApiTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping(value = "/api/{category:game}")
public class GameApiController {
    private final LostArkOpenApiTemplate lostArkOpenApiTemplate;

    @Logging
    @GetMapping(value = "/lostark/armories/{characterName}/profiles", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map> getProfiles(@PathVariable String characterName, Device device) {
        log.info("GameApiController.getProfiles :: characterName->{}", characterName);
        return ResponseEntity.ok(lostArkOpenApiTemplate.getProfiles(characterName));
    }

    @Logging
    @GetMapping(value = "/lostark/characters/{characterName}/siblings", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map> getCharacters(@PathVariable String characterName, Device device) {
        log.info("GameApiController.getCharacters :: characterName->{}", characterName);
        return ResponseEntity.ok(lostArkOpenApiTemplate.getCharacters(characterName));
    }

}
