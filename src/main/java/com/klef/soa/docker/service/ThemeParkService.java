package com.klef.soa.docker.service;

import java.util.List;

import com.klef.soa.docker.entity.ThemePark;

public interface ThemeParkService
{
    ThemePark saveThemePark(ThemePark themePark);

    List<ThemePark> getAllThemeParks();

    ThemePark getThemeParkById(Long id);

    ThemePark updateThemePark(Long id, ThemePark themePark);

    void deleteThemePark(Long id);
}