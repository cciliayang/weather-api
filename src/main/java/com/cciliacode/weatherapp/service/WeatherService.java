package com.cciliacode.weatherapp.service;

import com.cciliacode.weatherapp.domain.CityCoordinates;
import com.cciliacode.weatherapp.domain.CityWeather;
import com.cciliacode.weatherapp.domain.WeatherRequestDetails;
import com.cciliacode.weatherapp.entity.WeatherResponse;
import com.cciliacode.weatherapp.provider.GeocodingProvider;
import com.cciliacode.weatherapp.provider.WeatherProvider;
import com.cciliacode.weatherapp.converter.GeocodingCoordinatesMapper;
import com.cciliacode.weatherapp.converter.OpenWeatherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private GeocodingProvider geocodingProvider;
    private GeocodingCoordinatesMapper geocodingCoordinatesTransformer;

    private OpenWeatherMapper openWeatherTransformer;

    private WeatherProvider weatherProvider;

    @Autowired
    public WeatherService(final GeocodingProvider geocodingProvider, final GeocodingCoordinatesMapper geocodingCoordinatesTransformer, final WeatherProvider weatherProvider, final OpenWeatherMapper openWeatherTransformer){
        this.geocodingProvider = geocodingProvider;
        this.geocodingCoordinatesTransformer = geocodingCoordinatesTransformer;
        this.weatherProvider = weatherProvider;
        this.openWeatherTransformer = openWeatherTransformer;
    }

    public WeatherResponse getWeather(final WeatherRequestDetails weatherRequestDetails) throws Exception {
        //get latitude and longitude
        final CityCoordinates cityCoordinates = geocodingCoordinatesTransformer.mapToDomain(geocodingProvider.getCoordinates(weatherRequestDetails));

        //get weather for geo coordinates
        final CityWeather cityWeather = openWeatherTransformer
                .convertToCityWeatherDomain(weatherProvider.getWeather(cityCoordinates));

        return openWeatherTransformer.convertToWeatherResponseEntity(cityWeather);
    }
}
