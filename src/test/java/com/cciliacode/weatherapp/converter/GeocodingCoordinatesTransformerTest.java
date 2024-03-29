package com.cciliacode.weatherapp.converter;

import com.cciliacode.weatherapp.domain.CityCoordinates;
import com.cciliacode.weatherapp.entity.GeocodingCoordinatesEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeocodingCoordinatesTransformerTest {

    private GeocodingCoordinatesMapper transformer;

    @BeforeEach
    public void setup(){
        transformer = new GeocodingCoordinatesMapper();
    }

    @Test
    public void test_should_transform_geocoding_coordinates_to_main(){
        final GeocodingCoordinatesEntity entity =
                GeocodingCoordinatesEntity.builder()
                        .longitude("12.0")
                        .latitude("-12.0")
                        .build();
        final CityCoordinates cityCoordinates = transformer.mapToDomain(entity);

        assertAll("Should return domain city coordinates:",
                ()-> assertEquals(entity.getLatitude(), cityCoordinates.getLatitude()),
                ()-> assertEquals(entity.getLongitude(), cityCoordinates.getLongitude()));
    }
}