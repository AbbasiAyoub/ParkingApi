package com.ista.parkingapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class RealTimeDataResponse {

    @JsonProperty("records")
    private List<RealTimeParkingRecord> records;
}
