package me.songha.projectweb.template.game;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

import static me.songha.projectweb.template.game.LostArkOpenApiPathProperties.*;

@Component
public class LostArkOpenApiTemplate {

    @Value("${lostark.access.token}")
    private String token;

    private final WebClient webClient = WebClient.builder()
            .baseUrl(domain)
            .build();

    public Map getProfiles(String characterName) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(armories_profiles)
                        .build(characterName))
                .headers(h -> h.setBearerAuth(token))
                .retrieve()
                .bodyToMono(Map.class)
                .block();
    }

    public Map getCharacters(String characterName) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(characters_siblings)
                        .build(characterName))
                .headers(h -> h.setBearerAuth(token))
                .retrieve()
                .bodyToMono(Map.class)
                .block();
    }

}
