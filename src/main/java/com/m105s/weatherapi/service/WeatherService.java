package com.m105s.weatherapi.service;

import com.m105s.weatherapi.model.WeatherCoordinatesDto;
import com.m105s.weatherapi.model.WeatherDto;
import com.m105s.weatherapi.webclient.weather.WeatherClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherClient weatherClient;

    public WeatherDto getWeather(String city) {
        return weatherClient.getWeatherCity(city);
    }

    public WeatherCoordinatesDto getWeatherForCoordinates(double lat, double lon) {
        return weatherClient.getForecastForCoordinates(lat,lon);
    }

}
