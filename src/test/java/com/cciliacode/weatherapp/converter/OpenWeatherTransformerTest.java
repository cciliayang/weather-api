package com.cciliacode.weatherapp.converter;

import com.cciliacode.weatherapp.domain.CityWeather;
import com.cciliacode.weatherapp.entity.OpenWeatherResponseEntity;
import com.cciliacode.weatherapp.entity.WeatherEntity;
import com.cciliacode.weatherapp.entity.WeatherResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OpenWeatherTransformerTest {

    private OpenWeatherMapper transformer;

    @BeforeEach
    public void setup(){
        transformer = new OpenWeatherMapper();
    }

    @Test
    public void test_should_transform_open_weather_response_entity_to_domain(){
        final WeatherEntity weather = WeatherEntity.builder()
                .main("Rain")
                .description("A lot of rain")
                .build();

        final WeatherEntity[] weatherEntities = {weather};
        final OpenWeatherResponseEntity entity = OpenWeatherResponseEntity
                .builder()
                .weather(weatherEntities)
                .build();

        final CityWeather cityWeather = transformer.convertToCityWeatherDomain(entity);

        assertAll("Should return domain weather object",
                ()->assertEquals(entity.getWeather()[0].getMain(), cityWeather.getWeather()),
                ()-> assertEquals(entity.getWeather()[0].getDescription(), cityWeather.getDetails()));

    }

    @Test
    public void test_should_transform_city_weather_to_entity(){
        final CityWeather cityWeather = CityWeather.builder()
                .weather("Rain")
                .details("A lot of rain")
                .build();

        final WeatherResponse weatherResponse = transformer.convertToWeatherResponseEntity(cityWeather);

        assertAll("Should return entity weather response object",
                ()-> assertEquals(cityWeather.getWeather(), weatherResponse.getWeather()),
                ()-> assertEquals(cityWeather.getDetails(), weatherResponse.getDescription()));
    }

}