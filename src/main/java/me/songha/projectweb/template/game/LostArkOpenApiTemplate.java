package me.songha.projectweb.template.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Component
public class LostArkOpenApiTemplate {

    @Value("${lostark.access.token}")
    private String token;

    @Value("${lostark.domain.openapi}")
    private String domain;

    private final WebClient webClient = WebClient.builder()
            .baseUrl("https://developer-lostark.game.onstove.com")
            .build();

//    @Autowired
//    public LostArkOpenApiTemplate(@Value("${lostark.access.token}") String token,
//                                  @Value("${lostark.domain.openapi}") String domain,
//                                  WebClient webClient) {
//        this.token = token;
//        this.webClient = WebClient.builder()
//                .baseUrl(domain)
//                .build();
//    }



    public Map getSample(String characterName) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/armories/characters/{characterName}/profiles")
                        .build(characterName))
                .headers(h -> h.setBearerAuth(token))
                .retrieve()
                .bodyToMono(Map.class)
                .block();
    }

}
