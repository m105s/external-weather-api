package com.m105s.weatherapi.webclient.weather;

import com.m105s.weatherapi.model.WeatherCoordinatesDto;
import com.m105s.weatherapi.model.WeatherDto;
import com.m105s.weatherapi.webclient.weather.dto.OpenWeatherCoordinatesCurrentDto;
import com.m105s.weatherapi.webclient.weather.dto.OpenWeatherCoordinatesDto;
import com.m105s.weatherapi.webclient.weather.dto.OpenWeatherDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherClient {

    private static final String WEATHER_URL = "https://api.openweathermap.org/data/2.5";
    private static final String API_KEY = "fd7593ca0dc865ea9c75bfae79d507fc";
    private RestTemplate restTemplate = new RestTemplate();

    public WeatherDto getWeatherCity(String city) {
        OpenWeatherDto openWeatherDto = callGetMethod("/weather?q={city}&appid={apiKey}&units=metric&lang=pl",
                OpenWeatherDto.class,
                city, API_KEY);

        return WeatherDto.builder()
                .temperature(openWeatherDto.getMain().getTemp())
                .pressure(openWeatherDto.getMain().getPressure())
                .humidity(openWeatherDto.getMain().getHumidity())
                .windSpeed(openWeatherDto.getWind().getSpeed())
                .build();

    }

    public WeatherCoordinatesDto getForecastForCoordinates(double lat, double lon) {
        OpenWeatherCoordinatesDto openWeatherCoordinatesDto = callGetMethod("/onecall?lat={lat}&lon={lon}&units=metric&exclude=minutely,hourly&appid={apiKey}",
                OpenWeatherCoordinatesDto.class,
                lat, lon, API_KEY);

        return WeatherCoordinatesDto.builder()
                .temperature(openWeatherCoordinatesDto.getCurrent().getTemp())
                .windchillFactor(openWeatherCoordinatesDto.getCurrent().getFeels_like())
                .pressure(openWeatherCoordinatesDto.getCurrent().getPressure())
                .humidity(openWeatherCoordinatesDto.getCurrent().getHumidity())
                .build();
    }

    private <T> T callGetMethod(String url, Class<T> responseType, Object... objects) {
        return restTemplate.getForObject(WEATHER_URL + url, responseType, objects);
    }

}
