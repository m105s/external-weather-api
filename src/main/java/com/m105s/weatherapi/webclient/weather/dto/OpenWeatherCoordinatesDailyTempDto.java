package com.m105s.weatherapi.webclient.weather.dto;

import lombok.Getter;

@Getter
public class OpenWeatherCoordinatesDailyTempDto {

    private double min;
    private double max;
    private double night;
    private double eve;
    private double morn;

}
