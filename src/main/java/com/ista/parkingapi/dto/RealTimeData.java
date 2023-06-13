package com.ista.parkingapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RealTimeData {

    @JsonProperty("id")
    private String parkingId;

    @JsonProperty("nom")
    private String nom;

    @JsonProperty("places")
    private int availableSpaces;
}
