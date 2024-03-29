package com.cciliacode.weatherapp.controller;

import com.cciliacode.weatherapp.domain.WeatherRequestDetails;
import com.cciliacode.weatherapp.entity.WeatherResponse;
import com.cciliacode.weatherapp.service.WeatherService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(WeatherController.class)
class WeatherResourceTest {
    private static final String CITY = "Paris";

    private static final String WEATHER = "Clear";

    private static final String DETAILS = "Clear sky";

    @MockBean
    private WeatherService weatherService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test_should_return_weather_response_success() throws Exception {
        final WeatherRequestDetails weatherRequestDetails = WeatherRequestDetails.builder()
                .city(CITY)
                .build();

        final WeatherResponse weatherResponse = WeatherResponse.builder()
                .weather(WEATHER)
                .description(DETAILS)
                .build();

        when(weatherService.getWeather(weatherRequestDetails)).thenReturn(weatherResponse);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/weather/{city}", CITY)).andDo(print())
                .andExpect(status().isOk());
    }

}