package com.ista.parkingapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ista.parkingapi.entity.Parking;
import lombok.Data;

@Data
public class ParkingRecords {

    @JsonProperty("fields")
    private Parking parking;
}
