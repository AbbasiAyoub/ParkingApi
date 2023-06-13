package com.ista.parkingapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RealTimeParkingRecord {
    @JsonProperty("fields")
    private RealTimeData realTimeData;
}
