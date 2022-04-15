package com.m105s.weatherapi.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WeatherCoordinatesDto {

    private double temperature;
    private double windchillFactor;
    private int pressure;
    private int humidity;


}
