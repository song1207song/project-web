package me.songha.projectweb.service;

import org.springframework.stereotype.Service;

@Service
public class GameService implements ProjectWebService {
    private static String CATEGORY_CODE_GAME = "GAME";

    @Override
    public String getCategoryCode() {
        return CATEGORY_CODE_GAME;
    }
}
