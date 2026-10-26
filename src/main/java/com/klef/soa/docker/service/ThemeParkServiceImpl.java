package com.klef.soa.docker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.docker.entity.ThemePark;
import com.klef.soa.docker.repository.ThemeParkRepository;

@Service
public class ThemeParkServiceImpl implements ThemeParkService
{
    @Autowired
    private ThemeParkRepository repository;

    @Override
    public ThemePark saveThemePark(ThemePark themePark) {

        ThemePark lastThemePark = repository.findTopByOrderByIdDesc();

        if (lastThemePark == null) {
            themePark.setId(1L);
        } else {
            themePark.setId(lastThemePark.getId() + 1);
        }

        return repository.save(themePark);
    }

    @Override
    public List<ThemePark> getAllThemeParks()
    {
        return repository.findAll();
    }

    @Override
    public ThemePark getThemeParkById(Long id)
    {
        return repository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException(
                        "ThemePark not found with id: " + id));
    }

    @Override
    public ThemePark updateThemePark(Long id, ThemePark themePark)
    {
        ThemePark existingThemePark = repository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException(
                        "ThemePark not found with id: " + id));

        existingThemePark.setParkName(themePark.getParkName());
        existingThemePark.setLocation(themePark.getLocation());
        existingThemePark.setRideCount(themePark.getRideCount());
        existingThemePark.setTicketPrice(themePark.getTicketPrice());

        return repository.save(existingThemePark);
    }

    @Override
    public void deleteThemePark(Long id)
    {
        ThemePark themePark = repository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException(
                        "ThemePark not found with id: " + id));

        repository.delete(themePark);
    }
}