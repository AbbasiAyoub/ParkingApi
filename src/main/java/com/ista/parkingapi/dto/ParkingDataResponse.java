package com.ista.parkingapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ParkingDataResponse {

    @JsonProperty("records")
    private List<ParkingRecords> records;

}
