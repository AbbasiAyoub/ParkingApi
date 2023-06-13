package com.ista.parkingapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Parking {
    @JsonProperty("id")
    private String id;

    @JsonProperty("nom")
    private String name;

    @JsonProperty("adresse")
    private String zone;

    @JsonProperty("info")
    private String status;

    @JsonProperty("nb_places")
    private int spaces;

    private int availableSpaces;

}
