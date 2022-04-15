package com.m105s.weatherapi.webclient.weather.dto;

import lombok.Getter;

@Getter
public class OpenWeatherCoordinatesCurrentDto {

    private double temp;
    private double feels_like;
    private int pressure;
    private int humidity;

}
