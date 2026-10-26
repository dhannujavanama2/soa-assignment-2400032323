
package com.klef.soa.docker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.docker.dto.ThemeParkRequest;
import com.klef.soa.docker.entity.ThemePark;
import com.klef.soa.docker.service.ThemeParkService;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/themepark")
@CrossOrigin("*")
public class ThemeParkController {

    @Autowired
    private ThemeParkService service;

    @GetMapping("/")
    public String home() {
        return "ThemePark Service Project";
    }

    @GetMapping("/test")
    public String test() {
        return "Test API Call";
    }

    // Add ThemePark (ID is not included in the request)
    @PostMapping("/add")
    public ResponseEntity<ThemePark> saveThemePark(
            @Valid @RequestBody ThemeParkRequest request) {

        ThemePark themePark = new ThemePark();

        themePark.setParkName(request.getParkName());
        themePark.setLocation(request.getLocation());
        themePark.setRideCount(request.getRideCount());
        themePark.setTicketPrice(request.getTicketPrice());

        ThemePark savedThemePark = service.saveThemePark(themePark);

        return new ResponseEntity<>(
                savedThemePark, HttpStatus.CREATED);
    }

    // Display all ThemeParks
    @GetMapping("/displayall")
    public ResponseEntity<List<ThemePark>> getAllThemeParks() {
        return ResponseEntity.ok(service.getAllThemeParks());
    }

    // Display ThemePark by ID
    @GetMapping("/display/{id}")
    public ResponseEntity<ThemePark> getThemeParkById(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.getThemeParkById(id));
    }

    // Update ThemePark
    @PutMapping("/update/{id}")
    public ResponseEntity<ThemePark> updateThemePark(
            @PathVariable Long id,
            @Valid @RequestBody ThemeParkRequest request) {

        ThemePark themePark = new ThemePark();

        themePark.setParkName(request.getParkName());
        themePark.setLocation(request.getLocation());
        themePark.setRideCount(request.getRideCount());
        themePark.setTicketPrice(request.getTicketPrice());

        return ResponseEntity.ok(
                service.updateThemePark(id, themePark));
    }

    // Delete ThemePark
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteThemePark(
            @PathVariable Long id) {

        service.deleteThemePark(id);

        return ResponseEntity.ok(
                "ThemePark deleted successfully.");
    }
}
