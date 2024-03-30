package com.cciliacode.weatherapp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MainEntity {

    @JsonProperty("temp")
    private String temperature;

    @JsonProperty("feels_like")
    private String feelsLike;

    @JsonProperty("temp_min")
    private String tempMin;

    @JsonProperty("temp_max")
    private String tempMax;

    @JsonProperty("pressure")
    private String pressure;

    @JsonProperty("humidity")
    private String humidity;

    @JsonProperty("sea_level")
    private String seaLevel;

    @JsonProperty("grnd_level")
    private String grdLevel;

}
