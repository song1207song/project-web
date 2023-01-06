package me.songha.projectweb.service;

import org.springframework.stereotype.Service;

@Service
public class ArtService implements ProjectWebService {
    private static String CATEGORY_CODE_ART = "ART";

    @Override
    public String getCategoryCode() {
        return CATEGORY_CODE_ART;
    }
}
