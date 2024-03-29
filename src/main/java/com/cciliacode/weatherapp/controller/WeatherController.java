package com.cciliacode.weatherapp.controller;

import com.cciliacode.weatherapp.domain.WeatherRequestDetails;
import com.cciliacode.weatherapp.entity.WeatherResponse;
import com.cciliacode.weatherapp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather/{city}")
    public ResponseEntity <WeatherResponse> getWeather(@PathVariable("city") String city) throws Exception {
        WeatherRequestDetails weatherRequestDetails = WeatherRequestDetails.builder()
                .city(city)
                .build();
        WeatherResponse weatherResponse = weatherService.getWeather(weatherRequestDetails);
        return ResponseEntity.ok(weatherResponse);
    }
}
