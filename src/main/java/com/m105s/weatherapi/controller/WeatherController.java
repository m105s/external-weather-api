package com.m105s.weatherapi.controller;

import com.m105s.weatherapi.model.WeatherDto;
import com.m105s.weatherapi.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/weather/{cityName}")
    public WeatherDto getWeather(@PathVariable String cityName) {
        return this.weatherService.getWeather(cityName);
    }

}
