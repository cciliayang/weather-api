package com.cciliacode.weatherapp.converter;

import com.cciliacode.weatherapp.domain.CityCoordinates;
import com.cciliacode.weatherapp.entity.GeocodingCoordinatesEntity;
import org.springframework.stereotype.Service;

@Service
public class GeocodingCoordinatesMapper {

    public CityCoordinates mapToDomain(final GeocodingCoordinatesEntity entity){
        return CityCoordinates.builder()
                .latitude(entity.getLatitude())
                .longitude(entity.getLongitude())
                .build();
    }
}
