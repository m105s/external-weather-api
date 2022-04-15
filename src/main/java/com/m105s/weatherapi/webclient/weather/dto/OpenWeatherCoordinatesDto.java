package com.m105s.weatherapi.webclient.weather.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class OpenWeatherCoordinatesDto {

    private OpenWeatherCoordinatesCurrentDto current;
    private List<OpenWeatherCoordinatesDailyDto> daily;
}
