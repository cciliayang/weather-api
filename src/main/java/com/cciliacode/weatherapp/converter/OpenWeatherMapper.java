package com.cciliacode.weatherapp.converter;

import com.cciliacode.weatherapp.domain.CityWeather;
import com.cciliacode.weatherapp.entity.OpenWeatherResponseEntity;
import com.cciliacode.weatherapp.entity.WeatherResponse;
import org.springframework.stereotype.Service;

@Service
public class OpenWeatherMapper {

    //return a CityWeather object
    public CityWeather convertToCityWeatherDomain(final OpenWeatherResponseEntity entity){
        return CityWeather.builder()
                .weather(entity.getWeather()[0].getMain())
                .details(entity.getWeather()[0].getDescription())
                .build();
    }

    //return a WeatherResponse object
    public WeatherResponse convertToWeatherResponseEntity(final CityWeather cityWeather){
        return WeatherResponse.builder()
                .weather(cityWeather.getWeather())
                .description(cityWeather.getDetails())
                .build();
    }
}
