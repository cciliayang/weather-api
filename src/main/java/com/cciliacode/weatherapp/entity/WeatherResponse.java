package com.cciliacode.weatherapp.entity;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WeatherResponse {
    private String weather;
//    private String details;
    private String description;
}
